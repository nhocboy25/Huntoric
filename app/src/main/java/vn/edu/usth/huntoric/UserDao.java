package vn.edu.usth.huntoric;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Dao;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    User login(String username, String password);
}
