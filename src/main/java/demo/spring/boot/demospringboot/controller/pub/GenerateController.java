package demo.spring.boot.demospringboot.controller.pub;

import demo.spring.boot.demospringboot.service.GenerateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;

/**
 * 2018/10/17    Created by   chao
 */
@RestController
@RequestMapping("/generate")
public class GenerateController {

    @Autowired
    private GenerateService generateService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "1 - 根据ts_param，生成分页的url <br> 目标生成到 ts_web_page", notes = "根据ts_param，生成分页的url <br> 目标生成到ts_web_page")
    @GetMapping("webPage")
    public Response generateWebPage() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.generateWebPage();
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @ApiOperation(value = "2 - 根据 ts_web_page，获取book的url，image <br> 目标生成到 ts_book", notes = "2 - 根据 ts_web_page，获取book的url，image <br> 目标生成到 ts_book")
    @GetMapping("/book")
    public Response generateBook() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.generateBook();
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @ApiOperation(value = "3 - 根据 ts_book（这些数据只在点进去的url可以获取到，title也是），补全book的size，name , time <br> 目标生成到 ts_book", notes = "3 - 根据 ts_book，补全book的size，name , time <br> 目标生成到 ts_book")
    @GetMapping("/makeUpBook")
    public Response makeUpBook() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.makeUpBookSizeNameDate();
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @ApiOperation(value = "3 - Thread - 根据 ts_book（这些数据只在点进去的url可以获取到，title也是），补全book的size，name , time <br> 目标生成到 ts_book", notes = "3 - 根据 ts_book，补全book的size，name , time <br> 目标生成到 ts_book")
    @GetMapping("/makeUpBookThread")
    public Response makeUpBook(@ApiParam(value = "ts_book 中的start") @RequestParam("start") Integer start,
                               @ApiParam(value = "ts_book 中的end") @RequestParam("end") Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.makeUpBookSizeNameDateThread(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @ApiOperation(value = "4 - 根据 ts_book 生成到 ts_page(不涉及http)", notes = "4 - 根据 ts_book 生成到 ts_page(不涉及http)")
    @GetMapping("/page")
    public Response generatePage() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.generatePage();
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @GetMapping("/makeUpPageImage")
    public Response makeUpPageImage() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.makeUpPageImage();
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @ApiOperation(value = "5 - 根据 ts_page 补全page的数据（Thread）", notes = "5 - 根据 ts_page 补全page的数据（Thread）")
    @GetMapping("/makeUpPageImageThread")
    public Response makeUpPageImageThread(@ApiParam(value = "ts_book 中的start") @RequestParam("start") Integer start,
                                          @ApiParam(value = "ts_book 中的end") @RequestParam("end") Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.makeUpPageImageThread(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @GetMapping("/makeUpPageImageOld")
    public Response makeUpPageImageOld() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.makeUpPageImageOld();
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    /**
     * 下载book的封面
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/downloadBookImage")
    public Response downloadBookImage(Integer start, Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.downloadBookImage(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    /**
     * 下载book的封面 转为 local_image
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/downloadBookImageToLocalImage")
    public Response downloadBookImageToLocalImage(Integer start, Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.downloadBookImageToLocalImage(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    /**
     * 下载book的封面 转为 local_image
     *
     * @param start
     * @param end
     * @return
     */
    @ApiOperation(value = "6 - 根据 ts_book 下载image（Thread）", notes = "6 - 根据 ts_book 下载image（Thread） ")
    @GetMapping("/downloadBookImageToLocalImageThread")
    public Response downloadBookImageToLocalImageThread(Integer start, Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.downloadBookImageToLocalImageThread(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    /**
     * 下载page
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/downloadPageImage")
    public Response downloadPageImage(Integer start, Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.downloadPageImage(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    /**
     * 下载page 转为 local_image
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/downloadPageImageToLocalImage")
    public Response downloadPageImageToLocalImage(Integer start, Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.downloadPageImageToLocalImage(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    /**
     * 下载page 转为 local_image
     * Thread
     *
     * @param start
     * @param end
     * @return
     */
    @ApiOperation(value = "7 - 根据 ts_page 下载image（Thread）", notes = "7 - 根据 ts_page 下载image（Thread） ")
    @GetMapping("/downloadPageImageToLocalImageThread")
    public Response downloadPageImageToLocalImageThread(Integer start, Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.downloadPageImageToLocalImageThread(start, end);
//            boolean result = generateService.downloadPageImageToLocalImageEvent(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }


    /**
     * 下载page
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/downloadPageImageRun")
    public Response downloadPageImageRun(Integer start, Integer end) {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            boolean result = generateService.downloadPageImageRun(start, end);
            response.setContent(result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }
}
