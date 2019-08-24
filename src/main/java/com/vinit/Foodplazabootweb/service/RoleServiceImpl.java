package com.vinit.Foodplazabootweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vinit.Foodplazabootweb.dao.RoleDao;
import com.vinit.Foodplazabootweb.dto.RoleDTO;
import com.vinit.Foodplazabootweb.mapper.RoleMapper;
import com.vinit.Foodplazabootweb.model.RoleModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

	@Autowired
	@Qualifier("roleDaoJpaImpl")
	private RoleDao roleDao;

	@Override
	public RoleDTO findByRoleId(int id) {
		RoleModel role = roleDao.findByRoleId(id);
		RoleDTO roleDTO = RoleMapper.INSTANCE.roleToRoleDto(role);
		return roleDTO;
	}

	@Override
	public List<RoleDTO> findAllRoles() {

		List<RoleModel> roleList = roleDao.findAllRoles();

		List<RoleDTO> roleDTOList = RoleMapper.INSTANCE.convertRoleListToRoleDTOList(roleList);

		return roleDTOList;
	}

	@Override
	public RoleDTO saveRole(RoleDTO roleDTO) {
		log.info("Start: saveRole(");

		RoleModel role = RoleMapper.INSTANCE.roleDtoToRole(roleDTO);

		if (roleDao.saveRole(role) > 0) {
			return roleDTO;
		} else {
			log.error("Unable to save role: {}", role);
			return null;
		}
	}

	@Override
	public boolean deleteByRoleId(int id) {

		return roleDao.deleteByRoleId(id) == 1;
	}

}
