package TestClasses;

import Calculator.Calculator;
import junit.framework.Assert;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();


    @Test
    public void clear() {
        //calling clear (C) to make the textarea empty
        calculator.clear();
        String textAreaValue =calculator.getTextArea().getText().toString();
        // is it empty?
        Assert.assertTrue(textAreaValue.isEmpty());
    }

    @Test
    public void findSquareRoot() {
        JTextArea textArea = calculator.getTextArea();
        double number = 100;
        textArea.setText(number+"");
        calculator.findSquareRoot();
        String textAreaValue =calculator.getTextArea().getText().toString();
        double actualSquareRootValue = Math.sqrt(number);
        Assert.assertEquals(textAreaValue,actualSquareRootValue+"");
    }

    @Test
    public void findPositiveNegative() {
        JTextArea textArea = calculator.getTextArea();
        double number = 12;
        textArea.setText(number+"");
        calculator.findPositiveNegative();
        String textAreaValue =calculator.getTextArea().getText().toString();
        double actualValue = number *(-1);
        Assert.assertEquals(textAreaValue,actualValue+"");
    }

    @Test
    public void sub() {
        // for subtraction:
        // specify two numbers you want to subtract:
        double[] temporaryValues = new double[2];
        //first num:
        double firstNum = 10;
        temporaryValues[0] = firstNum;
        //second num:
        double secondNum = 5;
        temporaryValues[1] = secondNum;
        calculator.setTemporaryValues(temporaryValues);
        boolean[] functions = new boolean[4];
        functions[1] = true;
        calculator.setFunctions(functions);
        calculator.findResult();
        String textAreaValue =calculator.getTextArea().getText().toString();
        double actualResult = firstNum-secondNum;
        Assert.assertEquals(textAreaValue,actualResult +"");
    }

    @Test
    public void multiply(){
        // for multiplication:
        // specify two numbers you want to multiply:
        double[] temporaryValues = new double[2];
        //first num:
        double firstNum = 10;
        temporaryValues[0] = firstNum;
        //second num:
        double secondNum = 5;
        temporaryValues[1] = secondNum;
        calculator.setTemporaryValues(temporaryValues);
        boolean[] functions = new boolean[4];
        functions[2] = true;
        calculator.setFunctions(functions);
        calculator.findResult();
        String textAreaValue =calculator.getTextArea().getText().toString();
        double actualResult = firstNum*secondNum;
        Assert.assertEquals(textAreaValue,actualResult +"");
    }

    @Test
    public void add(){
        // for addition:
        // specify two numbers you want to add:
        double[] temporaryValues = new double[2];
        //first num:
        double firstNum = 10;
        temporaryValues[0] = firstNum;
        //second num:
        double secondNum = 5;
        temporaryValues[1] = secondNum;
        calculator.setTemporaryValues(temporaryValues);
        boolean[] functions = new boolean[4];
        functions[0] = true;
        calculator.setFunctions(functions);
        calculator.findResult();
        String textAreaValue =calculator.getTextArea().getText().toString();
        double actualResult = firstNum + secondNum;
        Assert.assertEquals(textAreaValue,actualResult +"");
    }


    @Test
    public void division(){
        // for division:
        // specify two numbers you want to divide:
        double[] temporaryValues = new double[2];
        //first num:
        double firstNum = 10;
        temporaryValues[0] = firstNum;
        //second num:
        double secondNum = 5;
        temporaryValues[1] = secondNum;
        calculator.setTemporaryValues(temporaryValues);
        boolean[] functions = new boolean[4];
        functions[3] = true;
        calculator.setFunctions(functions);
        calculator.findResult();
        String textAreaValue =calculator.getTextArea().getText().toString();
        double actualResult = firstNum / secondNum;
        Assert.assertEquals(textAreaValue,actualResult +"");
    }






}