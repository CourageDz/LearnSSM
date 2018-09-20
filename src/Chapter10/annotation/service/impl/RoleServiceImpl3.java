package Chapter10.annotation.service.impl;

import Chapter10.annotation.pojo.Role;
import Chapter10.annotation.service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("roleService3")
@Primary
public class RoleServiceImpl3 implements RoleService {
	
	@Override
	public void printRoleInfo(Role role) {
		System.out.print("InRoleServiceImpl3" );
		System.out.print("{id =" + role.getId());
		System.out.print(", roleName =" + role.getRoleName());
		System.out.println(", note =" + role.getNote() + "}");
	}
}