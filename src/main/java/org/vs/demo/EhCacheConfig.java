package org.vs.demo;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EhCacheConfig {

    @Bean(name = "employees")
    public Ehcache employeesCache() {
        boolean overflowToDisk = false;
        boolean eternal = false;
        int maxElementsInMemory = 1000;
        int tenMinutes = 10 * 60;
        int timeToLiveSeconds = tenMinutes;
        int timeToIdleSeconds = tenMinutes;

        Cache cache = new Cache("employees", maxElementsInMemory, overflowToDisk, eternal, timeToLiveSeconds, timeToIdleSeconds);
        CacheManager.getInstance().addCache(cache);

        return cache;
    }
}
