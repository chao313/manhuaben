package demo.spring.boot.demospringboot.service;

import demo.spring.boot.demospringboot.mybatis.service.TsBookService;
import demo.spring.boot.demospringboot.mybatis.service.TsParamService;
import demo.spring.boot.demospringboot.mybatis.service.TsWebPageService;
import demo.spring.boot.demospringboot.mybatis.vo.TsBookVo;
import demo.spring.boot.demospringboot.mybatis.vo.TsWebPageVo;
import demo.spring.boot.demospringboot.util.IpadGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GenerateService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String BASE_URL = "baseUrl";
    private String MIN_PAGE_SIZE = "minPageSize";
    private String MAX_PAGE_SIZE = "maxPageSize";

    @Autowired
    private TsParamService tsParamService;

    @Autowired
    private TsWebPageService tsWebPageService;

    @Autowired
    private TsBookService tsBookService;

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
        List<TsBookVo> tsBookVoList = new ArrayList<>();
        int i = 1;
        for (TsWebPageVo tsWebPageVo : tsWebPageVos) {

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
            }


        }
        return tsBookService.insert(tsBookVoList);
    }
}
