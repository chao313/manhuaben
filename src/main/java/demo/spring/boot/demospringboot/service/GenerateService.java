package demo.spring.boot.demospringboot.service;

import demo.spring.boot.demospringboot.mybatis.service.TsBookService;
import demo.spring.boot.demospringboot.mybatis.service.TsPageService;
import demo.spring.boot.demospringboot.mybatis.service.TsParamService;
import demo.spring.boot.demospringboot.mybatis.service.TsWebPageService;
import demo.spring.boot.demospringboot.mybatis.vo.TsBookVo;
import demo.spring.boot.demospringboot.mybatis.vo.TsPageVo;
import demo.spring.boot.demospringboot.mybatis.vo.TsWebPageVo;
import demo.spring.boot.demospringboot.util.IpadGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GenerateService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String BASE_URL = "baseUrl";
    private String MIN_PAGE_SIZE = "minPageSize";
    private String MAX_PAGE_SIZE = "maxPageSize";
    private String HOST = "host";

    @Autowired
    private TsParamService tsParamService;

    @Autowired
    private TsWebPageService tsWebPageService;

    @Autowired
    private TsBookService tsBookService;

    @Autowired
    private TsPageService tsPageService;

    public boolean generateWebPage() {
        String baseUrl = tsParamService.queryByPrimaryKey(BASE_URL).getValue();
        String minPageSizeStr = tsParamService.queryByPrimaryKey(MIN_PAGE_SIZE).getValue();
        String maxPageSizeStr = tsParamService.queryByPrimaryKey(MAX_PAGE_SIZE).getValue();
        Integer minPageSize = Integer.valueOf(minPageSizeStr);
        Integer maxPageSize = Integer.valueOf(maxPageSizeStr);
        List<TsWebPageVo> tsWebPageVos = new ArrayList<>();
        for (; minPageSize <= maxPageSize; minPageSize++) {
            TsWebPageVo tsWebPageVo = new TsWebPageVo();
            tsWebPageVo.setWebPageIndex(minPageSize);
            tsWebPageVo.setWebPageUrl(baseUrl + minPageSize + ".html");
            tsWebPageVos.add(tsWebPageVo);
        }
        return tsWebPageService.insert(tsWebPageVos);
    }

    public boolean generateBook() {
        List<TsWebPageVo> tsWebPageVos = tsWebPageService.queryBase(null);
        int i = 1;
        List<TsBookVo> tsBookVoList = null;
        for (TsWebPageVo tsWebPageVo : tsWebPageVos) {
            tsBookVoList = new ArrayList<>();
            String htmlStr = IpadGet.getString(tsWebPageVo.getWebPageUrl());
            Document parse = Jsoup.parse(htmlStr);
            for (Element ulElement : parse.getElementsByClass("pList")) {
                for (Element liElement : ulElement.getElementsByTag("li")) {
                    for (Element divElement : liElement.getElementsByTag("div")) {
                        for (Element aElement : divElement.getElementsByTag("a")) {
                            TsBookVo tsBookVo = new TsBookVo();
                            String bookUrl = aElement.attr("href").trim();
                            byte[] bytes = null;
                            String imageSrc = "";
                            String bookName = "";
                            String bookCoverUrl = "";
                            for (Element ImgElement : aElement.getElementsByTag("img")) {
                                bookName = ImgElement.attr("title").trim();
                                bookCoverUrl = ImgElement.attr("src").trim();
//                                bytes = IpadGet.getBytes(imageSrc);
                            }
                            tsBookVo.setBookUrl(bookUrl);
                            tsBookVo.setBookName(bookName);
                            tsBookVo.setBookIndex(i);
                            tsBookVo.setBookCoversUrl(bookCoverUrl);
                            tsBookVo.setCreateTime(new Timestamp(new Date().getTime()));
                            i++;
                            logger.info("提取结果:{}", tsBookVo);
                            tsBookVoList.add(tsBookVo);
                        }
                    }
                }
                tsBookService.insert(tsBookVoList);
            }


        }
        return true;
    }

    /**
     * 补全book的size，name，date
     *
     * @return
     */
    public boolean makeUpBookSizeNameDate() {
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(null);
        List<TsBookVo> filterTsBookVoList = tsBookVoList.stream().filter(tsBookVo -> {
            return tsBookVo.getId() >= 3019;
        }).collect(Collectors.toList());
        String host = tsParamService.queryByPrimaryKey(HOST).getValue();
        for (TsBookVo tsBookVo : filterTsBookVoList) {
            String url = host + tsBookVo.getBookUrl();
            String htmlStr = IpadGet.getString(url);
            Document parse = Jsoup.parse(htmlStr);
            String text = parse.getElementsMatchingOwnText("共\\d{1,}页").text();
            Integer bookSize = null;
            try {
                bookSize = Integer.valueOf(text.substring(text.indexOf("共") + 1, text.indexOf("页")));
            } catch (Exception e) {
                logger.error("[转换页面]:{}", e.toString(), e);
            }
            String bookName = parse.getElementById("content").getElementsByClass("primary-title").text();
            String createTimeStr = parse.getElementById("content").getElementsByClass("date").text();
            Timestamp createTime = null;
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(createTimeStr.substring(createTimeStr.length() - 16));
                createTime = new Timestamp(date.getTime());
            } catch (ParseException e) {
                logger.error("[转换日期]:{}", e.toString(), e);
            }
            TsBookVo source = new TsBookVo();
            source.setBookSize(bookSize);
            source.setBookName(bookName);
            source.setCreateTime(createTime);
            tsBookVo.setBookSize(null);
            tsBookVo.setBookName(null);
            tsBookVo.setCreateTime(null);
            tsBookService.updateBase(source, tsBookVo);
        }
        return true;
    }

    /**
     * 补全book的size，name，date
     *
     * @return
     */
    public boolean makeUpBookSizeNameDateThread(Integer start, Integer end) {
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(null);
        List<TsBookVo> filterTsBookVoList = tsBookVoList.stream().filter(tsBookVo -> {
            return tsBookVo.getId() >= start && tsBookVo.getId() <= end;
        }).collect(Collectors.toList());
        String host = tsParamService.queryByPrimaryKey(HOST).getValue();
        for (TsBookVo tsBookVo : filterTsBookVoList) {
            String url = host + tsBookVo.getBookUrl();
            String htmlStr = IpadGet.getString(url);
            Document parse = Jsoup.parse(htmlStr);
            String text = parse.getElementsMatchingOwnText("共\\d{1,}页").text();
            Integer bookSize = null;
            try {
                bookSize = Integer.valueOf(text.substring(text.indexOf("共") + 1, text.indexOf("页")));
            } catch (Exception e) {
                logger.error("[转换页面]:{}", e.toString(), e);
            }
            String bookName = parse.getElementById("content").getElementsByClass("primary-title").text();
            String createTimeStr = parse.getElementById("content").getElementsByClass("date").text();
            Timestamp createTime = null;
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(createTimeStr.substring(createTimeStr.length() - 16));
                createTime = new Timestamp(date.getTime());
            } catch (ParseException e) {
                logger.error("[转换日期]:{}", e.toString(), e);
            }
            TsBookVo source = new TsBookVo();
            source.setBookSize(bookSize);
            source.setBookName(bookName);
            source.setCreateTime(createTime);
            tsBookVo.setBookSize(null);
            tsBookVo.setBookName(null);
            tsBookVo.setCreateTime(null);
            tsBookService.updateBase(source, tsBookVo);
        }
        return true;
    }


    /**
     * 生成page
     * 根据book的url生成page的url
     * book中有脏数据
     *
     * @return
     */
    public boolean generatePage() {
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(null);
        String host = tsParamService.queryByPrimaryKey(HOST).getValue();
        for (TsBookVo tsBookVo : tsBookVoList) {
            String url = host + tsBookVo.getBookUrl();
            url = url.replace(".html", "");
            List<TsPageVo> tsPageVos = new ArrayList<>();
            if (null != tsBookVo.getBookSize()) {
                TsPageVo tsPageVo = new TsPageVo();
                tsPageVo.setBookId(tsBookVo.getId());
                tsPageVo.setPageIndex(1);
                tsPageVo.setPageUrl(url + ".html");
                tsPageVos.add(tsPageVo);
                for (Integer i = 2; i <= tsBookVo.getBookSize(); i++) {
                    String pageUrl = url + "_" + i + ".html";
                    tsPageVo = new TsPageVo();
                    tsPageVo.setBookId(tsBookVo.getId());
                    tsPageVo.setPageIndex(i);
                    tsPageVo.setPageUrl(pageUrl);
                    tsPageVos.add(tsPageVo);
                }
                tsPageService.insert(tsPageVos);
            }
        }
        return true;
    }


    /**
     * 生成page
     * 根据book的url生成page的url
     *
     * @return
     */
    public boolean makeUpPageImage() {
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(null);//查询出所有的
        List<TsBookVo> filterTsBookVos = tsBookVoList.stream().filter(tsBookVo -> {
            return tsBookVo.getId() >= 1815;
        }).collect(Collectors.toList());

        for (TsBookVo tsBookVo : filterTsBookVos) {
            List<TsPageVo> tsPageVoList = tsPageService.queryBaseByIndexAndBookId(1, tsBookVo.getId());
            String src = "";
            if (tsPageVoList.size() > 0) {
                String htmlStr = IpadGet.getString(tsPageVoList.get(0).getPageUrl());
                Document parse = Jsoup.parse(htmlStr);

                for (Element imgElement : parse.getElementsByTag("img")) {
                    src = imgElement.attr("src").trim();
                }
            }

            //src可能为""
            if (src.endsWith(".jpg")) {
                List<TsPageVo> updateTsPageVos = tsPageService.queryBaseByBookId(tsBookVo.getId());
                for (TsPageVo updateTsPageVo : updateTsPageVos) {
                    String pageImageUrl = src.substring(0, src.length() - 5) + updateTsPageVo.getPageIndex() + src.substring(src.length() - 4);
                    updateTsPageVo.setPageImageUrl(pageImageUrl);
                }
                if (updateTsPageVos.size() > 0) {
                    tsPageService.insert(updateTsPageVos);
                }
            }
        }
        return true;
    }

    /**
     * 生成page
     * 根据book的url生成page的url
     * book中有脏数据
     * Thread
     *
     * @return
     */
    public boolean makeUpPageImageThread(Integer start, Integer end) {
        List<TsPageVo> tsPageVoList = tsPageService.queryBaseIds(start, end);
        for (TsPageVo tsPageVo : tsPageVoList) {
            String src = "";
            if (tsPageVoList.size() > 0) {
                String htmlStr = IpadGet.getString(tsPageVo.getPageUrl());
                Document parse = Jsoup.parse(htmlStr);

                for (Element imgElement : parse.getElementsByTag("img")) {
                    src = imgElement.attr("src").trim();
                }
            }
            TsPageVo source = new TsPageVo();
            if (src.endsWith(".jpg")) {
                source.setPageImageUrl(src);
                tsPageService.updateBase(source, tsPageVo);
            }
        }
        return true;
    }


    /**
     * 生成page
     * 根据book的url生成page的url
     * book中有脏数据
     * 1966 之前的数据-需要单独处理
     * 1435-1443 1412-1419 1332-1409
     * <p>
     * 只在第一次抓取数据的时间使用
     * 由于目标网页改版，目前不需要
     *
     * @return
     */
    @Deprecated
    public boolean makeUpPageImageOld() {
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(null);//查询出所有的
        List<TsBookVo> filterTsBookVos = tsBookVoList.stream().filter(tsBookVo -> {
            Integer id = tsBookVo.getId();
            return (id >= 1332 && id <= 1409);
        }).collect(Collectors.toList());

        for (TsBookVo tsBookVo : filterTsBookVos) {
            List<TsPageVo> tsPageVoList = tsPageService.queryBaseByBookId(tsBookVo.getId());
            for (TsPageVo tsPageVo : tsPageVoList) {
                String htmlStr = IpadGet.getString(tsPageVo.getPageUrl());
                Document parse = Jsoup.parse(htmlStr);
                String src = "";
                for (Element imgElement : parse.getElementsByTag("img")) {
                    src = imgElement.attr("src").trim();
                }
                tsPageVo.setPageImageUrl(src);
            }
            if (tsPageVoList.size() > 0) {
                tsPageService.insert(tsPageVoList);
            }
        }
        return true;
    }

    /**
     * 下载book的封面
     *
     * @return
     */
    public boolean downloadBookImage(Integer start, Integer end) {
        TsBookVo tsBookVo = new TsBookVo();
        tsBookVo.setStart(start);
        tsBookVo.setEnd(end);
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(tsBookVo);
        for (TsBookVo bookVo : tsBookVoList) {
            if (null == bookVo.getBookCovers()) {
                byte[] bytes = IpadGet.getBytes(bookVo.getBookCoversUrl());
                TsBookVo source = new TsBookVo();
                source.setBookCovers(bytes);
                tsBookService.updateBase(source, bookVo);
            }
        }
        return true;
    }

    /**
     * 下载book的封面 to loacl_image
     *
     * @return
     */
    public boolean downloadBookImageToLocalImage(Integer start, Integer end) throws IOException {
        TsBookVo tsBookVo = new TsBookVo();
        tsBookVo.setStart(start);
        tsBookVo.setEnd(end);
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(tsBookVo);
        for (TsBookVo bookVo : tsBookVoList) {
            if (null == bookVo.getLocalImageUrl()) {
                FileImageOutputStream imageOutput = new FileImageOutputStream(new File("/Users/chao/Desktop/book_cover_jpg/book_" + bookVo.getBookIndex() + ".jpg"));//打开输入流
                imageOutput.write(bookVo.getBookCovers(), 0, bookVo.getBookCovers().length);//将byte写入硬盘
                imageOutput.close();
                TsBookVo source = new TsBookVo();
                source.setLocalImageUrl("book_" + bookVo.getBookIndex() + ".jpg");
                tsBookService.updateBase(source, bookVo);
            }
        }
        return true;
    }

    /**
     * 下载book的封面 to loacl_image Thread
     *
     * @return
     */
    public boolean downloadBookImageToLocalImageThread(Integer start, Integer end) throws IOException {
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(null);
        List<TsBookVo> filterTsBookVoList = tsBookVoList.stream().filter(tsBookVo -> {
            return tsBookVo.getId() >= start && tsBookVo.getId() <= end && !StringUtils.isEmpty(tsBookVo.getBookCoversUrl());
        }).collect(Collectors.toList());
        for (TsBookVo bookVo : filterTsBookVoList) {
            String path = "/Users/chao/Desktop/book_cover_jpg/book_" + bookVo.getBookIndex() + ".jpg";
            if (null == bookVo.getLocalImageUrl()) {
                FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));//打开输入流
                byte[] bytes = IpadGet.getBytes(bookVo.getBookCoversUrl());//http下载
                imageOutput.write(bytes, 0, bytes.length);//将byte写入硬盘
                imageOutput.close();
                logger.info("path:{}", path);
            }
        }
        return true;
    }

    /**
     * 下载page
     *
     * @return
     */
    public boolean downloadPageImage(Integer start, Integer end) {
        TsPageVo tsPageVo = new TsPageVo();
        tsPageVo.setStart(start);
        tsPageVo.setEnd(end);
        List<TsPageVo> tsPageVos = tsPageService.queryBase(tsPageVo);
        for (TsPageVo pageVo : tsPageVos) {
            if (null == pageVo.getPageImage()) {
                byte[] bytes = IpadGet.getBytes(pageVo.getPageImageUrl());
                TsPageVo source = new TsPageVo();
                source.setPageImage(bytes);
                tsPageService.updateBase(source, pageVo);
            }
        }
        return true;
    }

    /**
     * 下载book的封面 to loacl_image
     *
     * @return
     */
    public boolean downloadPageImageToLocalImage(Integer start, Integer end) throws IOException {
        TsPageVo vo = new TsPageVo();
        vo.setStart(start);
        vo.setEnd(end);
        List<TsPageVo> list = tsPageService.queryBase(vo);
        for (TsPageVo pageVo : list) {
            if (null == pageVo.getLoaclImageUrl() && null != pageVo.getPageImage()) {
                FileImageOutputStream imageOutput = new FileImageOutputStream(new File("/Users/chao/IdeaWorkspace/manhuaben/manhuaben/src/main/resources/static/book_cover_jpg/book_" + pageVo.getBookId() + "_page_" + pageVo.getPageIndex() + ".jpg"));//打开输入流
                imageOutput.write(pageVo.getPageImage(), 0, pageVo.getPageImage().length);//将byte写入硬盘
                imageOutput.close();
                TsPageVo source = new TsPageVo();
                source.setLoaclImageUrl("book_" + pageVo.getBookId() + "_page_" + pageVo.getPageIndex() + ".jpg");
                logger.info("path:{}", source.getLoaclImageUrl());
                tsPageService.updateBase(source, pageVo);
            }
        }
        return true;
    }

    /**
     * 下载book的封面 to loacl_image -> 输出
     *
     * @return
     */
    public boolean downloadPageImageToLocalImageThread(Integer start, Integer end) throws IOException {
        List<TsPageVo> list = tsPageService.queryBaseIds(start, end);
        Map<Integer, List<TsPageVo>> map = new HashMap<>();
        list.forEach(tsPageVo -> {
            if (map.get(tsPageVo.getBookId()) != null) {
                map.get(tsPageVo.getBookId()).add(tsPageVo);
            } else {
                List<TsPageVo> list1 = new ArrayList<>();
                list1.add(tsPageVo);
                map.put(tsPageVo.getBookId(), list1);
            }
        });
        map.forEach((key, tsPageVoList) -> {
            TsBookVo tsBookVo = tsBookService.queryByPrimaryKey(key);
            if (null != tsBookVo) {
                tsPageVoList.forEach(tsPageVo -> {
                    tsPageVo.setBookName(tsBookVo.getBookName());
                });
            }
        });

        for (TsPageVo pageVo : list) {
            try {
                if (null != pageVo.getPageImageUrl()) {
//                TsBookVo tsBookVo = tsBookService.queryByPrimaryKey(pageVo.getBookId());
                    String bookPath = "/Users/chao/Desktop/page_jpg/" + pageVo.getBookName() + "/";
                    if (new File(bookPath).exists() == false) {
                        new File(bookPath).mkdirs();
                    }
                    File pagePathFile = new File(bookPath + pageVo.getPageIndex() + ".jpg");
                    if (!pagePathFile.exists() && !StringUtils.isEmpty(pageVo.getPageImageUrl())) {
                        FileImageOutputStream imageOutput = new FileImageOutputStream(pagePathFile);//打开输入流
                        byte[] bytes = IpadGet.getBytes(pageVo.getPageImageUrl());//http下载
                        imageOutput.write(bytes, 0, bytes.length);//将byte写入硬盘
                        imageOutput.close();
                        logger.info("path:{}", bookPath + pageVo.getPageIndex() + ".jpg");
                    }
                }
            } catch (Exception e) {
                logger.info("error:{}", e.toString(), e);
            }


        }
        return true;
    }


    /**
     * 下载page
     *
     * @return
     */
    public boolean downloadPageImageRun(Integer start, Integer end) {
        TsPageVo tsPageVo = new TsPageVo();
        tsPageVo.setStart(start);
        tsPageVo.setEnd(end);
        List<TsPageVo> tsPageVos = tsPageService.queryBase(tsPageVo);
        List<TsPageVo> pageVos = Collections.synchronizedList(new LinkedList<>(tsPageVos));
        ThreadGroup tg = new ThreadGroup("线程组");
        int i = 0;
        while (true) {
            if (DownloadPageRun.i > pageVos.size()) {
                tsPageVos = tsPageService.queryBase(tsPageVo);
                pageVos = Collections.synchronizedList(new LinkedList<>(tsPageVos));
                DownloadPageRun.i = 0;
            }
            if (Thread.currentThread().getThreadGroup().activeCount() <= 1000) {
                logger.info("[线程组]:{}", Thread.currentThread().getThreadGroup().getName());
                logger.info("[线程活跃数量]:{}", Thread.currentThread().getThreadGroup().activeCount());
                logger.debug("TotalMemory", Runtime.getRuntime().totalMemory() / (1024 * 1024) + "M");
                logger.debug("FreeMemory", Runtime.getRuntime().freeMemory() / (1024 * 1024) + "M");
                logger.debug("MaxMemory", Runtime.getRuntime().maxMemory() / (1024 * 1024) + "M");
                Runnable runnable = new DownloadPageRun(pageVos, tsPageService);
                new Thread(tg, runnable, "线程:i:" + i++).start();
            }
        }
    }

}
