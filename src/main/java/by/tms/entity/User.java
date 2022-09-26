package by.tms.entity;

import by.tms.storage.OperationHistory;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String password;
    private final List<CalculatorData> calculatorData = new ArrayList<>();
    private final List<OperationHistory> operationHistories = new ArrayList<>();

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

    public List<OperationHistory> getOperationHistories(List<OperationHistory> operationHistories) {
        return this.operationHistories;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", calculatorData=" + calculatorData +
                ", operationHistories=" + operationHistories +
                '}';
    }
}
