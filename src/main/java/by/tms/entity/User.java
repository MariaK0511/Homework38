package by.tms.entity;

import by.tms.storage.OperationHistory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class User {

    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank(message = "Surname must not be empty")
    @Size(min = 2,max = 20)
    private String surname;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 3, max = 20)
    private String password;
    private final List<CalculatorData> calculatorData = new ArrayList<>();

    public User() {
    }

    public User(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CalculatorData> getCalculatorData() {
        return calculatorData;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", calculatorData=" + calculatorData +
                '}';
    }
}
