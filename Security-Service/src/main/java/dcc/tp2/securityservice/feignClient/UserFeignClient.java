package dcc.tp2.securityservice.feignClient;

import dcc.tp2.securityservice.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "user-service" , url = "http://localhost:8888/user-service")
public interface UserFeignClient {
    @GetMapping("/Utilisateurs/email/{email}")
    @CircuitBreaker(name = "user-service", fallbackMethod = "fallbackMethod")
    @Retry(name = "user-service", fallbackMethod = "fallbackMethod")
    @RateLimiter(name = "user-service", fallbackMethod = "fallbackMethod")
    Map<String,String> getUserCredentials(@PathVariable String email);

    default User fallbackMethod(String email, Throwable throwable){
        System.err.println("Fallback for email: " + email + ", exception: " + throwable.getMessage());
        return new User();
    }
}