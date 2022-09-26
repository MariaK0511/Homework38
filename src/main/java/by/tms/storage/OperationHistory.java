package by.tms.storage;


import by.tms.entity.CalculatorData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationHistory {
    private static final List<CalculatorData> CALCULATOR_DATA = new ArrayList<>();

    public void save(CalculatorData calculatorData) {
        CALCULATOR_DATA.add(calculatorData);
    }
}