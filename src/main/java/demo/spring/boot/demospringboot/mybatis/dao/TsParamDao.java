package demo.spring.boot.demospringboot.mybatis.dao;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsParamVo;

import org.apache.ibatis.annotations.Param;


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
public interface TsParamDao {

    /**
     * insert
     */
    int insert(TsParamVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TsParamVo> vos);

    /**
     * 查询base
     */
    List<TsParamVo> queryBase(TsParamVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TsParamVo source, @Param(value = "target") TsParamVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TsParamVo source, @Param(value = "target") TsParamVo target);

    /**
     * 删除base
     */
    int deleteBase(TsParamVo vo);



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
    int deleteByPrimaryKey(String key);

}
