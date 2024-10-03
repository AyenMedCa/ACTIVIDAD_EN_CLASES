package api.fligth.controllers;

import api.fligth.models.dtos.FlightDto;
import api.fligth.models.entities.Flight;
import api.fligth.models.mappers.FlightMapper;
import api.fligth.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flights")
public class FlightController {
    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDTO) {
        Flight flight = FlightMapper.toEntity(flightDTO);
        Flight savedFlight = flightService.createFlight(flight);
        return ResponseEntity.ok(FlightMapper.toDTO(savedFlight));
    }

    @GetMapping
    public ResponseEntity<List
            <FlightDto>> getAllFlights() {
        List<FlightDto> flightDTOs = flightService.getAllFlights().stream()
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(flightDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable UUID id) {
        return flightService.getFlightById(id)
                .map(flight -> ResponseEntity.ok(FlightMapper.toDTO(flight)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable UUID id, @RequestBody FlightDto flightDTO) {
        Flight updatedFlight = FlightMapper.toEntity(flightDTO);
        return flightService.updateFlight(id, updatedFlight)
                .map(flight -> ResponseEntity.ok(FlightMapper.toDTO(flight)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable UUID id) {
        boolean deleted = flightService.deleteFlight(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
