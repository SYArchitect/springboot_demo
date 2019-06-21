package com.example.springboot_demo.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Huang Fuzhi
 * @date 2019/6/9
 */
@Configuration
public class DruidConfig {

    /**
     * 配置DruidDataSource数据源
     */
    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource druid()
    {
        return new DruidDataSource();
    }

    /**
     * 配置一个管理后台的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        //默认允许所有
        initParams.put("allow","127.0.0.1");
        initParams.put("deny","192.168.200.1");
        bean.setInitParameters(initParams);

        return bean;
    }

    /**
     * 配置一个filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        //哪些文件和请求可以不拦截
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
