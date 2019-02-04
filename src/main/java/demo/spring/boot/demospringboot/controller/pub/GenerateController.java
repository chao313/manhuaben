package demo.spring.boot.demospringboot.controller.pub;

import demo.spring.boot.demospringboot.service.GenerateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * 下载book的封面 转为 local_image
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
