package demo.spring.boot.demospringboot.mybatis.service;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsBookVo;


/**
 * 对应的表名   :ts_book
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-4
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */
public interface TsBookService {

    /**
     * insert
     */
    boolean insert(TsBookVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TsBookVo> vos);


    /**
     * 查询base
     */
    List<TsBookVo> queryBase(TsBookVo query);

    /**
     * 查询base Count
     */
    Integer queryBaseCount(TsBookVo query);


    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TsBookVo source, TsBookVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TsBookVo source, TsBookVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TsBookVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * id :
     */
    TsBookVo queryByPrimaryKey(Integer id);

    /**
     * 根据PrimaryKey删除
     * <p>
     * id :
     */
    boolean deleteByPrimaryKey(Integer id);


}
