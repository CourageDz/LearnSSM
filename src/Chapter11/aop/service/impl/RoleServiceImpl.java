package Chapter11.aop.service.impl;

import org.springframework.stereotype.Component;

import Chapter11.aop.service.RoleService;
import Chapter11.game.pojo.Role;

@Component
public class RoleServiceImpl implements RoleService {
	
	@Override
	public void printRole(Role role) {
		System.out.println("{id: " + role.getId() + ", " 
	        + "role_name : " + role.getRoleName() + ", "
	        + "note : " + role.getNote() + "}");
	}
	
	@Override
	public void printRole(Role role, int sort) {
		System.out.println("{id: " + role.getId() + ", " 
	        + "role_name : " + role.getRoleName() + ", "
	        + "note : " + role.getNote() + "}");
		System.out.println(sort);
	}
}
