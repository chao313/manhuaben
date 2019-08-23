package demo.spring.boot.demospringboot.mybatis.service.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventBus implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AsyncEventBus asyncEventBus;

    @Autowired
    private Download download;

    @Override
    public void afterPropertiesSet() throws Exception {
        asyncEventBus.register(this);
        asyncEventBus.register(download);
    }

    public void post(Object obj) {
        asyncEventBus.post(obj);
    }


}
