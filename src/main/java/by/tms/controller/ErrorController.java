package by.tms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler({Throwable.class, RuntimeException.class})
    public String error(Throwable e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}