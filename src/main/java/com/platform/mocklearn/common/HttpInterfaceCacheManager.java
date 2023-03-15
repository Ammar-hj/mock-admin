package com.platform.mocklearn.common;

import com.platform.mocklearn.model.request.HttpInterfaceKeyReq;
import com.platform.mocklearn.model.request.HttpInterfaceReq;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class HttpInterfaceCacheManager {

    @Autowired
    private RedisTemplate<String, HttpInterfaceReq> httpInterfaceRedisTemplate;

    private String buildKey(HttpInterfaceKeyReq httpInterfaceKeyReq) {
        return String.format("MOCK:HTTP-INTERFACE:%s:%s",
                httpInterfaceKeyReq.getRequestMethod(), httpInterfaceKeyReq.getRequestUri());
    }

    public void clear(HttpInterfaceKeyReq httpInterfaceKeyReq) {
        httpInterfaceRedisTemplate.delete(buildKey(httpInterfaceKeyReq));
    }

    public HttpInterfaceReq get(HttpInterfaceKeyReq httpInterfaceKeyReq) {
        String key = buildKey(httpInterfaceKeyReq);
        if (BooleanUtils.isTrue(httpInterfaceRedisTemplate.hasKey(key))) {
            return httpInterfaceRedisTemplate.opsForValue().get(key);
        } else {
            return null;
        }
    }

    public void set(HttpInterfaceReq httpInterfaceReq) {
        String key = buildKey(httpInterfaceReq);
        httpInterfaceRedisTemplate.opsForValue().set(key, httpInterfaceReq);
    }
}
