package demo.spring.boot.demospringboot.controller.pub;


import demo.spring.boot.demospringboot.mybatis.service.TsBookService;
import demo.spring.boot.demospringboot.mybatis.vo.TsBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class FreeMarkerController {
    @Autowired
    private TsBookService tsBookService;

    @GetMapping(value = "/bookList")
    public ModelAndView bookList(Map<String, Object> map, Integer start, Integer end) {
        List<TsBookVo> tsBookVoList = tsBookService.queryBase(null);
        map.put("tsBookVoList", tsBookVoList);
        return new ModelAndView("bookList", map);
    }
}
