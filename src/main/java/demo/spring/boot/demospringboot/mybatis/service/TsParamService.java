package demo.spring.boot.demospringboot.service;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsParamVo;


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
public interface TsParamService {

    /**
     * insert
     */
    boolean insert(TsParamVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TsParamVo> vos);


    /**
     * 查询base
     */
    List<TsParamVo> queryBase(TsParamVo query);


    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TsParamVo source, TsParamVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TsParamVo source, TsParamVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TsParamVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * key : 
     */
    TsParamVo queryByPrimaryKey(String key);

    /**
     * 根据PrimaryKey删除
     * <p>
     * key : 
     */
    boolean deleteByPrimaryKey(String key);


}
