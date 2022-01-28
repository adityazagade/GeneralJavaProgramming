package primaryKeyGenerators;

public class Student {
    private String sname;
    private int smarks, sid, rank;
    private String semail;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSmarks() {
        return smarks;
    }

    public void setSmarks(int smarks) {
        this.smarks = smarks;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
