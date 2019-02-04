package demo.spring.boot.demospringboot.mybatis.service.impl;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.service.TsPageService;
import demo.spring.boot.demospringboot.mybatis.vo.TsPageVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.spring.boot.demospringboot.mybatis.dao.TsPageDao;


/**
 * 对应的表名   :ts_page
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-2
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */
@Service
public class TsPageServiceImpl implements TsPageService {

    @Autowired
    private TsPageDao dao;

    /**
     * insert
     */
    @Override
    public boolean insert(TsPageVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<TsPageVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<TsPageVo> queryBase(TsPageVo query) {

        return dao.queryBase(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(TsPageVo source, TsPageVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(TsPageVo source, TsPageVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(TsPageVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }


    /**
     * 根据PrimaryKey查询
     * <p>
     * id
     */
    @Override
    public TsPageVo queryByPrimaryKey(Integer id) {

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

    @Override
    public List<TsPageVo> queryBaseByIndexAndBookId(Integer pageIndex, Integer bookId) {
        TsPageVo query = new TsPageVo();
        query.setPageIndex(pageIndex);
        query.setBookId(bookId);
        return this.queryBase(query);
    }

    @Override
    public List<TsPageVo> queryBaseByBookId(Integer bookId) {
        TsPageVo query = new TsPageVo();
        query.setBookId(bookId);
        return this.queryBase(query);
    }

}
