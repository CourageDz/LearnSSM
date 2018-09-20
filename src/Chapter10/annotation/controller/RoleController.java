package Chapter10.annotation.controller;
import Chapter10.annotation.service.RoleService;
import Chapter10.annotation.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class RoleController {
	
	@Autowired
	private RoleService roleService = null;
	
	public void printRole(Role role) {
		roleService.printRoleInfo(role);
	}
}