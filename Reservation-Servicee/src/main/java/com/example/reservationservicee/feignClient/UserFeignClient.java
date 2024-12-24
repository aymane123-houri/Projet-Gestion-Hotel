package com.example.reservationservicee.feignClient;

import com.example.reservationservicee.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-service" , url = "http://localhost:8081")
@FeignClient(name = "user-service" , url = "http://user-service:8081")
public interface UserFeignClient {
    @GetMapping("/Utilisateurs/{id}")
    @CircuitBreaker(name = "user-service", fallbackMethod = "fallbackMethod")
    @Retry(name = "user-service", fallbackMethod = "fallbackMethod")
    @RateLimiter(name = "user-service", fallbackMethod = "fallbackMethod")
    User getUserById(@PathVariable Long id);

    default User fallbackMethod(Long id, Throwable throwable){
        System.err.println("Fallback for id: " + id + ", exception: " + throwable.getMessage());
        return new User();
    }
}
