package demo.spring.boot.demospringboot.mybatis.service;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsWebPageVo;


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
public interface TsWebPageService {

    /**
     * insert
     */
    boolean insert(TsWebPageVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TsWebPageVo> vos);


    /**
     * 查询base
     */
    List<TsWebPageVo> queryBase(TsWebPageVo query);


    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TsWebPageVo source, TsWebPageVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TsWebPageVo source, TsWebPageVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TsWebPageVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * id : 
     */
    TsWebPageVo queryByPrimaryKey(Integer id);

    /**
     * 根据PrimaryKey删除
     * <p>
     * id : 
     */
    boolean deleteByPrimaryKey(Integer id);


}
