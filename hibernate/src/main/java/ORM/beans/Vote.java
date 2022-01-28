package ORM.beans;

import java.util.Date;

public class Vote {
    private int vid;
    private String toCandidate;
    private Voter voter;
    private Date castDate;

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getToCandidate() {
        return toCandidate;
    }

    public void setToCandidate(String toCandidate) {
        this.toCandidate = toCandidate;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public Date getCastDate() {
        return castDate;
    }

    public void setCastDate(Date castDate) {
        this.castDate = castDate;
    }
}
