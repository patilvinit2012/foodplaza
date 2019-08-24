package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import com.vinit.Foodplazabootweb.model.RoleModel;
import com.vinit.Foodplazabootweb.model.UserModel;

public interface UserDao {

	UserModel findByUserId(int id);

	List<UserModel> findAllUsers();

	int saveUser(UserModel user);

	int deleteByUserId(int id);

	List<RoleModel> findRolesByUserId(int userId);

}
