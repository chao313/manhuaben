package demo2;


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


public class TsPageVo {

    private Integer id; 
    private String pageUrl;  // 页面的url 
    private String pageImageUrl;  // 页面image的url 
    private byte[] pageImage;  // 页面image的流 
    private Integer pageIndex;  // 页面索引 
    private Integer bookId;  // 对应book的id 
    private String loaclImageUrl;  // 本地的url 


    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getPageUrl() {

        return pageUrl;

    }

    public void setPageUrl(String pageUrl) {

        this.pageUrl = pageUrl;

    }

    public String getPageImageUrl() {

        return pageImageUrl;

    }

    public void setPageImageUrl(String pageImageUrl) {

        this.pageImageUrl = pageImageUrl;

    }

    public byte[] getPageImage() {

        return pageImage;

    }

    public void setPageImage(byte[] pageImage) {

        this.pageImage = pageImage;

    }

    public Integer getPageIndex() {

        return pageIndex;

    }

    public void setPageIndex(Integer pageIndex) {

        this.pageIndex = pageIndex;

    }

    public Integer getBookId() {

        return bookId;

    }

    public void setBookId(Integer bookId) {

        this.bookId = bookId;

    }

    public String getLoaclImageUrl() {

        return loaclImageUrl;

    }

    public void setLoaclImageUrl(String loaclImageUrl) {

        this.loaclImageUrl = loaclImageUrl;

    }


    @Override
    public String toString() {
        return "TsPageVo{" +
                ", id '" + id +
                ", pageUrl '" + pageUrl + '\'' +
                ", pageImageUrl '" + pageImageUrl + '\'' +
                ", pageImage '" + pageImage +
                ", pageIndex '" + pageIndex +
                ", bookId '" + bookId +
                ", loaclImageUrl '" + loaclImageUrl + '\'' +
                '}';
    }

}
