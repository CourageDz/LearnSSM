package Chapter10.utils;

import java.sql.SQLException;

import javax.sql.DataSource;

import Chapter10.annotation.config.ApplicationConfig;
import Chapter10.annotation.config.AutowiredConfig;
import Chapter10.annotation.controller.RoleController;
import Chapter10.annotation.controller.RoleController2;
import Chapter10.annotation.pojo.JuiceMaker2;
import Chapter10.annotation.pojo.PojoConfig;
import Chapter10.annotation.service.RoleDataSourceService;
import Chapter10.annotation.service.RoleService;
import Chapter10.annotation.service.RoleService2;
import Chapter10.annotation.pojo.Role;
import Chapter10.annotation.service.impl.ServiceConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnotationMain {
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
//		test6();
//		test7();
		test8() ;
		test9();
	}

	private static void test1() throws BeansException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
		Role role = (Role)context.getBean(Role.class);
		System.err.println(role.getRoleName());
		RoleController roleController =context.getBean(RoleController.class);
		roleController.printRole(role);
//		 RoleService roleService =context.getBean( RoleService.class);
//		 roleService.printRoleInfo(role);
//		JuiceMaker2 juiceMaker2 =context.getBean(JuiceMaker2.class);
//		System.err.println(juiceMaker2.makeJuice());
		((AnnotationConfigApplicationContext) context).close();
	}

	private static void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Role role = context.getBean(Role.class);
		RoleService roleService = context.getBean("roleService", RoleService.class);
		roleService.printRoleInfo(role);
		context.close();
	}
	
	private static void test3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleService2 roleService = context.getBean(RoleService2.class);
		roleService.printRoleInfo();
		context.close();
	}
	
	private static void test4() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		RoleController roleController;
		roleController = context.getBean(RoleController.class);
		Role role = context.getBean(Role.class);
		roleController.printRole(role);
		context.close();
	}
	
	private static void test5() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		RoleController2 roleController = context.getBean(RoleController2.class);
		Role role = context.getBean(Role.class);
		roleController.printRole(role);
		context.close();
	}
	
	private static void test6() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource dataSource = context.getBean(DataSource.class);
		try {
			System.out.println(dataSource.getConnection().getMetaData().getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void test7() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		context.close();
	}
	
	
	/***
	 * 测试注解引入XML时候，注意到ApplicationConfig关于这个方法的注释，需要修改后才能测试。 
	 */
	private static void test8() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDataSourceService roleDataSourceService = context.getBean(RoleDataSourceService.class);
		Role role = roleDataSourceService.getRole(2L);
		System.out.println(role.getRoleName());
		context.close();
	}
	
	private static void test9() {
		ApplicationContext context = 
			     new AnnotationConfigApplicationContext(ApplicationConfig.class);
			String url = context.getEnvironment().getProperty("jdbc.database.url");
			System.out.println(url);
	}
}
