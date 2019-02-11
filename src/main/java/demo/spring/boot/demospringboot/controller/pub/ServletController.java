package demo.spring.boot.demospringboot.controller.pub;


import demo.spring.boot.demospringboot.mybatis.vo.ImageData;
import demo.spring.boot.demospringboot.util.GetProxyImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/servlet")
public class ServletController {

    private static List<String> hosts = new ArrayList<>();


    @GetMapping(value = "/tmpDownload")
    public void imageUrl(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getParameter("url");
        //获取图片信息
        try {
            ImageData image = GetProxyImage.getImage(url);
            if (image != null) {
                //将获取到的图片返回
                response.setContentType(image.getContentType());
                //设置浏览器缓存
                response.setHeader("Cache-Control", "max-age=31536000");
                OutputStream out = response.getOutputStream();
                URI uri = new URI(url);
                if (hosts.contains(uri.getHost())) {
                    return;
                }
                if (uri.getPath().endsWith(".js")) {
                    response.setContentType("application/javascript");
                }
                out.write(image.getData());
                out.flush();
                out.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
