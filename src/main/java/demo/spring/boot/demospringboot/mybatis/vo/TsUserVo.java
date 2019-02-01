package demo.spring.boot.demospringboot.mybatis.vo;


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


public class TsUserVo {

    private Integer id; 
    private String account;  // 账号 
    private String passwd;  // 密码 
    private String salt;  // 随机生成的加密salt 


    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getAccount() {

        return account;

    }

    public void setAccount(String account) {

        this.account = account;

    }

    public String getPasswd() {

        return passwd;

    }

    public void setPasswd(String passwd) {

        this.passwd = passwd;

    }

    public String getSalt() {

        return salt;

    }

    public void setSalt(String salt) {

        this.salt = salt;

    }


    @Override
    public String toString() {
        return "TsUserVo{" +
                ", id '" + id +
                ", account '" + account + '\'' +
                ", passwd '" + passwd + '\'' +
                ", salt '" + salt + '\'' +
                '}';
    }

}
