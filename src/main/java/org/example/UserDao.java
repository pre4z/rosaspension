package org.example;

public interface UserDao
{
    void readUser(String no) throws Exception;
    void readAllUsers() throws Exception;
    void createUser(User user ) throws Exception;
}