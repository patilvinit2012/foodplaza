package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vinit.Foodplazabootweb.model.RoleModel;
import com.vinit.Foodplazabootweb.model.UserModel;

@Repository
public class UserDaoJdbcTempImpl implements UserDao {

	@Autowired
	private JdbcTemplate template;

	@Value("${user.findByUserIdSQL}")
	private String findByUserIdSQL;

	@Value("${user.findAllUsersSQL}")
	private String findAllUsersSQL;

	@Value("${user.insertUserSQL}")
	private String insertUserSQL;

	@Value("${user.deleteByUserIdSQL}")
	private String deleteByUserIdSQL;

	@Override
	public UserModel findByUserId(int id) {
		return template.queryForObject(findByUserIdSQL, new BeanPropertyRowMapper<>(UserModel.class), id);
	}

	@Override
	public List<UserModel> findAllUsers() {
		return template.query(findAllUsersSQL, new BeanPropertyRowMapper<>(UserModel.class));
	}

	@Override
	public int saveUser(UserModel user) {
		return template.update(insertUserSQL, user.getFirstName(), user.getLastName(), user.getUserName(),
				user.getPassword());
	}

	@Override
	public int deleteByUserId(int id) {
		return template.update(deleteByUserIdSQL, id);
	}

	@Override
	public List<RoleModel> findRolesByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
