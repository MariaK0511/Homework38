package by.tms.storage;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserData {
    private static final List<User> users = new ArrayList<>();

    public User saveUser(User user) {
        users.add(user);
        return user;
    }

    List<User> getUsers() {
        return users;
    }

    public Optional<User> findByName(String name) {
        for (User user : users) {
            if (user.getName() == name) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public void updateUser(String name, String surname, String password, List<OperationHistory> operationHistories) {
        Optional<User> user = this.findByName(name);
        User user1 = user.get();
        user1.setName(name);
        user1.setSurname(surname);
        user1.setPassword(password);
        user1.getOperationHistories(operationHistories);
    }
}
