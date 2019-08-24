package com.vinit.Foodplazabootweb.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDTO {

	private int userId;

	private String userName;

	private String password;

	private String firstName;

	private String lastName;
	
	private String roleStr;

	private List<RoleDTO> roles;

}
