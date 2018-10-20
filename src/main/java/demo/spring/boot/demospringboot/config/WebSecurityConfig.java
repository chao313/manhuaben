package demo.spring.boot.demospringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security配置
 * 一旦pom中加入spring-boot-starter-security 就必须配置这个
 * 不然会默认拦截所有的非login请求
 * @author WangZhen
 */
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//扩展SpringSecurity配置需要继承此类


    /**
     * 配置security非忽略swagger的访问路径
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


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/private/*").authenticated()
//                .anyRequest().permitAll();
//
//    }
}
