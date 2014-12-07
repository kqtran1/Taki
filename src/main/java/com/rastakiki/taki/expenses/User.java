package com.rastakiki.taki.expenses;

import java.util.Objects;

public class User {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final User user = (User) o;

        return Objects.equals(user.userName, this.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
