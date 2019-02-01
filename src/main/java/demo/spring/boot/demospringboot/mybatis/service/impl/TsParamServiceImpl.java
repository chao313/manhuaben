package demo.spring.boot.demospringboot.service.impl;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsParamVo;
import demo.spring.boot.demospringboot.service.TsParamService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.spring.boot.demospringboot.mybatis.dao.TsParamDao;



/**
 * 对应的表名   :ts_param
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-1
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */
@Service
public class TsParamServiceImpl implements TsParamService {

    @Autowired
    private TsParamDao dao;

    /**
     * insert
     */
    @Override
    public boolean insert(TsParamVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<TsParamVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<TsParamVo> queryBase(TsParamVo query) {

        return dao.queryBase(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(TsParamVo source, TsParamVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(TsParamVo source, TsParamVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(TsParamVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }


    /**
     * 根据PrimaryKey查询
     * <p>
     * key  
     */
    @Override
    public TsParamVo queryByPrimaryKey(String key) {

        return dao.queryByPrimaryKey(key);

    }

    /**
     * 根据PrimaryKey删除
     * <p>
     * key : 
     */
    @Override
    public boolean deleteByPrimaryKey(String key) {

        return dao.deleteByPrimaryKey(key) > 0 ? true : false;

    }

}
