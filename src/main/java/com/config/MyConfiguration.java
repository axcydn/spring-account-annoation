package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : gxm
 * @date : 2020/5/8
 * @time : 15:43
 * @projectName : spring-account-annoation
 * @description :
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Configuration
@ComponentScan(value = "com")
@PropertySource("classpath:db.properties")
@Import(JdbcConfig.class)
@EnableAspectJAutoProxy
public class MyConfiguration {
}
