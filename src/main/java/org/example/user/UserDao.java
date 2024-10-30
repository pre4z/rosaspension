package org.example.user;

import java.util.List;

public interface UserDao
{
    User getUserByID(int userID) throws Exception;
    List<User> getAllUsers() throws Exception;
    void deleteUsers(int userID) throws Exception;
    void updateUser(User user) throws Exception;
    void createUser(User user ) throws Exception;
}