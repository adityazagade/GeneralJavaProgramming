package beans.forms;

import org.apache.struts.validator.ValidatorForm;

import java.util.Date;

public class SlotBookingFormBean extends ValidatorForm {
    private String Stadium;
    private Date startTime, endTime;

    public String getStadium() {
        return Stadium;
    }

    public void setStadium(String stadium) {
        Stadium = stadium;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
