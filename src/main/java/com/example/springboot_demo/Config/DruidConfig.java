package com.example.springboot_demo.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.example.springboot_demo.Aspect.HttpAspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
        //禁用HTML页面上的"Rest All"功能
        initParams.put("resetEnable","false");
        //监控页面登录用户名
        initParams.put("loginUsername","admin");
        //监控页面登录用户密码
        initParams.put("loginPassword","123456");
        //ip白名单，没有配置则默认允许所有
        initParams.put("allow","127.0.0.1");
        //ip黑名单
        initParams.put("deny","192.168.200.1");
        //如果某个ip同时存在，deny优先于allow
        bean.setInitParameters(initParams);

        return bean;
    }

    /**
     *  druid监控  配置URI拦截策略
     */
    @Bean
    public FilterRegistrationBean webStatFilter()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //添加过滤规则
        bean.setUrlPatterns(Arrays.asList("/*"));
        Map<String,String> initParams = new HashMap<>();
        //哪些文件和请求可以不拦截
        initParams.put("exclusions","*.js,*.css,/druid/*");
        //用于session监控页面的用户名显示，需要登录后主动将username注入到session里
        initParams.put("principalSessionName","username");
        bean.setInitParameters(initParams);

        return bean;
    }

    /**
     * druid数据库连接池监控 拦截器
     * @return 拦截器
     */
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        return new DruidStatInterceptor();
    }

    /**
     * 通过jdk正则表达式匹配方法定义切入点
     * @return
     */
    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut druidStatPointcut = new JdkRegexpMethodPointcut();
        //通过正则表达式匹配切点
        druidStatPointcut.setPatterns("com.example.springboot_demo.Dao.*","com.example.springboot_demo.Service.*");
        return druidStatPointcut;
    }

    /**
     * 按方法名正确匹配拦截 配置
     * @return
     */
    @Bean
    public Advisor druidStatAdvisor() {
        return new DefaultPointcutAdvisor(druidStatPointcut(),druidStatInterceptor());
    }

    /**
     * 按bean的类型拦截 配置
     * @return
     */
    @Bean
    public BeanTypeAutoProxyCreator beanTypeAutoProxyCreator() {
        BeanTypeAutoProxyCreator beanTypeAutoProxyCreator = new BeanTypeAutoProxyCreator();
        beanTypeAutoProxyCreator.setTargetBeanType(HttpAspect.class);
        beanTypeAutoProxyCreator.setInterceptorNames("druidStatInterceptor");
        return beanTypeAutoProxyCreator;
    }

    /**
     * 按bean id拦截 配置
     * @return
     */
//    @Bean
//    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
//        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//        beanNameAutoProxyCreator.setBeanNames("userService");
//        beanNameAutoProxyCreator.setInterceptorNames("druidStatInterceptor");
//        return beanNameAutoProxyCreator;
//    }

}
