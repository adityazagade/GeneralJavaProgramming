package cache;
//There are three levels of support that hibernate provides for caching ...
// 1. Session lvel (default)  --> One user
// 2. SessionFactory Lvel     --> All Users
// 3. Query Lvel               --> One instance
public class Student {
    private String sname;
    private int smarks, sid;
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
}
