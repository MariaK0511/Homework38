package by.tms.storage;

import by.tms.entity.CalculatorData;
import by.tms.entity.User;

import java.util.HashMap;

public class DataStorage {
    HashMap<User, CalculatorData> userAndHisOperations = new HashMap<>();
}