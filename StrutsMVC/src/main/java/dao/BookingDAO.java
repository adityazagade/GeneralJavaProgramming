package dao;

import model.Booking;

import java.util.List;

public interface BookingDAO {
    int save(Booking pl);

    List<Booking> getBookingByStadiumName(String stadium);
}
