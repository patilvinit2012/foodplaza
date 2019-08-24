package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vinit.Foodplazabootweb.model.RoleModel;

@Repository
public class RoleDaoJdbcTempImpl implements RoleDao {

	@Autowired
	private JdbcTemplate template;

	@Value("${role.findByRoleIdSQL}")
	private String findByRoleIdSQL;

	@Value("${role.findAllRolesSQL}")
	private String findAllRolesSQL;

	@Value("${role.insertRoleSQL}")
	private String insertRoleSQL;

	@Value("${role.deleteByRoleIdSQL}")
	private String deleteByRoleIdSQL;

	@Override
	public RoleModel findByRoleId(int id) {
		return template.queryForObject(findByRoleIdSQL, new BeanPropertyRowMapper<>(RoleModel.class), id);
	}

	@Override
	public List<RoleModel> findAllRoles() {
		return template.query(findAllRolesSQL, new BeanPropertyRowMapper<>(RoleModel.class));
	}

	@Override
	public int saveRole(RoleModel role) {
		return template.update(insertRoleSQL, role.getRoleName());
	}

	@Override
	public int deleteByRoleId(int id) {
		return template.update(deleteByRoleIdSQL, id);
	}

}
