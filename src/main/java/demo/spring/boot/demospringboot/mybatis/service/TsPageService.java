package demo.spring.boot.demospringboot.mybatis.service;


import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.TsPageVo;


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
     * 查询base Count
     */
    Integer queryBaseCount(TsPageVo query);


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

    /**
     * 根据index和bookId查询
     *
     * @param pageIndex
     * @param bookId
     * @return
     */
    List<TsPageVo> queryBaseByIndexAndBookId(Integer pageIndex, Integer bookId);

    /**
     * 根据bookId查询
     *
     * @param bookId
     * @return
     */
    List<TsPageVo> queryBaseByBookId(Integer bookId);

    /**
     * 根据id分页查询
     *
     * @param bookId
     * @return
     */
    List<TsPageVo> queryBasePage(Integer start, Integer end);


    /**
     * 根据id分页查询
     *
     * @param bookId
     * @return
     */
    List<TsPageVo> queryBaseIds(Integer start, Integer end);

}
