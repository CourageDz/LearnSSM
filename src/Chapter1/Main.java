package Chapter1;

import Chapter1.mapper.RoleMapper;
import Chapter1.pojo.Role;
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
            Role role =roleMapper.getRole((long)1);
            log.info(role.getRoleName());
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
