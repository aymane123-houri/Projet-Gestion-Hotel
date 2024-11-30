package org.example.reservationservice.feignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.example.reservationservice.model.Chambre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "chambre-service" , url = "http://127.0.0.1:5000")
public interface ChambreFeignClient {
    @GetMapping("/chambres/{id}")
    @CircuitBreaker(name = "chambre-service", fallbackMethod = "fallbackMethod")
    @Retry(name = "chambre-service", fallbackMethod = "fallbackMethod")
    @RateLimiter(name = "chambre-service", fallbackMethod = "fallbackMethod")
    Chambre getChambreById(@PathVariable Long id);

    default Chambre fallbackMethod(Long id, Throwable throwable){
        System.err.println("Fallback for id: " + id + ", exception: " + throwable.getMessage());
        return new Chambre();
    }
}
