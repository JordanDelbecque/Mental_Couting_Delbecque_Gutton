package com.example.mentalcounting.services;

import com.example.mentalcounting.models.OperationModel;

import java.util.Random;

public class OperationService {

    public OperationModel generateRandomOperation() {
        return new OperationModel(generateValue(),generateValue(), generateOperator());
    }

    private int generateValue(){
        int maxValue = 100;

        return new Random().nextInt(maxValue);
    }

    private String generateOperator(){
        String[] operators = {"+","-","*","/"};

        return operators[new Random().nextInt(operators.length)];
    }
}