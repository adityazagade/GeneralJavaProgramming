package model;

import dao.BookingDAO;

import java.util.Date;
import java.util.List;

public class BookingManagerImpl implements BookingManager {

    private BookingDAO bookingDAO;

    public void setBookingDAO(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public int bookSlot(String stadium, Date startTime, Date endTime) throws Exception {
        if (!checkIfAlreadyBooked(stadium, startTime, endTime)) {
            Booking pl = new Booking(stadium, startTime, endTime);
            return bookingDAO.save(pl);
        } else {
            //throw an Exception that the email id already exists against an entry.
            throw new Exception("Slot already booked");
        }

    }

    private boolean checkIfAlreadyBooked(String stadium, Date startTime, Date endTime) {
        List<Booking> bookings = bookingDAO.getBookingByStadiumName(stadium);
        return bookings.stream().anyMatch(booking -> {
            boolean isFree = true;
            boolean test1 = startTime.compareTo(booking.getStartTime()) < 0 && endTime.compareTo(booking.getEndTime()) > 0;
            boolean test2 = startTime.compareTo(booking.getStartTime()) >= 0 && endTime.compareTo(booking.getEndTime()) <= 0;
            boolean test3 = startTime.compareTo(booking.getStartTime()) < 0 && endTime.compareTo(booking.getEndTime()) >= 0;
            if (test1 || test2 || test3) {
                isFree = false;
            }
            return isFree;
        });
    }
}
