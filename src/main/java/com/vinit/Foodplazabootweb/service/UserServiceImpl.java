package com.vinit.Foodplazabootweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinit.Foodplazabootweb.dao.UserDao;
import com.vinit.Foodplazabootweb.dto.RoleDTO;
import com.vinit.Foodplazabootweb.dto.UserDTO;
import com.vinit.Foodplazabootweb.mapper.RoleMapper;
import com.vinit.Foodplazabootweb.mapper.UserMapper;
import com.vinit.Foodplazabootweb.model.RoleModel;
import com.vinit.Foodplazabootweb.model.UserModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDaoJpaImpl")
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDTO findByUserId(int id) {
		UserModel user = userDao.findByUserId(id);
		UserDTO userDTO = UserMapper.INSTANCE.userToUserDto(user);
		return userDTO;
	}

	@Override
	public List<UserModel> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		log.info("Start: saveUser()");

		userDTO.setPassword(encoder.encode(userDTO.getPassword()));

		UserModel user = UserMapper.INSTANCE.userDtoToUser(userDTO);

		if (userDao.saveUser(user) > 0) {
			return userDTO;
		} else {
			log.error("Unable to save user: {}", user);
			return null;
		}
	}

	@Override
	public boolean deleteByUserId(int id) {

		return userDao.deleteByUserId(id) == 1;
	}

	@Override
	public List<RoleDTO> getRolesByUserId(int userId) {

		List<RoleModel> roleList = userDao.findRolesByUserId(userId);

		List<RoleDTO> roleDTOList = RoleMapper.INSTANCE.convertRoleListToRoleDTOList(roleList);

		return roleDTOList;
	}
}
