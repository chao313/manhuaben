package demo.spring.boot.demospringboot.controller.auth;

import demo.spring.boot.demospringboot.controller.aspect.AspectController;
import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * execution的切面
 * 2018/10/18    Created by   chao
 */
@Api(value = "AuthHeaderAspect-API", produces = "application/json")
@RestController
@RequestMapping("/authHeaderAspect")
public class AuthHeaderAspectController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "测试Header拦截验证", notes = "测试Header拦截验证")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "用户Token",
                    dataType = "string",
                    paramType = "header",
                    example = "Bearer 0b79bab50daca910b000d4f1a2b675d604257e42",
                    required = true)
    })
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
