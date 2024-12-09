package com.example.tests;

public class Calculator {

    public int integerAddition(int num1 , int num2){
        if(num1 < 0 || num2 <0){
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }

        return num1+num2;
    }

    public int integerSub(int higher , int lower){
        if (higher - lower <= 0) {
            throw new IllegalArgumentException("Result of subtraction cannot be  negative.");
        }

        if(higher < 0 || lower <0){
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }
        return higher - lower;
    }

    public int integerMultiplication(int num1 , int num2){
        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }

        if (num1 == 0 || num2 == 0) {
            throw new IllegalArgumentException("Number should not be a zero");
        }
        return num1*num2;
    }

    public int integerDivision(int dividend , int divisor ){

        if(divisor > dividend){
            throw new IllegalArgumentException("Result is less than 0");
        }

        return dividend / divisor;
    }


}