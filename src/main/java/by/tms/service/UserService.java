package by.tms.service;


import by.tms.entity.CalculatorData;
import by.tms.entity.User;
import by.tms.storage.OperationHistory;
import by.tms.storage.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
   private UserData userData;

    public User saveUser(User user) {
        userData.saveUser(user);
        return user;
    }

    public User findUser(User user) {
        Optional<User> userByName = userData.findByName(user.getName());
        return userByName.orElse(null);
    }

    public List<CalculatorData> addOperationHistory(User user, CalculatorData calculatorData){
        user.getCalculatorData().add(calculatorData);
        return user.getCalculatorData();
    }
}