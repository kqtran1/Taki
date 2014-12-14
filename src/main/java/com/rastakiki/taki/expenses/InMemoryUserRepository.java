package com.rastakiki.taki.expenses;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository {

    private final Set<User> users = new HashSet<User>();
    private final AtomicLong userIdGenerator = new AtomicLong();

    @Override
    public void save(User user) {
        user.setId(userIdGenerator.getAndIncrement());
        users.add(user);
    }

    @Override
    public User findUserByName(String userName) {
        final Optional<User> user = users.stream().filter(u -> u.getUserName().equals(userName)).findFirst();
        return user.get();
    }
}
