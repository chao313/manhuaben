package demo.spring.boot.demospringboot.mybatis.service.eventbus;

import com.google.common.eventbus.Subscribe;
import demo.spring.boot.demospringboot.util.IpadGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.imageio.stream.FileImageOutputStream;
import java.io.IOException;

@Component
public class Download {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Subscribe
    public Boolean download(EventVo eventVo) {
        FileImageOutputStream imageOutput = null;//打开输入流
        try {
            imageOutput = new FileImageOutputStream(eventVo.getPagePathFile());
            byte[] bytes = IpadGet.getBytes(eventVo.getPageImageUrl());//http下载
            imageOutput.write(bytes, 0, bytes.length);//将byte写入硬盘
            imageOutput.close();
            logger.info("pageImageUrl:{}", eventVo.getPagePathFile().getPath());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.error("error:pageImageUrl:{}", eventVo.getPagePathFile().getPath());
        return false;
    }
}
