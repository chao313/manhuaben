package demo.spring.boot.demospringboot.mybatis.vo;


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


public class TsParamVo {

    private String key; 
    private String value; 
    private String des; 


    public String getKey() {

        return key;

    }

    public void setKey(String key) {

        this.key = key;

    }

    public String getValue() {

        return value;

    }

    public void setValue(String value) {

        this.value = value;

    }

    public String getDes() {

        return des;

    }

    public void setDes(String des) {

        this.des = des;

    }


    @Override
    public String toString() {
        return "TsParamVo{" +
                ", key '" + key + '\'' +
                ", value '" + value + '\'' +
                ", des '" + des + '\'' +
                '}';
    }

}
