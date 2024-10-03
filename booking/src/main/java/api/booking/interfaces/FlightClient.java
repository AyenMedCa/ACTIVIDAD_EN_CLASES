package api.booking.interfaces;

import api.booking.models.dtos.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@FeignClient(name = "flight")  // "flight" es el nombre del servicio registrado en Eureka
public interface FlightClient {
    @GetMapping("/api/v1/flights/{id}")
    FlightDto getFlightById(@PathVariable("id") UUID id);
}
