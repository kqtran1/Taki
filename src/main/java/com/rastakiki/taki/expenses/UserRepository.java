package com.rastakiki.taki.expenses;

public interface UserRepository {

    void save(User user);

    User findUserByName(String userName);

}
