package Scientificcalculatortest;

import Scincecalculator.Scientificcalculatorsorce;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class ScientificCalculatorTest {
    @Test(dataProvider = "csvTestData", groups = "Basicoparetions")
    public void testAddition(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Addition(num1, num2), num1+num2);
    }
    @Test()
    public void NegitivetestAddition() {
        assertEquals(Scientificcalculatorsorce.Addition('c', 5), 0.0);
    }

    @Test(dataProvider = "csvTestData", groups = "Basicoparetions")
    public void testSubtraction(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Subtraction(num1,num2), num1-num2);
    }

    @Test(dataProvider = "csvTestData", groups = "Basicoparetions")
    public void testMultiplication(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Multiplication(num1, num2),num1*num2 );
    }

    @Test(dataProvider = "csvTestData", groups = "Basicoparetions")
    public void testDivision(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Division(num1, num2), num1/num2);
       // assertThrows(ArithmeticException.class, () -> Scientificcalculatorsorce.Division(5,0));

    }
    @Test
    public  void negitivetestdivision(){
        assertEquals(Scientificcalculatorsorce.Division(8,0),0);
    }

    @Test(dataProvider = "csvTestData2", groups = "Advanceoperations")
    public void testSquareRoot(Double num) {
        /*assertEquals(4, ScientificCalculator.squareRoot(16), 0.001);
        assertThrows(IllegalArgumentException.class, () -> ScientificCalculator.squareRoot(-9));
         */
        assertEquals(Scientificcalculatorsorce.SquareRoot(16),4);
        assertEquals(Scientificcalculatorsorce.SquareRoot(-1),0);
    }

    @Test(dataProvider = "csvTestData", groups = "Advanceoperations")
    public void testPower(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Power(num1,num2),Math.pow(num1, num2));
        //assertEquals(9, ScientificCalculator.power(3, 2), 0.001);
    }
    @Test(dataProvider = "csvTestData2", groups = "Advanceoperations")
    public void TestSin(double num){
        assertEquals(Scientificcalculatorsorce.sinFunction(30),0.5 );
    }
    @Test(dataProvider = "csvTestData2", groups = "Advanceoperations")
    public void TesCos(double num){
        assertEquals(Scientificcalculatorsorce.cosFunction(60),0.00872653549);
    }
    @Test
    public void TestTan(double num){
        assertEquals(Scientificcalculatorsorce.tanFunction(90),0.57735026919);
    }
    // Method to collect data from CSV
    @DataProvider(name = "csvTestData")
    public Object[][] csvTestDataDataProvider1() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            double num1 = Double.parseDouble(values[0]);
            double num2 = Double.parseDouble(values[1]);
            testData.add(new Object[]{num1, num2});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
    @DataProvider(name = "csvTestData2")
    public Object[][] csvTestDataDataProvider2() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("testData2.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
           // String[] values = line.split(",");
            String value= line;
            double num = Double.parseDouble(value);
           // double num2 = Double.parseDouble(values[1]);
            //testData.add(new Object[]{num1, num2});
            testData.add(new Object[]{num});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
}
