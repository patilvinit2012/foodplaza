package com.vinit.Foodplazabootweb.service;

import java.util.List;

import com.vinit.Foodplazabootweb.dto.RoleDTO;

public interface RoleService {

	RoleDTO findByRoleId(int id);

	List<RoleDTO> findAllRoles();

	RoleDTO saveRole(RoleDTO role);

	boolean deleteByRoleId(int id);

}
