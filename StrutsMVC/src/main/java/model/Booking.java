package model;

import java.util.Date;

public class Booking {
    private String stadium;
    private Date startTime, endTime;

    public Booking(String stadium, Date startTime, Date endTime) {
        this.stadium = stadium;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Booking() {
    }

    public String getStadium() {
        return stadium;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

}
