# Spring Boot Cache Example

- add this as dependency for spring boot to provide caching abilities and abstraction

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>


- If no cache implementation is provided then ConcurrentMap would be used as implementation


## For Using EhCache

- add this as dependency

		<dependency>
			<groupId>net.sf.ehcache</groupId>
			<artifactId>ehcache</artifactId>
		</dependency>
		
- spring boot will provide EhCache as implementation if ehCache.xml is present in class path

- specific cache properties can be defined either in xml or java form

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
        
        
        <cache name="employees"
             maxElementsInMemory="100"
             eternal="false"
             overflowToDisk="false"
             timeToLiveSeconds="600"
             timeToIdleSeconds="0"
             memoryStoreEvictionPolicy="LFU"
             transactionalMode="off">
        </cache>
        		
        		
## Caching Annotations

- @Cacheable : Triggers cache population
- @CachePut : Updates the cache, without interfering with the method execution
- @CacheEvict : Triggers cache eviction (removing items from cache)
- @Caching : Regroups multiple cache operations to be applied on a method
- @CacheConfig : Shares some common cache-related settings at class-level
- @EnableCaching : Configuration level annotation, enables Caching

