package by.tms.storage;

import by.tms.entity.CalculatorData;
import by.tms.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataStorage {

    Map<User, ArrayList<OperationHistory>> info = new HashMap<>();

}