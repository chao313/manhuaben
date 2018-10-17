package demo.spring.boot.demospringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;

/**
 * 2018/10/17    Created by   chao
 */
@RestController
@RequestMapping("/framework")
public class FrameworkController {


    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping("/response")
    public Response framework() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            logger.info("SUCCESS:{}", true);
            response.setContent(true);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }
}
