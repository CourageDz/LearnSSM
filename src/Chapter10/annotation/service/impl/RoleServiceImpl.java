package Chapter10.annotation.service.impl;

import Chapter10.annotation.pojo.Role;
import Chapter10.annotation.service.RoleService;
import org.springframework.stereotype.Component;


@Component("roleService")
public class RoleServiceImpl implements RoleService {
	@Override
	public void printRoleInfo(Role role) {
		System.out.println("InRoleServiceImpl" );
		System.out.println("id =" + role.getId());
		System.out.println("roleName =" + role.getRoleName());
		System.out.println("note =" + role.getNote());
	}
}