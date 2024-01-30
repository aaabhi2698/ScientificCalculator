package Scientificcalculatortest;

import Scincecalculator.Scientificcalculatorsorce;
import org.testng.annotations.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class ScientificCalculatorTest {
    @BeforeMethod
    public void Load(){
        System.out.println("Test Execution Start.. ");
    }
    @AfterMethod
    public void close(){
        System.out.println(" Test Execution Ends..");
    }

    @Test(dataProvider = "csvTestData", groups = "Basicoperations")
    public void testAddition(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Addition(num1, num2), num1+num2);
    }
    @Test
    public void NegitivetestAddition() {
        assertEquals(Scientificcalculatorsorce.Addition('1', 5), 0.0);
    }

    @Test(dataProvider = "csvTestData", groups = "Basicoperations")
    public void testSubtraction(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Subtraction(num1,num2), num1-num2);
    }

    @Test(dataProvider = "csvTestData", groups = "Basicoperations")
    public void testMultiplication(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Multiplication(num1, num2),num1*num2 );
    }

    @Test(dataProvider = "csvTestData", groups = "Basicoperations")
    public void testDivision(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Division(num1, num2), Scientificcalculatorsorce.divcheck(num1, num2));
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
        assertEquals(Scientificcalculatorsorce.SquareRoot(num), Math.sqrt(num));
        //assertEquals(Scientificcalculatorsorce.SquareRoot(-1),0);
    }

    @Test(dataProvider = "csvTestData", groups = "Advanceoperations")
    public void testPower(double num1, double num2) {
        assertEquals(Scientificcalculatorsorce.Power(num1,num2),Math.pow(num1, num2));
        //assertEquals(9, ScientificCalculator.power(3, 2), 0.001);
    }
    @Test(dataProvider = "csvTestData3", groups = "Advanceoperations")
    public void TestSin(double degree){
        assertEquals(Scientificcalculatorsorce.sinFunction(degree),Math.sin(Math.toRadians(degree)));
    }
    @Test(dataProvider = "csvTestData3", groups = "Advanceoperations")
    public void TestCos(double degree){
        assertEquals(Scientificcalculatorsorce.cosFunction(degree),Math.cos(Math.toRadians(degree)));
    }
    @Test(dataProvider = "csvTestData3", groups = "Advanceoperations")
    public void TestTan(double degree){
        assertEquals(Scientificcalculatorsorce.tanFunction(degree),Scientificcalculatorsorce.tancheck(degree));
    }
    // Method to collect data from CSV
    @DataProvider(name = "csvTestData")
    public Object[][] csvTestDataDataProvider1() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            double number1 = Double.parseDouble(values[0]);
            double number2 = Double.parseDouble(values[1]);
            testData.add(new Object[]{number1, number2});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
    @DataProvider(name = "csvTestData2")
    public Object[][] csvTestDataDataProvider2() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData2.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String value= line;
            double num = Double.parseDouble(value);
            testData.add(new Object[]{num});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
    @DataProvider(name = "csvTestData3")
    public Object[][] csvTestDataDataProvider3() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("TestData3.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String value= line;
            double degree = Double.parseDouble(value);
            testData.add(new Object[]{degree});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
}