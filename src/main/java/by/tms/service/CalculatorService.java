package by.tms.service;

import by.tms.entity.CalculatorData;
import by.tms.storage.OperationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    @Autowired
    OperationHistory operationHistory;

    public double calculate(CalculatorData calculatorData) {
        double result = 0;
        switch (calculatorData.getOperation()) {
            case "sum":
                result = calculatorData.getNum1() + calculatorData.getNum2();
                break;
            case "sub":
                result = calculatorData.getNum1() - calculatorData.getNum2();
                break;
            case "mul":
                result = calculatorData.getNum1() * calculatorData.getNum2();
                break;
            case "div":
                result = calculatorData.getNum1() / calculatorData.getNum2();
                break;
        }
        operationHistory.save(calculatorData);
        return result;

    }
}