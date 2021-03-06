package Chapter12.mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import Chapter12.pojo.Role;
@Repository
public interface RoleMapper {
	public int insertRole(Role role);
	public Role getRole(@Param("id") Long id);
	public int updateRole(Role role);
	public int deleteRole(@Param("id") Long id);
}