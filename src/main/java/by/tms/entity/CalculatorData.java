package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class CalculatorData {

    @NotEmpty(message = "num1 must not be empty")
    @PositiveOrZero
    private double num1;
    @NotEmpty(message = "num2 must not be empty")
    @PositiveOrZero
    private double num2;
    @NotBlank(message = "operation must not be empty")
    private String operation;
    private double result;

    public CalculatorData() {
    }

    public CalculatorData(double num1, double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}
