package Chapter10.annotation.service.impl;

import Chapter10.annotation.config.DataSourceBean;
import Chapter10.annotation.controller.RoleController;
import Chapter10.annotation.controller.RoleController2;
import Chapter10.annotation.pojo.Role;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import javax.xml.crypto.Data;

@ComponentScan(basePackageClasses = {Role.class, RoleServiceImpl.class, RoleController2.class})
@ImportResource({"classpath:Chapter10/proXml/spring-dataSource.xml"})
public class ServiceConfig {
}
