package org.vs.demo;

import net.sf.ehcache.CacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringBootCacheableExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheableExampleApplication.class, args);
    }

}
