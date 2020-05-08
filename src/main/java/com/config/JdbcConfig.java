package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : gxm
 * @date : 2020/5/8
 * @time : 15:45
 * @projectName : spring-account-annoation
 * @description :
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Component
public class JdbcConfig {
    @Value("${driverClass}")
    private String driverClass;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("${jdbcUrl}")
    private String jdbcUrl;
    /**
     * @author gxm
     * @date 2020/5/8 15:51
     * @description 创建一个queryRunner bean
     * @param
     * @return org.apache.commons.dbutils.QueryRunner
     * @since version-1.0
     */
    @Bean(name = "queryRunner")
    @DependsOn(value = "source")
    public QueryRunner createQueryRunner(DataSource source) {
        return new QueryRunner(source);
    }

    /**
     * @author gxm
     * @date 2020/5/8 15:53
     * @description 顶一个place来加载配置文件
     * @param
     * @return org.springframework.context.support.PropertySourcesPlaceholderConfigurer
     * @since version-1.0
     */
    @Bean(name = "propertySourcesPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "source")
    @DependsOn("propertySourcesPlaceholderConfigurer")
    public DataSource createSource(){
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser(user);
        source.setPassword(password);
        source.setJdbcUrl(jdbcUrl);
        try {
            source.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return source;
    }
}
