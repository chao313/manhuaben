package demo.spring.boot.demospringboot.mybatis.vo;


/**
 * 对应的表名   :ts_book
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-1
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */


public class TsBookVo {

    private Integer id; 
    private String bookUrl;  // book的url 
    private Integer bookIndex;  // book的索引 
    private String bookName;  // book的name 
    private Integer bookSize;  // book的size 


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


    @Override
    public String toString() {
        return "TsBookVo{" +
                ", id '" + id +
                ", bookUrl '" + bookUrl + '\'' +
                ", bookIndex '" + bookIndex +
                ", bookName '" + bookName + '\'' +
                ", bookSize '" + bookSize +
                '}';
    }

}
