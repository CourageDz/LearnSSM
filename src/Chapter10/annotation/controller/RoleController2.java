package Chapter10.annotation.controller;

import Chapter10.annotation.pojo.Role;
import Chapter10.annotation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class RoleController2 {
	
	private RoleService roleService = null;
	
	public RoleController2(@Autowired @Qualifier("roleService") RoleService roleService) {
	    this.roleService = roleService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService( RoleService roleService) {
		this.roleService = roleService;
	}
	
	public void printRole(Role role) {
		roleService.printRoleInfo(role);
	}
}
