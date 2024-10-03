package api.booking.services;

import api.booking.interfaces.FlightClient;
import api.booking.models.dtos.BookingDto;
import api.booking.models.dtos.FlightDto;
import api.booking.models.entities.Booking;
import api.booking.models.mappers.BookingMapper;
import api.booking.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightClient flightClient;

    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = BookingMapper.toEntity(bookingDto);
        Booking savedBooking = bookingRepository.save(booking);
        return BookingMapper.toDto(savedBooking);
    }

    public Optional<BookingDto> getBookingById(Long id) {
        return bookingRepository.findById(id).map(BookingMapper::toDto);
    }

    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(BookingMapper::toDto)
                .toList();
    }

    public Optional<BookingDto> updateBooking(Long id, BookingDto bookingDto) {
        if (bookingRepository.existsById(id)) {
            Booking bookingToUpdate = BookingMapper.toEntity(bookingDto);
            bookingToUpdate.setId(id);
            Booking updatedBooking = bookingRepository.save(bookingToUpdate);
            return Optional.of(BookingMapper.toDto(updatedBooking));
        }
        return Optional.empty();
    }

    public boolean deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public FlightDto getFlightInfo(UUID flightId) {
        return flightClient.getFlightById(flightId);
    }
}
