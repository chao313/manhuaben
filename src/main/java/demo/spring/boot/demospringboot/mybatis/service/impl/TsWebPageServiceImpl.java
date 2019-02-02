package demo.spring.boot.demospringboot.mybatis.service.impl;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.service.TsWebPageService;
import demo.spring.boot.demospringboot.mybatis.vo.TsWebPageVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.spring.boot.demospringboot.mybatis.dao.TsWebPageDao;



/**
 * 对应的表名   :ts_web_page
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-2
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */
@Service
public class TsWebPageServiceImpl implements TsWebPageService {

    @Autowired
    private TsWebPageDao dao;

    /**
     * insert
     */
    @Override
    public boolean insert(TsWebPageVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<TsWebPageVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<TsWebPageVo> queryBase(TsWebPageVo query) {

        return dao.queryBase(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(TsWebPageVo source, TsWebPageVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(TsWebPageVo source, TsWebPageVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(TsWebPageVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }


    /**
     * 根据PrimaryKey查询
     * <p>
     * id  
     */
    @Override
    public TsWebPageVo queryByPrimaryKey(Integer id) {

        return dao.queryByPrimaryKey(id);

    }

    /**
     * 根据PrimaryKey删除
     * <p>
     * id : 
     */
    @Override
    public boolean deleteByPrimaryKey(Integer id) {

        return dao.deleteByPrimaryKey(id) > 0 ? true : false;

    }

}
