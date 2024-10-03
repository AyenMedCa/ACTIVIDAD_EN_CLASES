package api.fligth.services;

import api.fligth.models.entities.Flight;
import api.fligth.repositories.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Obtener todos los vuelos
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Obtener un vuelo por ID
    public Optional<Flight> getFlightById(UUID id) {
        return flightRepository.findById(id);
    }

    // Actualizar un vuelo existente
    public Optional<Flight> updateFlight(UUID id, Flight updatedFlight) {
        return flightRepository.findById(id)
                .map(existingFlight -> {
                    existingFlight.setFlightNumber(updatedFlight.getFlightNumber());
                    existingFlight.setOrigin(updatedFlight.getOrigin());
                    existingFlight.setDestination(updatedFlight.getDestination());
                    existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
                    return flightRepository.save(existingFlight);
                });
    }

    // Eliminar un vuelo por ID
    public boolean deleteFlight(UUID id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
