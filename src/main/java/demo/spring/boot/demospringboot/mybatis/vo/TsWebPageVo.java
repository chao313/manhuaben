package demo.spring.boot.demospringboot.mybatis.vo;


/**
 * 对应的表名   :ts_web_page
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建时间   :2019-2-2
 * 表字符集    :utf8_vietnamese_ci
 * 表注释      :
 */


public class TsWebPageVo {

    private Integer id; 
    private String webPageUrl; 
    private Integer webPageIndex; 


    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getWebPageUrl() {

        return webPageUrl;

    }

    public void setWebPageUrl(String webPageUrl) {

        this.webPageUrl = webPageUrl;

    }

    public Integer getWebPageIndex() {

        return webPageIndex;

    }

    public void setWebPageIndex(Integer webPageIndex) {

        this.webPageIndex = webPageIndex;

    }


    @Override
    public String toString() {
        return "TsWebPageVo{" +
                ", id '" + id +
                ", webPageUrl '" + webPageUrl + '\'' +
                ", webPageIndex '" + webPageIndex +
                '}';
    }

}
