package dao;

import model.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class BookingDAOImpl implements BookingDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public int save(Booking bk) {
        int id = (int) getCurrentSession().save(bk);
        return id;
    }

    @Override
    public List<Booking> getBookingByStadiumName(String stadium) {
        String getBookingsForStadium = "from Booking where stadium= :stadium";
        Query q = getCurrentSession().createQuery(getBookingsForStadium);
        q.setParameter("stadium", stadium);
        List<Booking> booking = q.list();
        return booking;
    }

    private Session getCurrentSession() {
        return sf.getCurrentSession();
    }
}
