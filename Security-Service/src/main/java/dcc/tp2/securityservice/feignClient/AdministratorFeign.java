package dcc.tp2.securityservice.feignClient;

import dcc.tp2.securityservice.model.Administrator;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "receptionist-service" , url = "http://localhost:8085")
public interface AdministratorFeign {

        @GetMapping("/Administrator/email/{email}")
        @CircuitBreaker(name = "receptionist-service", fallbackMethod = "fallbackMethod")
        @Retry(name = "receptionist-service", fallbackMethod = "fallbackMethod")
        @RateLimiter(name = "receptionist-service", fallbackMethod = "fallbackMethod")
        Map<String,String> getAdministratorCredentials(@PathVariable String email);

        default Administrator fallbackMethod(String email, Throwable throwable){
            System.err.println("Fallback for email: " + email + ", exception: " + throwable.getMessage());
            return new Administrator();
        }

    }

