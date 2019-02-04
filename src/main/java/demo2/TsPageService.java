package demo2;


import java.util.List;

import demo2.TsPageVo;


/**
 * 对应的表名   :ts_page
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-4
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */
public interface TsPageService {

    /**
     * insert
     */
    boolean insert(TsPageVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TsPageVo> vos);


    /**
     * 查询base
     */
    List<TsPageVo> queryBase(TsPageVo query);


    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TsPageVo source, TsPageVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TsPageVo source, TsPageVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TsPageVo vo);


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
    boolean deleteByPrimaryKey(Integer id);


}
