package dao;

import model.Player;

public interface PlayerDAO {
    int save(Player pl);

    Player getUserByEmail(String email);

//    Player getUserById(int id);
}
