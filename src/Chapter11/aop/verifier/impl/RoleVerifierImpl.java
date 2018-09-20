package Chapter11.aop.verifier.impl;

import Chapter11.aop.verifier.RoleVerifier;
import Chapter11.game.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier {
	@Override
	public boolean verify(Role role) {
		System.out.println("引入，检测一下角色是否为空");
		return role != null;
	}
}
