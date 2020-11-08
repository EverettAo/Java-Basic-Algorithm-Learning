package com.atguigu.mstack.StackCaculator;

public class CalculatorDemo {
    public static void main(String[] args) throws Exception {

        while (true) {
            String inpupt = Calculator.getInpupt();
            System.out.println(
                    Calculator.calculate(inpupt)
            );
        }

    }
}
