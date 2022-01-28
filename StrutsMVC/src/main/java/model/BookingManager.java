package model;

import java.util.Date;

public interface BookingManager {
    int bookSlot(String stadium, Date startTime, Date endTime) throws Exception;
}
