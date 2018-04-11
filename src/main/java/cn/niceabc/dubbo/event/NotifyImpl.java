package cn.niceabc.dubbo.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotifyImpl implements Notify {

    private static Logger log = LoggerFactory.getLogger(NotifyImpl.class);

    public void onthrow(Throwable ex, String name) {
        log.error("{}",ex.getMessage(), ex);
    }
}
