package demo.spring.boot.demospringboot.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * 配置自定义的错误码的处理url
 */
@Configuration
public class HttpStatusResponseConfig {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return container -> {
            Arrays.asList(HttpStatus.values()).stream().forEach(httpStatus -> {
                container.addErrorPages(new ErrorPage(httpStatus, "/httpStatus/response/" + httpStatus.value()));
            });
        };
    }
}
