package Chapter1.utils;

import Chapter1.mapper.RoleMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class SqlSessionFactoryByCode {
    private final static Class<SqlSessionFactoryUtils> LOCK =SqlSessionFactoryUtils.class;
    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryByCode(){}
    public static  SqlSessionFactory getSqlSessionFactoryByCode(){
        synchronized (LOCK){
            if(sqlSessionFactory!=null){
                return sqlSessionFactory;
            }
            PooledDataSource dataSource =new PooledDataSource();
            dataSource.setDriver("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("39013348");
            dataSource.setUrl("jdbc:mysql://localhost:3306/SSM?useSSL=false &serverTimezone=UTC");
            dataSource.setDefaultAutoCommit(false);
            //采用JDBC事务
            TransactionFactory transactionFactory =new JdbcTransactionFactory();
            Environment environment =new Environment("development",transactionFactory,dataSource);
            //创建Configuration对象
            Configuration configuration = new Configuration(environment);
            configuration.getTypeAliasRegistry().registerAlias("role",Chapter1.pojo.Role.class);
            //加入映射器
            configuration.addMapper(RoleMapper.class);
            //使用SqlSessionFactoryBuilder 构建SqlSessionFactory
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(configuration);
            return sqlSessionFactory;
        }
    }
    public static SqlSession openSqlSession(){
        if(sqlSessionFactory ==null){
            sqlSessionFactory=getSqlSessionFactoryByCode();
        }
        return sqlSessionFactory.openSession();
    }
}
