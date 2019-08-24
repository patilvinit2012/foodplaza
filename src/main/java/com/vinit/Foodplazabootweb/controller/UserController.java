package com.vinit.Foodplazabootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vinit.Foodplazabootweb.dto.RoleDTO;
import com.vinit.Foodplazabootweb.dto.UserDTO;
import com.vinit.Foodplazabootweb.service.RoleService;
import com.vinit.Foodplazabootweb.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@GetMapping("all")
	public String getAllusers(Model model) {

		model.addAttribute("users", userService.findAllUsers());
		return "user/allUsers";
	}

	@GetMapping("add")
	public String addUser(Model model) {

		UserDTO user = new UserDTO();

		user.setRoles(roleService.findAllRoles());

		model.addAttribute("user", user);
		return "user/add";
	}

	@PostMapping("add")
	public String saveUser(@ModelAttribute UserDTO userDTO) {

		userService.saveUser(userDTO);
		return "redirect:all";
	}

	@ResponseBody
	@GetMapping("{id}")
	public UserDTO getUserByUserId(@PathVariable int id) {

		return userService.findByUserId(id);
	}

	@ResponseBody
	@DeleteMapping("{id}")
	public boolean deleteUserByUserId(@PathVariable int id) {

		return userService.deleteByUserId(id);
	}

	@ResponseBody
	@GetMapping("roles/{userId}")
	public List<RoleDTO> getRolesByUserId(@PathVariable int userId) {

		return userService.getRolesByUserId(userId);
	}
}
