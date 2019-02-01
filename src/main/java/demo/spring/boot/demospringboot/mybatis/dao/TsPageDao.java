package demo.spring.boot.demospringboot.mybatis.dao;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsPageVo;

import org.apache.ibatis.annotations.Param;


/**
 * 对应的表名   :ts_page
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-1
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */
public interface TsPageDao {

    /**
     * insert
     */
    int insert(TsPageVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TsPageVo> vos);

    /**
     * 查询base
     */
    List<TsPageVo> queryBase(TsPageVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TsPageVo source, @Param(value = "target") TsPageVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TsPageVo source, @Param(value = "target") TsPageVo target);

    /**
     * 删除base
     */
    int deleteBase(TsPageVo vo);



    /**
     * 根据PrimaryKey查询
     * <p>
     * id : 
     */
    TsPageVo queryByPrimaryKey(Integer id);

    /**
     * 根据PrimaryKey删除
     * <p>
     * id : 
     */
    int deleteByPrimaryKey(Integer id);

}
