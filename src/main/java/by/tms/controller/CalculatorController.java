package by.tms.controller;

import by.tms.entity.CalculatorData;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/calc") //localhost:8080/calc
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @Autowired
    UserService userService;

    @GetMapping("/reg") //localhost:8080/calc/reg
    public String user(@ModelAttribute("user") User user) {
        return "reg";
    }

    @PostMapping("/reg")
    public String user(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        userService.saveUser(user);
        return "redirect:/calc/logIn";
    }

    @GetMapping("/logIn") //localhost:8080/calc/logIn
    public String existUser(@ModelAttribute("currentUser") User user, BindingResult bindingResult) {
        return "logIn";
    }

    @PostMapping("/logIn") //localhost:8080/calc/logIn
    public String existUser(@ModelAttribute("currentUser") User user, HttpSession httpSession) {
        User currentUser = userService.findUser(user);
        if (currentUser != null && currentUser.getName().equals(user.getName()) &&
                currentUser.getSurname().equals(user.getSurname()) &&
                currentUser.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("user", user);
            return "redirect:/calc/operation";
        } else {
            throw new RuntimeException("such user doesn't exist");
        }
    }

    @GetMapping("/operation") //localhost:8080/calc/operation
    public String calculator(@ModelAttribute("operation") CalculatorData calculatorData) {
        return "operation";
    }

    @PostMapping("/operation") //localhost:8080/calc/operation
    public String calculator(@Valid @ModelAttribute("operation") CalculatorData calculatorData,
                             BindingResult bindingResult,
                             HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Incorrect data");
        }
        User user = (User) httpSession.getAttribute("user");
        User user1 = userService.findUser(user);
        calculatorService.calculate(calculatorData);
        userService.addOperationHistory(user1, calculatorData);
        return "redirect:/calc/info";
    }

    @RequestMapping("info") //localhost:8080/calc/info
    public String userInfo(Model model, HttpSession httpSession) {
        User user2 = (User) httpSession.getAttribute("user");
        User user1 = userService.findUser(user2);
        model.addAttribute("userOperationHistory", user1);
        return "info";
    }
}