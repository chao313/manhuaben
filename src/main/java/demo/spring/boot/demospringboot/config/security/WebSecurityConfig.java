package demo.spring.boot.demospringboot.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security配置
 * 一旦pom中加入spring-boot-starter-security 就必须配置这个
 * 不然会默认拦截所有的非login请求
 *
 * @author WangZhen
 */


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//扩展SpringSecurity配置需要继承此类

    @Value(value = "${url.security.authenticated}")
    private String[] urlSecurityAuthenticated;

    /**
     * 配置security忽略swagger的访问路径
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //allow Swagger URL to be accessed without authentication
        web.ignoring().antMatchers("/v2/api-docs",//swagger api json
                "/swagger-resources/configuration/ui",//用来获取支持的动作
                "/swagger-resources",//用来获取api-docs的URI
                "/swagger-resources/configuration/security",//安全选项
                "/swagger-ui.html");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //拦截指定的
        http.authorizeRequests()
                .antMatchers(urlSecurityAuthenticated)
                .authenticated()
                .and().httpBasic()
        ;


    }
}
