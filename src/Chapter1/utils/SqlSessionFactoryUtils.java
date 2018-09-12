package Chapter1.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    //加锁，防止多线程的时候被多次实例化
    private final static Class<SqlSessionFactoryUtils> LOCK =SqlSessionFactoryUtils.class;
    private static SqlSessionFactory sqlSessionFactory =null;

    private SqlSessionFactoryUtils(){}
    //通过XML创建SqlSessionFacory
    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            if(sqlSessionFactory!=null){
                return sqlSessionFactory;
            }
            String resource ="Chapter1/mapper/mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException e){
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory ==null){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
