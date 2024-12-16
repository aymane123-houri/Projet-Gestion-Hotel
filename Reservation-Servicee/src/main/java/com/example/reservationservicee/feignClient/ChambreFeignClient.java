package com.example.reservationservicee.feignClient;

import com.example.reservationservicee.model.Chambre;
import feign.Param;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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


    @GetMapping("/chambres")
    List<Chambre> getAllChambres();

}
