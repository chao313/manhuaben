package demo.spring.boot.demospringboot.controller.pub;


import demo.spring.boot.demospringboot.mybatis.service.TsBookService;
import demo.spring.boot.demospringboot.mybatis.service.TsPageService;
import demo.spring.boot.demospringboot.mybatis.vo.PageHelper;
import demo.spring.boot.demospringboot.mybatis.vo.TsBookVo;
import demo.spring.boot.demospringboot.mybatis.vo.TsPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FreeMarkerController {
    @Autowired
    private TsBookService tsBookService;
    @Autowired
    private TsPageService tsPageService;

    @GetMapping(value = "/bookList")
    public ModelAndView bookList(Map<String, Object> map,
                                 @RequestParam(value = "start", defaultValue = "1") Integer start,
                                 @RequestParam(value = "end", defaultValue = "10") Integer end,
                                 @RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) {
        TsBookVo query = new TsBookVo();
        query.setStart(start);
        query.setEnd(end);
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(query);
        Integer sum = tsBookService.queryBaseCount(query);
        map.put("tsBookVoList", tsBookVoList);
        List<PageHelper> pageHelpers = new ArrayList<>();
        for (int i = 1; i <= sum / pageCount; i++) {
            PageHelper pageHelper = new PageHelper();
            pageHelper.setValue("第" + String.valueOf(i) + "页");
            pageHelper.setUrl("/chao/bookList");
            pageHelper.setParam("?start=" + (i - 1) * pageCount + "&end=" + i * pageCount);
            pageHelpers.add(pageHelper);
        }
        map.put("pageHelpers", pageHelpers);
        return new ModelAndView("bookList", map);
    }

    @GetMapping(value = "/pageList")
    public ModelAndView pageList(Map<String, Object> map, Integer bookId,
                                 @RequestParam(value = "start", defaultValue = "1") Integer start,
                                 @RequestParam(value = "end", defaultValue = "10") Integer end,
                                 @RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) {
        TsPageVo query = new TsPageVo();
        query.setBookId(bookId);
        query.setStart(start);
        query.setEnd(end);
        List<TsPageVo> pageList = tsPageService.queryBase(query);
        Integer sum = tsPageService.queryBaseCount(query);
        map.put("pageList", pageList);
        List<PageHelper> pageHelpers = new ArrayList<>();
        for (int i = 1; i <= sum / pageCount+1; i++) {
            PageHelper pageHelper = new PageHelper();
            pageHelper.setValue("第" + String.valueOf(i) + "页");
            pageHelper.setUrl("/chao/pageList");
            pageHelper.setParam("?start=" + (i - 1) * pageCount + "&end=" + i * pageCount + "&bookId=" + bookId);
            pageHelpers.add(pageHelper);
        }
        map.put("pageHelpers", pageHelpers);
        return new ModelAndView("pageList", map);
    }
}
