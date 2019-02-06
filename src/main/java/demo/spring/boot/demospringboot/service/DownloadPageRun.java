package demo.spring.boot.demospringboot.service;

import demo.spring.boot.demospringboot.mybatis.service.TsPageService;
import demo.spring.boot.demospringboot.mybatis.vo.TsPageVo;
import demo.spring.boot.demospringboot.util.IpadGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DownloadPageRun implements Runnable {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Thread t;
    private List<TsPageVo> tsPageVos;
    private TsPageService tsPageService;
    public static int i = 0;
    private static String start = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(new Date());
    private static long startLong = System.currentTimeMillis();

    public DownloadPageRun(List<TsPageVo> tsPageVos, TsPageService tsPageService) {
        this.tsPageVos = tsPageVos;
        this.tsPageService = tsPageService;
    }

    /**
     * 同步方法
     *
     * @return
     */
    public synchronized TsPageVo pop() {
        if (i <= this.tsPageVos.size()) {
            return this.tsPageVos.get(i++);
        } else {
            Thread.currentThread().stop();
            return null;
        }

    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

    @Override
    public void run() {
        while (this.tsPageVos.size() > 0) {
            TsPageVo pageVo = null;
            synchronized (DownloadPageRun.class) {
                pageVo = this.pop();
            }
            if (null == pageVo.getPageImage()) {
                logger.info("当前进度:i:{} ,sunm:{} ,  i/sum : {} ， start时间:{} , 已经运行的时间（秒）:{} , 条/秒：{}", i,
                        tsPageVos.size(),
                        ((double) i / (double) tsPageVos.size()) * 100 + "%",
                        start,
                        (System.currentTimeMillis() - startLong) / 1000,
                        ((double) i / ((double) (System.currentTimeMillis() - startLong) / 1000)));
                logger.info("当前线程:{}", Thread.currentThread().toString());
                byte[] bytes = IpadGet.getBytes(pageVo.getPageImageUrl());
                TsPageVo source = new TsPageVo();
                source.setPageImage(bytes);
                tsPageService.updateBase(source, pageVo);
            }
        }
    }
}
