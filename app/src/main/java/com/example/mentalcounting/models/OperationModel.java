package com.example.mentalcounting.models;

public class OperationModel {

    private final int firstValue;
    private final int secondValue;
    private final String operator;


    public OperationModel(int first, int second, String operator){
        this.firstValue = first;
        this.secondValue = second;
        this.operator = operator;
    }

    public int getFirstCoefficient() {
        return firstValue;
    }

    public int getSecondCoefficient() {
        return secondValue;
    }

    public String getOperator() {
        return operator;
    }
}
