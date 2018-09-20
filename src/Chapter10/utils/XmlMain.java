package Chapter10.utils;

import Chapter10.annotation.config.DataSourceBean;
import Chapter10.annotation.pojo.JuiceMaker2;
import Chapter10.annotation.service.RoleDataSourceService;
import Chapter10.pojo.ComplexAssembly;
import Chapter10.pojo.UserRoleAssembly;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    public static void main(String[] args) {
        test2();
    }

    public  static void  myTest1(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("Chapter10/proXml/myXml.xml");
        JuiceMaker2 juiceMaker2=(JuiceMaker2) ctx.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
    }
    public static void test1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Chapter10/proXml/spring-namespace.xml");
        UserRoleAssembly userRoleAssembly = context.getBean(UserRoleAssembly.class);
//        ComplexAssembly  complexAssembly =context.getBean(ComplexAssembly.class);
//        System.err.println(complexAssembly.getMap().entrySet());
        System.err.println(userRoleAssembly.getList().get(1).getRoleName());
    }

    public static void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Chapter10/proXml/spring-props.xml");
        DataSourceBean dsBean = context.getBean(DataSourceBean.class);
        System.out.println(dsBean.getUrl());
    }

    public static void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Chapter10/proXml/spring-props.xml");
        RoleDataSourceService RoleService = ctx.getBean(RoleDataSourceService. class);
        RoleDataSourceService RoleService2 =  ctx.getBean(RoleDataSourceService. class);
        System.out.println(RoleService == RoleService2);
    }
}