package by.tms.controller;

import by.tms.entity.CalculatorData;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
import by.tms.service.UserService;
import by.tms.storage.OperationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/calc") //localhost:8080/calc
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @Autowired
    UserService userService;


    @GetMapping("/reg") //localhost:8080/calc/reg
    public String user() {
        return "reg";
    }

    @PostMapping("/reg")
    public String user(User user, Model model) {
        model.addAttribute("user", user);
        userService.saveUser(user);
        return "redirect:/calc/logIn";
    }

    @GetMapping("/logIn") //localhost:8080/calc/logIn
    public String existUser() {
        return "logIn";
    }

    @PostMapping("/logIn") //localhost:8080/calc/logIn
    public String existUser(User user, Model model) {
        Optional<User> currentUser = userService.findUser(user);
        if (currentUser.isPresent()) {
            if (currentUser.get().getName().equals(user.getName()) &&
                    currentUser.get().getSurname().equals(user.getSurname()) &&
                    currentUser.get().getPassword().equals(user.getPassword())) {
                return "redirect:/calc/operation";
            }
        } else {
            throw new RuntimeException("such user doesn't exist");
        }
        model.addAttribute("user", user);
        return "redirect:/calc/operation";
    }


    @GetMapping("/operation") //localhost:8080/calc/operation
    public String calculator() {
        return "operation";
    }

    @PostMapping("/operation") //localhost:8080/calc/operation
    public String calculator(CalculatorData calculatorData, User user,  Model model) {
        userService.findUser(user);
        double calculate = calculatorService.calculate(calculatorData);
        model.addAttribute("calculate", calculate);
        userService.addOperationHistory(user, calculatorData);
        return "redirect:/calc/info";
    }

    @GetMapping("/info") //localhost:8080/calc/info
    public String userInfo(User user, Model model) {
        model.addAttribute("userOperationHistory", userService.findUser(user));
        return "info";
    }
}