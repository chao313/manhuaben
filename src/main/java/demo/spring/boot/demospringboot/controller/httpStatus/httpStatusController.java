package demo.spring.boot.demospringboot.controller.httpStatus;

import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * HttpStatus 状态码处理界面
 * 2018/10/18    Created by   chao
 */
@Api(value = "HttpStatus-API", produces = "application/json")
@RestController
@RequestMapping("/httpStatus")
public class httpStatusController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "测试httpStatus处理", notes = "测试httpStatus处理")
    @GetMapping("/response/{httpStatus}")
    public Response framework(@PathVariable(value = "httpStatus") Integer httpStatus) {
        Response response = new Response();
        response.setCode(httpStatus.toString());
        response.setMsg(HttpStatus.valueOf(httpStatus).name());
        return response;
    }

}
