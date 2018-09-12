package Chapter1;

import Chapter1.mapper.RoleMapper;
import Chapter1.pojo.Role;
import Chapter1.utils.SqlSessionFactoryByCode;
import Chapter1.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("Main.class");
        SqlSession sqlSession =null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper =sqlSession.getMapper(RoleMapper.class);
            Role role =roleMapper.getRole((long)2);
            System.out.println(role.toString());
            log.info(role.toString());
            Role role2 =new Role();
            role2.setNote("这是第三个角色");
            role2.setRoleName("王二");
            roleMapper.insertRole(role2);
            roleMapper.updateRole(role2);
            Role role2get=roleMapper.getRole((long)3);
            System.out.println(role2.toString());
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
