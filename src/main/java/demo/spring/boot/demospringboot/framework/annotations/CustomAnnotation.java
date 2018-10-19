package demo.spring.boot.demospringboot.framework.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface CustomAnnotation {

    String value() default "";

    boolean required() default false;
}
