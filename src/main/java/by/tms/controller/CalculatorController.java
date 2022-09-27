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
    public String userInfo(User user, Model model) {
        model.addAttribute("user", user);
        userService.saveUser(user);
        return "redirect:/logIn";
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
                return "redirect:/reg";
            }
        } else {
            throw new RuntimeException("such user doesn't exist");
        }
        model.addAttribute("user", user);
        return "logIn";
    }


    @GetMapping("/operation") //localhost:8080/calc/operation
    public String calculator() {
        return "operation";
    }

    @PostMapping("/operation") //localhost:8080/calc/operation
    public String calculator(@RequestParam double num1,
                             @RequestParam double num2,
                             @RequestParam String operation, Model model) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);
        CalculatorData calculatorData = new CalculatorData();
        calculatorData.setNum1(num1);
        calculatorData.setNum2(num2);
        calculatorData.setOperation(operation);
        double calculate = calculatorService.calculate(calculatorData);
        model.addAttribute("calculate", calculate);
        return "operation";
    }


    @GetMapping("/info") //localhost:8080/calc/operation
    public String userInfo(Map<String, Object> model) {
        User user = new User();
        model.put("user", userService.addOperationHistory(user, new CalculatorData()));
        return "info";
    }


//
//    @RequestMapping("/new") //localhost:8080/calc/new
//    public String newUser(Map<String, Object> model) {
//        User user = new User();
//        model.put("user", user);
//        return "user";
//    }
//
//    @RequestMapping(value = "/submit", method = RequestMethod.POST)
//    public String saveCustomer(@ModelAttribute("customer") User user) {
//        model.addAttribute("surname", user.getSurname());
//        model.addAttribute("password", user.getPassword());

//        userService.saveUser(user);
//        return "redirect:/info";
//    }
//
}
