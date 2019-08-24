package com.vinit.Foodplazabootweb.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vinit.Foodplazabootweb.dto.RoleDTO;
import com.vinit.Foodplazabootweb.dto.UserDTO;
import com.vinit.Foodplazabootweb.model.UserModel;

@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDTO userToUserDto(UserModel user);

	UserModel userDtoToUser(UserDTO userDTO);
}

abstract class UserMapperDecorator implements UserMapper {

	private final UserMapper delegate;

	public UserMapperDecorator(UserMapper delegate) {
		this.delegate = delegate;
	}

	@Override
	public UserModel userDtoToUser(UserDTO userDTO) {
		System.out.println("inside userDtoToUser");

		setRoles(userDTO);

		UserModel userModel = delegate.userDtoToUser(userDTO);

		return userModel;
	}

	private void setRoles(UserDTO userDTO) {
		String roleStr = userDTO.getRoleStr();

		List<RoleDTO> roles = new ArrayList<>();

		if (roleStr != null) {
			List<String> roleIds = Arrays.asList(roleStr.split(","));

			for (String roleId : roleIds) {

				RoleDTO role = new RoleDTO();
				role.setRoleId(new Integer(roleId));
				roles.add(role);
			}

			if (roles.isEmpty()) {

				RoleDTO defaultRole = new RoleDTO();
				defaultRole.setRoleId(1);// Set default role USER
				roles.add(defaultRole);
			}

			userDTO.setRoles(roles);
		}
	}
}