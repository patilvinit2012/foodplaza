package com.vinit.Foodplazabootweb.dao;

import java.util.List;

import com.vinit.Foodplazabootweb.model.RoleModel;

public interface RoleDao {

	RoleModel findByRoleId(int id);

	List<RoleModel> findAllRoles();

	int saveRole(RoleModel role);

	int deleteByRoleId(int id);

}
