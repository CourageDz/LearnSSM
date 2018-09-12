package Chapter1.mapper;

import Chapter1.pojo.Role;

public interface RoleMapper {
    public Role getRole(Long id);
    public int deleteRole(Integer id);
    public int insertRole(Role role);
    public int updateRole(Role role);
}
