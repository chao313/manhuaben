package demo.spring.boot.demospringboot.mybatis.vo;

import java.sql.Timestamp;

/**
 * 对应的表名   :ts_book
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-2
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */


public class TsBookVo {

    private Integer id; 
    private String bookUrl;  // book的url 
    private Integer bookIndex;  // book的索引 
    private String bookName;  // book的name 
    private Integer bookSize;  // book的size 
    private byte[] bookCovers;  // book的封面 
    private String bookCoversUrl;  // book的封面的url 
    private Timestamp createTime;  // 创建的日期 


    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getBookUrl() {

        return bookUrl;

    }

    public void setBookUrl(String bookUrl) {

        this.bookUrl = bookUrl;

    }

    public Integer getBookIndex() {

        return bookIndex;

    }

    public void setBookIndex(Integer bookIndex) {

        this.bookIndex = bookIndex;

    }

    public String getBookName() {

        return bookName;

    }

    public void setBookName(String bookName) {

        this.bookName = bookName;

    }

    public Integer getBookSize() {

        return bookSize;

    }

    public void setBookSize(Integer bookSize) {

        this.bookSize = bookSize;

    }

    public byte[] getBookCovers() {

        return bookCovers;

    }

    public void setBookCovers(byte[] bookCovers) {

        this.bookCovers = bookCovers;

    }

    public String getBookCoversUrl() {

        return bookCoversUrl;

    }

    public void setBookCoversUrl(String bookCoversUrl) {

        this.bookCoversUrl = bookCoversUrl;

    }

    public Timestamp getCreateTime() {

        return createTime;

    }

    public void setCreateTime(Timestamp createTime) {

        this.createTime = createTime;

    }


    @Override
    public String toString() {
        return "TsBookVo{" +
                ", id '" + id +
                ", bookUrl '" + bookUrl + '\'' +
                ", bookIndex '" + bookIndex +
                ", bookName '" + bookName + '\'' +
                ", bookSize '" + bookSize +
                ", bookCovers '" + bookCovers +
                ", bookCoversUrl '" + bookCoversUrl + '\'' +
                ", createTime '" + createTime +
                '}';
    }

}
