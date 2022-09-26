package by.tms.service;


import by.tms.entity.User;
import by.tms.storage.UserData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    UserData userData;

    private static final List<User> users = new ArrayList<>();

    public User saveUser(User user) {
        userData.saveUser(user);
        return user;
    }

    public Optional<User> findUser(User user) {
        userData.findByName(user.getName());
        return findUser(user);
    }

    public void updateUserInf(User user) {
        userData.updateUser(user.getName(), user.getSurname(), user.getPassword(), user.getOperationHistories(List.of()));
    }
}