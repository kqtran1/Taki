package com.rastakiki.taki.expenses;

import java.util.Objects;

public class User {

    private final String userName;
    private long id;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final User user = (User) o;

        return Objects.equals(user.id, this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
