package api.fligth.models.mappers;

import api.fligth.models.dtos.FlightDto;
import api.fligth.models.entities.Flight;

public class FlightMapper {
    public static FlightDto toDTO(Flight flight) {
        if (flight == null) {
            return null;
        }
        return new FlightDto(
                flight.getId(),
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDepartureTime()
        );
    }

    public static Flight toEntity(FlightDto flightDTO) {
        if (flightDTO == null) {
            return null;
        }
        Flight flight = new Flight();
        flight.setId(flightDTO.getId());
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setOrigin(flightDTO.getOrigin());
        flight.setDestination(flightDTO.getDestination());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        return flight;
    }
}
