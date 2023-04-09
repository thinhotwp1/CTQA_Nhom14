package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void createTableUser();

    void deleteTbl();

    boolean insertUser(User user);
    
    int updateInfor(String username, String fullname, String pass);

    void deleteUser(String username);

    List<User> getListUser();

    User findOne(String username);
    
    boolean checkAccount(String username, String password);
}
