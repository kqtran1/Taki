package com.rastakiki.taki.expenses;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void usersWithSameId_areEquals() {
        final User user1 = createUser("User1", 10L);
        final User user2 = createUser("User2", 10L);

        assertThat(user1).isEqualTo(user2);
    }

    @Test
    public void usersWithSameId_haveSameHashcode() {
        final User user1 = createUser("User1", 10L);
        final User user2 = createUser("User2", 10L);

        assertThat(user1.hashCode()).isEqualTo(user2.hashCode());
    }

    private User createUser(String userName, long userId) {
        final User user = new User(userName);
        user.setId(userId);
        return user;
    }

}