package demo.spring.boot.demospringboot.framework.exception.catcher;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.spring.boot.demospringboot.framework.Response;

/**
 * 全局捕获异常
 */
@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response ExceptionDeal(Exception e) {
         

    }
}
