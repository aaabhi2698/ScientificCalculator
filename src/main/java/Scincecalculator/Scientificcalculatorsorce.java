package Scincecalculator;


public class Scientificcalculatorsorce {

     public static double Addition(Object num1, Object num2) {
         try {
             if (num1 instanceof Number && num2 instanceof Number) {
                 double operand1 = ((Number) num1).doubleValue();
                 double operand2 = ((Number) num2).doubleValue();
                 return operand1 + operand2;
             } else {
                 System.out.println("Invalid input.. Both inputs must be numeric.");
             }
         } catch (Exception e) {
             System.out.println("Exception occurred: " + e.getMessage());
         }
         return 0.0; // Return a default value or handle it as needed.
     }


     public static double Subtraction(double num1, double num2) {

        return num1 - num2;
    }

     public static double Multiplication(double num1, double num2) {

        return num1 * num2;
    }

     public static double Division(double dividend, double divisor) {


            try {
                if(divisor<=0){
                    throw new ArithmeticException();
                }
                return dividend / divisor;
            }catch(ArithmeticException e){
                System.out.println("Cannot divide by zero. Please enter a non-zero divisor.");
                return 0;
            }

    }

     public static double SquareRoot(double num) {
             try {
                 if (num <= 0) {
                     throw  new Exception();
                 }
                 return Math.sqrt(num);
             }catch(Exception e){
                 System.out.println("Cannot calculate square root of a negative number.");
                 return 0;
        }

    }

     public static double Power(double base,double exponent) {

        return Math.pow(base, exponent);
    }

     public static double sinFunction(double angleInDegrees) {
        return Math.sin(Math.toRadians(angleInDegrees));
    }

     public static double cosFunction(double angleInDegrees) {
        return Math.cos(Math.toRadians(angleInDegrees));
    }

     public static double tanFunction(double angleInDegrees) {
       try {
           if (Math.abs(Math.cos(Math.toRadians(angleInDegrees))) < 1e-9) {
               throw new ArithmeticException();
           }
           return Math.tan(Math.toRadians(angleInDegrees));
       }catch(ArithmeticException e){
           System.out.println("Tangent is undefined for this angle");
           return 0;
       }
    }
    public static double divcheck(double num1,double num2){
         if(num2==0.0){
             return 0.0;
         }
         return num1/num2;
    }
    public static double tancheck(double angleInDegrees){
        if(angleInDegrees==90){
            return 0.0;
        }

        return Math.tan(Math.toRadians(angleInDegrees));
    }
}
