package com.example.project;

public class CalcRunner {
    public static void main(String[] args) {
        LinearCalculator c = new LinearCalculator("(3,4)","(3,-4)");
        String expectedOutput = "The two points are: (3,4)";
        expectedOutput += " and " + "(3,-4)";
        expectedOutput += "\nThe equation of the line between these points is: undefined";
        expectedOutput += "\nThe slope of this line is: -999.99";
        expectedOutput += "\nThe y-intercept of the line is: -999.99";
        expectedOutput += "\nThe distance between the two points is: 8.0";
        expectedOutput += "\nSymmetric about the x-axis";
        expectedOutput += "\nThe midpoint of this line is: (3.0,0.0)";

        String studentOutput = c.printInfo();


        System.out.println(expectedOutput);
        System.out.println("\n" + studentOutput);
        System.out.println(studentOutput.equals(expectedOutput));
    }
}