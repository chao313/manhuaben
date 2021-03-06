package demo.spring.boot.demospringboot.mybatis.dao;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsUserVo;

import org.apache.ibatis.annotations.Param;


/**
 * 对应的表名   :ts_user
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-1
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */
public interface TsUserDao {

    /**
     * insert
     */
    int insert(TsUserVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TsUserVo> vos);

    /**
     * 查询base
     */
    List<TsUserVo> queryBase(TsUserVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TsUserVo source, @Param(value = "target") TsUserVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TsUserVo source, @Param(value = "target") TsUserVo target);

    /**
     * 删除base
     */
    int deleteBase(TsUserVo vo);



    /**
     * 根据PrimaryKey查询
     * <p>
     * id : 
     */
    TsUserVo queryByPrimaryKey(Integer id);

    /**
     * 根据PrimaryKey删除
     * <p>
     * id : 
     */
    int deleteByPrimaryKey(Integer id);

}
