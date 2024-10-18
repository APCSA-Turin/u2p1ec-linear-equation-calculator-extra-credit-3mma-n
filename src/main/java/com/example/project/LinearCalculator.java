package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2)
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        int idx = coord1.indexOf(","); // finds the index of the comma in the coordinate pair
        x1 = Integer.parseInt(coord1.substring(1, idx)); // picks out characters between the open parenthesis and the comma
        y1 = Integer.parseInt(coord1.substring(idx + 1, coord1.length() - 1)); // picks out characters after the comma and before the closing parenthesis
        idx = coord2.indexOf(","); // process is repeated for coord2
        x2 = Integer.parseInt(coord2.substring(1, idx)); 
        y2 = Integer.parseInt(coord2.substring(idx + 1, coord2.length() - 1)); 
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total)
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newVal){x1 = newVal;}
    public void setY1(int newVal){y1 = newVal;}
    public void setX2(int newVal){x2 = newVal;}
    public void setY2(int newVal){y2 = newVal;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // calculates distance using distance formula
        return roundedToHundredth(dist);
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if ((x2 - x1) != 0) { // executes if slope is not undefined
            return roundedToHundredth(y1 - (x1 * slope())); // uses the first point and the slope to calculate y Intercept working backwards
        }
        return -999.99;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if ((x2 - x1) != 0) {
            return roundedToHundredth((double) (y2 - y1) / (x2 - x1)); // divides the y difference by the y difference (rise over run)
        }
        return -999.99;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        double slope = slope();
        double yInt = yInt(); 
        if (slope == -999.99) { // checks if slope is undefined (in which case it returns undefined immediately)
            return "undefined";
        }
        String str = "y="; // starts equation with y=
        if (slope != 0) {
            str += slope + "x"; // adds the slope and x if the slope isn't zero

            if (yInt > 0) {
                str += "+"; // adds a plus if the slope isn't zero and the yInt is > 0 (not < 0 because negatives already include a - sign)
            }
        }
        if (yInt != 0) {
            str += yInt; // adds the y-Int if it's not zero
        }
        return str; // returns the final equation
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        if (x > 0) { // checks if x is > or <= 0 to decide whether to add or subtract 0.5
            return (int) (x * 100 + 0.5) / 100.0; // uses multiplication, casting, & division to round to 2 ints
        }
        return (int) (x * 100 - 0.5) / 100.0;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")"; // ever line simply uses functions and values to append to the given strings
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        boolean xEqual = (x1 == x2); // checks if both x's are the same
        boolean yEqual = (y1 == y2); // checks if both y's are the same
        boolean xNeg = (x1 * -1 == x2); // checks if the x's are opposite
        boolean yNeg = (y1 * -1 == y2); // checks if the y's are opposite
        if (xNeg && yNeg) {
            return "Symmetric about the origin"; // only if both x's and both y's are opposite
        }
        if (xNeg && yEqual) {
            return "Symmetric about the y-axis"; // only if x's are opposite and y's are equal
        }
        if (xEqual && yNeg) {
            return "Symmetric about the x-axis"; // only if x's are equal and y's are opposite
        }
        return "No symmetry"; // all other cases
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double midX = (x1 + x2) / 2.0; // gets the average of both x's
        double midY = (y1 + y2) / 2.0; // gets the average of both y's
        return "The midpoint of this line is: (" + midX + "," + midY + ")"; // returns midpoint
    }

}



