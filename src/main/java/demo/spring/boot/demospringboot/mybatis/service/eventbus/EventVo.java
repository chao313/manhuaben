package demo.spring.boot.demospringboot.mybatis.service.eventbus;

import java.io.File;

public class EventVo {

    private String pageImageUrl;
    private File pagePathFile;

    public String getPageImageUrl() {
        return pageImageUrl;
    }

    public void setPageImageUrl(String pageImageUrl) {
        this.pageImageUrl = pageImageUrl;
    }

    public File getPagePathFile() {
        return pagePathFile;
    }

    public void setPagePathFile(File pagePathFile) {
        this.pagePathFile = pagePathFile;
    }
}
