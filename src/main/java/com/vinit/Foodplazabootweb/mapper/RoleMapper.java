package com.vinit.Foodplazabootweb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vinit.Foodplazabootweb.dto.RoleDTO;
import com.vinit.Foodplazabootweb.model.RoleModel;

@Mapper
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	RoleDTO roleToRoleDto(RoleModel role);

	RoleModel roleDtoToRole(RoleDTO roleDTO);

	List<RoleDTO> convertRoleListToRoleDTOList(List<RoleModel> roleList);

}
