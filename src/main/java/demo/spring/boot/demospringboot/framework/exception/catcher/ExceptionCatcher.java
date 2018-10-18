package demo.spring.boot.demospringboot.framework.exception.catcher;

import demo.spring.boot.demospringboot.framework.Code;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.spring.boot.demospringboot.framework.Response;

/**
 * 全局Controller捕获异常
 */
@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response ExceptionDeal(Exception e) {
        Response response = new Response();
        response.setCode(Code.System.FAIL);
        response.setMsg(e.getMessage());
        response.addException(e);
        return response;
    }
}
