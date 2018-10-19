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

<<<<<<< HEAD
    /**
     * 用于捕获全局异常，Controller发生异常，如果没有处理，就会在这里统一处理
     *
     * @param e
     * @return
     */
=======
>>>>>>> a5e759087bfb425b7da472768e1f70912c19d4ba
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response ExceptionDeal(Exception e) {
        Response response = new Response();
<<<<<<< HEAD
        response.setCode(Code.System.SYSTEM_ERROR_CODE);
        response.setMsg(Code.System.SYSTEM_ERROR_CODE_MSG);
        response.addException(e);
        response.setError(e.getMessage());
        return response;

=======
        response.setCode(Code.System.FAIL);
        response.setMsg(e.getMessage());
        response.addException(e);
        return response;
>>>>>>> a5e759087bfb425b7da472768e1f70912c19d4ba
    }
}
