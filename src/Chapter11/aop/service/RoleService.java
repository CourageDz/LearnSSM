package Chapter11.aop.service;

import Chapter11.game.pojo.Role;

public interface RoleService {
	
	public void printRole(Role role);
	
	public void printRole(Role role, int sort);
}
