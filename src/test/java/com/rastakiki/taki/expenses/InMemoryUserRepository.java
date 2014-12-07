package com.rastakiki.taki.expenses;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<User>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findUserByName(String userName) {
        return null;
    }
}
