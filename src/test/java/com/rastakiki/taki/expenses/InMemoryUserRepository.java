package com.rastakiki.taki.expenses;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<User>();
    private final AtomicLong userIdGenerator = new AtomicLong();

    @Override
    public void save(User user) {
        user.setId(userIdGenerator.getAndIncrement());
        users.add(user);
    }

    @Override
    public User findUserByName(String userName) {
        return null;
    }
}
