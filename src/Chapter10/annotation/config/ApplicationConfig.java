package Chapter10.annotation.config;

import java.util.Properties;

import javax.sql.DataSource;

import Chapter10.annotation.condition.DataSourceCondition;
import Chapter10.annotation.pojo.JuiceMaker2;
import Chapter10.annotation.pojo.Role;
import Chapter10.annotation.pojo.Source;
import Chapter10.annotation.service.impl.RoleServiceImpl;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@ComponentScan(basePackageClasses = { Role.class, RoleServiceImpl.class },
excludeFilters = {@Filter(type = FilterType.REGEX, pattern="Chapter10.annotation.config.AutowiredConfig")})
// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo",
// "com.ssm.chapter10.annotation.service"})
// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo",
// "com.ssm.chapter10.annotation.service"},
// basePackageClasses = {Role.class, RoleServiceImpl.class})

//测试test8的时候引入下面的XML，同时注释现有数据库连接池的方法
//@ImportResource({"classpath:spring-dataSource.xml"})
@PropertySource(value={"classpath:Chapter10/database-config.properties"}, ignoreResourceNotFound=true)
public class ApplicationConfig {
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/***
	 * 测试test8的时候需要注释掉整个datasource，否则会抛异常
	 */
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		Properties props = new Properties();
//		props.setProperty("driver", "com.mysql.cj.jdbc.Driver");
//		props.setProperty("url", "jdbc:mysql://localhost:3306/SSM?useSSL=false &serverTimezone=UTC");
//		props.setProperty("username", "root");
//		props.setProperty("password", "39013348");
//		DataSource dataSource = null;
//		try {
//			dataSource = BasicDataSourceFactory.createDataSource(props);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dataSource;
//	}
	
	
	@Bean(name = "dataSource")
	@Conditional({DataSourceCondition.class})
	public DataSource getDataSource(
			@Value("${jdbc.database.driver}") String driver,
			@Value("${jdbc.database.url}") String url,
			@Value("${jdbc.database.username}") String username,
			@Value("${jdbc.database.password}") String password) {
		Properties props = new Properties();
		props.setProperty("driver", driver);
		props.setProperty("url", url);
		props.setProperty("username", username);
		props.setProperty("password", password);
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean(name="juiceMaker2", initMethod="init", destroyMethod="myDestroy")
	public JuiceMaker2 initJuiceMaker2() {
		JuiceMaker2 juiceMaker2 = new JuiceMaker2();
		juiceMaker2.setBeverageShop("贡茶");
		Source source = new Source();
		source.setFruit("橙子");
		source.setSize("大杯");
		source.setSugar("少糖");
	     juiceMaker2.setSource(source);
		return juiceMaker2;
	}
}