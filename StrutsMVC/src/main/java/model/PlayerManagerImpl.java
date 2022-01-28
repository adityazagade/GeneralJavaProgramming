package model;

import dao.PlayerDAO;
import org.springframework.transaction.annotation.Transactional;

public class PlayerManagerImpl implements PlayerManager {

    private PlayerDAO playerDAO;

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Transactional
    @Override
    public int registerPlayer(String name, String address, String email, String gender, int age) throws Exception {
        //check if the player already exists against that userName;
        if (!checkIfPayerExists(email)) {
            Player pl = new Player(name, address, email, gender, age);
            return playerDAO.save(pl);
        } else {
            //throw an Exception that the email id already exists against an entry.
            throw new Exception("email id already in use");
        }
    }

    private boolean checkIfPayerExists(String email) {
        Player existingPlayer = playerDAO.getUserByEmail(email);
        return existingPlayer != null;
    }

//    private boolean checkIfPlayerExists(int id) {
//        Player existingPlayer = playerDAO.getUserById(id);
//        return existingPlayer != null;
//    }
}
