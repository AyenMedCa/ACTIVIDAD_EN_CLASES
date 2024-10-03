package api.booking.controllers;

import api.booking.models.dtos.FlightDto;
import api.booking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/flight-info/{flightId}")
    public FlightDto getFlightInfo(@PathVariable UUID flightId) {
        return bookingService.getFlightInfo(flightId);
    }
}
