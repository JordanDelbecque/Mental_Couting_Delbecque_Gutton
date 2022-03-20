package com.example.mentalcounting.services;

import com.example.mentalcounting.models.OperationModel;
import com.example.mentalcounting.models.exceptions.OperatorException;

public class VerifyUserResultService {

    public boolean testComputeValue(OperationModel operationModel, int userValue) throws OperatorException {
        int computeValue = computeResult(operationModel);

        return computeValue == userValue;
    }

    public int computeResult(OperationModel operationModel) throws OperatorException {
        int firstCoefficient, secondCoefficient = 0;
        int result = 0;

        String operator = operationModel.getOperator();

        firstCoefficient = operationModel.getFirstCoefficient();
        secondCoefficient = operationModel.getSecondCoefficient();


        switch (operator) {
            case "+":
                result = firstCoefficient + secondCoefficient;
                break;
            case "-":
                result = firstCoefficient - secondCoefficient;
                break;
            case "*":
                result = firstCoefficient * secondCoefficient;
                break;
            default:
                throw new OperatorException("Invalid operator");
        }

        return result;
    }
}
