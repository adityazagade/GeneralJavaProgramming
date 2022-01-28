package dao;

import model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PlayerDaoImpl implements PlayerDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public int save(Player pl) {
        return (int) getCurrentSession().save(pl);
    }

    @Override
    public Player getUserByEmail(String email) {
        String getByEmail = "from Player where email = :email";
        Query q = getCurrentSession().createQuery(getByEmail);
        q.setParameter("email", email);
        List<Player> players = q.list();
        return players.size() == 0 ? null : players.get(0);
    }

    private Session getCurrentSession() {
        return sf.getCurrentSession();
    }
}
