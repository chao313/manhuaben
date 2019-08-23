package demo.spring.boot.demospringboot.mybatis.service.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class MyAsyncEventBus extends AsyncEventBus {

    public MyAsyncEventBus() {
        super(new ThreadPoolExecutor(20, 20,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.CallerRunsPolicy()));
    }
}
