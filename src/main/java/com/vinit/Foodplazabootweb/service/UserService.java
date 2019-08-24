package com.vinit.Foodplazabootweb.service;

import java.util.List;

import com.vinit.Foodplazabootweb.dto.RoleDTO;
import com.vinit.Foodplazabootweb.dto.UserDTO;
import com.vinit.Foodplazabootweb.model.UserModel;

public interface UserService {

	UserDTO findByUserId(int id);

	List<UserModel> findAllUsers();

	UserDTO saveUser(UserDTO user);

	boolean deleteByUserId(int id);

	List<RoleDTO> getRolesByUserId(int userId);
}
