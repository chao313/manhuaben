package demo.spring.boot.demospringboot.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class IpadGet {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private HttpClient httpClient = null;
    private CustomGetMethod getMethod = null;

    public static String getString(String url) {
        return new IpadGet().getGetMethodString(url);
    }
    public static byte[] getBytes(String url) {
        return new IpadGet().getGetMethodBytes(url);
    }

    public String getGetMethodString(String url) {
        this.setUrl(url);
        try {
            httpClient.executeMethod(getMethod);
            return getMethod.getResponseBodyAsString();
        } catch (IOException e) {
            logger.error("[Ipad获取异常]:{}", e.toString(), e);
        } finally {
            this.close();
        }
        return null;

    }

    public byte[] getGetMethodBytes(String url) {
        this.setUrl(url);
        try {
            httpClient.executeMethod(getMethod);
            return getMethod.getResponseBody();
        } catch (IOException e) {
            logger.error("[Ipad获取异常]:{}", e.toString(), e);
        } finally {
            this.close();
        }
        return null;

    }


    private void setUrl(String url) {
        // 打开浏览器
        this.httpClient = new HttpClient();
        // 输入网址
        this.getMethod = new CustomGetMethod(url);
        this.getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; " +
                "Nexus 4 Build/LMY48T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Mobile Safari/537.36");
        this.httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");//设置编码格式
    }

    private void close() {
        // 释放连接
        if (null != getMethod) {
            this.getMethod.releaseConnection();
            this.getMethod = null;
        }
        httpClient = null;

    }

}
