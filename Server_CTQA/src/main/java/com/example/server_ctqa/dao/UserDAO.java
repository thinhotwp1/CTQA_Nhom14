package com.example.server_ctqa.dao;


import com.example.server_ctqa.model.User;

import java.util.List;

public interface UserDAO {
    void createTableUser();

    void deleteTbl();

    boolean insertUser(User user);

    int updateInfor(String username, String fullname, String pass);

    boolean deleteUser(String username);

    List<User> getListUser();

    int countListUser();

    User findOne(String username);

    boolean checkAccount(String username, String password);
}
