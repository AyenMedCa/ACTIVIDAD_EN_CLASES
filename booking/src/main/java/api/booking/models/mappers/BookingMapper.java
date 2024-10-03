package api.booking.models.mappers;

import api.booking.models.dtos.BookingDto;
import api.booking.models.entities.Booking;

public class BookingMapper {
    public static BookingDto toDto(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setFlightNumber(booking.getFlightNumber());
        bookingDto.setPassengerName(booking.getPassengerName());
        return bookingDto;
    }

    // Método para convertir de BookingDto a Booking
    public static Booking toEntity(BookingDto bookingDto) {
        if (bookingDto == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setFlightNumber(bookingDto.getFlightNumber());
        booking.setPassengerName(bookingDto.getPassengerName());
        return booking;
    }
}
