package Chapter1.mapper;

import Chapter1.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper2 {
    //通过注解实现映射器,等同于XML方式创建映射器
    @Select("select id ,role_name as roleName ,note from t_role where id =#{id}")
    public Role getRole(Long id);
}
