package demo.spring.boot.demospringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;

/**
 * 2018/10/18    Created by   chao
 */
@RestController
@RequestMapping("/executionAspect")
public class ExecutionAspectController implements AspectController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 所有的异常处理在ExecutionAspect切面中执行
     */
    @GetMapping("/aspect")
    public Response framework(@RequestParam(value = "one") Integer one,
                              @RequestParam(value = "two") Integer two) {
        Response response = new Response();
        response.setCode(Code.System.OK);
        response.setMsg(Code.System.SERVER_SUCCESS_MSG);
        response.setContent(one / two);
        return response;
    }

    @Override
    public void BeforeAspectMethod() {
        logger.info("【切面调用：】函数之前");
    }

    @Override
    public void AfterAspectMethod() {
        logger.info("【切面调用：】函数之后");
    }
}
