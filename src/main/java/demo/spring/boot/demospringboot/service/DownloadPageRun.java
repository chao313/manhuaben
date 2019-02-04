package demo.spring.boot.demospringboot.service;

import demo.spring.boot.demospringboot.mybatis.service.TsPageService;
import demo.spring.boot.demospringboot.mybatis.vo.TsPageVo;
import demo.spring.boot.demospringboot.util.IpadGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class DownloadPageRun implements Runnable {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Thread t;
    private List<TsPageVo> tsPageVos;
    private TsPageService tsPageService;
    private static int i = 0;

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
        return this.tsPageVos.get(i++);
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
                logger.info("当前线程:{}", pageVo, Thread.currentThread().toString());
                byte[] bytes = IpadGet.getBytes(pageVo.getPageImageUrl());
                TsPageVo source = new TsPageVo();
                source.setPageImage(bytes);
                tsPageService.updateBase(source, pageVo);
            }
        }
    }
}
