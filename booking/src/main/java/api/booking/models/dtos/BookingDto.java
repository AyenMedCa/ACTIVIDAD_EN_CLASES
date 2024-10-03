package api.booking.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDto {
    private Long id;
    private String flightNumber;
    private String passengerName;
}
