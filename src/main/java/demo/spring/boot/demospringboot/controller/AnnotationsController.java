package demo.spring.boot.demospringboot.controller;

import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;
import demo.spring.boot.demospringboot.framework.annotations.CustomAnnotation;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/annotationsAspect")
public class AnnotationsController {

    /**
     * annotationsAspect
     */
    @ApiOperation(value = "测试自定义注解的拦截", notes = "测试自定义注解的拦截")
    @CustomAnnotation(value = "哈哈", required = true)
    @GetMapping("/aspect")
    public Response framework(@RequestParam(value = "one") Integer one,
                              @RequestParam(value = "two") Integer two) {
        Response response = new Response();
        response.setCode(Code.System.OK);
        response.setMsg(Code.System.SERVER_SUCCESS_MSG);
        response.setContent(one / two);
        return response;
    }

}
