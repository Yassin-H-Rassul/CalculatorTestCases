package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator extends JFrame implements ActionListener {

    private JPanel[] panels = new JPanel[5]; // we have 5 rows of components, one panel for each row.
    private JButton[] buttons = new JButton[19]; // we have 19 buttons on the calculator.
    private String[] buttonsText = {"7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3", "*", ".", "/", "C", "√", "+/-", "=", "0"}; // the text of buttons.
    private JTextArea textArea = new JTextArea(1, 30);
    private double[] temporaryValues = {0, 0}; // the two values that user enters to perform operations on them.
    private boolean[] functions = new boolean[4]; // to determine which function or operation is entered ( + , - , * , / ).

    public Calculator() {
        setTitle("Calculator");
        setSize(380, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int[] width = {300, 45, 100, 90}; // the width of all types of buttons in the calculator.
        int[] height = {35, 40}; // the height of all types of buttons in the calculator.
        Dimension textAreaDimension = new Dimension(width[0], height[0]); // the width and height of the text area in the calculator.
        Dimension regularButtonsDimension = new Dimension(width[1], height[1]); // the width and height of all regular buttons in the calculator.

        Dimension rightColumnButtonsDimension = new Dimension(width[2], height[1]); // the width and height of all buttons on rightmost column of the calculator.
        Dimension zeroButtonDimension = new Dimension(width[3], height[1]); // the width and height of zero button of the calculator.
        Arrays.fill(functions, false); // first we say no function or operation is entered
        textArea.setEditable(false);
        for (int i = 0; i < panels.length; i++) { // creating the panels.
            panels[i] = new JPanel();
        }

        for (int i = 0; i < buttons.length; i++) {
            // creating the buttons.
            buttons[i] = new JButton();
            buttons[i].setText(buttonsText[i]);
            buttons[i].addActionListener(this);
        }

        setLayout(new GridLayout(5, 5)); // changing the layout of the frame to grid layout, and making it 5 rows and 5 columns.
        panels[0].add(textArea);


        FlowLayout flowLayoutWithGaps = new FlowLayout(FlowLayout.CENTER, 1, 1);

        for (int i = 1; i < panels.length; i++) {
            panels[i].setLayout(flowLayoutWithGaps); // changing the layout of all panels except the first one (because it is a text area).
        }

// setting the sizes for all buttons in the calculator.
        textArea.setPreferredSize(textAreaDimension);
        for (int i = 0; i < 14; i++) {
            buttons[i].setPreferredSize(regularButtonsDimension);
        }
        for (int i = 14; i < 18; i++) {
            buttons[i].setPreferredSize(rightColumnButtonsDimension);
        }
        buttons[18].setPreferredSize(zeroButtonDimension);

// adding buttons to the panels.
        for (int i = 0; i < 4; i++) {
            panels[1].add(buttons[i]);
        }
        panels[1].add(buttons[14]);

        for (int i = 4; i < 8; i++) {
            panels[2].add(buttons[i]);
        }
        panels[2].add(buttons[15]);

        for (int i = 8; i < 12; i++) {
            panels[3].add(buttons[i]);
        }
        panels[3].add(buttons[16]);

        panels[4].add(buttons[18]);
        for (int i = 12; i < 14; i++) {
            panels[4].add(buttons[i]);
        }
        panels[4].add(buttons[17]);

// adding panels to the frame.
        add(panels[0]);
        add(panels[1]);
        add(panels[2]);
        add(panels[3]);
        add(panels[4]);
    }

    // clear method: clears the text from text area, and resets the temporary values and functions.
    public void clear() {
        textArea.setText("");
        for (int i = 0; i < 2; i++) {
            temporaryValues[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            functions[i] = false;
        }
    }

    // this method finds the square root of the entered number.
    public void findSquareRoot() {
        double number = Math.sqrt(Double.parseDouble(textArea.getText()));
        textArea.setText(Double.toString(number));
    }

    // this method finds the opposite sign of the entered number.
    public void findPositiveNegative() {
        double number = Double.parseDouble(textArea.getText());
        if (number != 0) {
            number = number * (-1);
            textArea.setText(Double.toString(number));
        }
    }

    // this method finds the result of the function specified by the user.
    public void findResult() {
        double result = 0;
        if(!textArea.getText().isEmpty()) {
            temporaryValues[1] = Double.parseDouble(textArea.getText()); // we have considered the first temporary value (temporaryValues[0]) in the actionPerformed method.
        }
// making two string to hold temporary values.
        String temp0 = Double.toString(temporaryValues[0]);
        String temp1 = Double.toString(temporaryValues[1]);

// when (-) is entered, check whether it is with the first number or second number.
        if (temp0.contains("-")) {
            String[] temp00 = temp0.split("-", 2);
            temporaryValues[0] = (Double.parseDouble(temp00[1]) * -1);
        }
        if (temp1.contains("-")) {
            String[] temp11 = temp1.split("-", 2);
            temporaryValues[1] = (Double.parseDouble(temp11[1]) * -1);
        }

// check which function is pressed, then perform.

        if (functions[0]) {
            result = add(); //add
        }

        if (functions[1]) {
            result = sub(); // sub
        }

        if (functions[2]) {
            result = multiply(); //multiply
        }

        if (functions[3]) {
            result = division(); //division
        }

        textArea.setText(Double.toString(result));
        Arrays.fill(functions, false); // reset the array of functions, so no functions is pressed.
        Arrays.fill(temporaryValues, 0); // reset the array of temporary values, so no value is saved.
    }

    public double add(){
        return temporaryValues[0] + temporaryValues[1];
    }

    public double sub(){
        return temporaryValues[0] - temporaryValues[1];
    }

    public double multiply(){
        return temporaryValues[0] * temporaryValues[1];
    }

    public double division(){
        return temporaryValues[0] / temporaryValues[1];
    }




    // this method takes care of which buttons is pressed, and performs its code.
    public void actionPerformed(ActionEvent event) {
//        System.out.println(event.getSource());
        Object source = event.getSource();
        if (source == buttons[0]) {
            textArea.append("7");
        }
        if (source == buttons[1]) {
            textArea.append("8");
        }
        if (source == buttons[2]) {
            textArea.append("9");
        }
        if (source == buttons[3]) { // addition button
            temporaryValues[0] = Double.parseDouble(textArea.getText());
            textArea.setText("");
            functions[0] = true;
        }
        if (source == buttons[4]) {
            textArea.append("4");
        }
        if (source == buttons[5]) {
            textArea.append("5");

        }
        if(source == buttons[6]){ textArea.append("6");
        }
        if(source == buttons[7]){// subtraction button
            temporaryValues[0] = Double.parseDouble(textArea.getText());
            textArea.setText("");
            functions[1] = true;
        }
        if(source == buttons[8]){ textArea.append("1");
        }
        if(source == buttons[9]){ textArea.append("2");
        }
        if(source == buttons[10]){ textArea.append("3");
        }
        if(source == buttons[11]){// multiplication button
            temporaryValues[0] = Double.parseDouble(textArea.getText());
            textArea.setText("");
            functions[2] = true;
        }
        if(source == buttons[12]){ textArea.append(".");
        }
        if(source == buttons[13]){ // division button
            temporaryValues[0] = Double.parseDouble(textArea.getText());
            textArea.setText("");
            functions[3] = true;
        }
        if(source == buttons[14]){ // clear button
            clear();
        }
        if(source == buttons[15]){ // square root button
            findSquareRoot();
        }
        if(source == buttons[16]){ // (+/-) button
            findPositiveNegative();
        }
        if(source == buttons[17]){ // when equal sign (=) is pressed.
            findResult();
        }
        if(source == buttons[18]){ textArea.append("0");
        }
    }

    public JPanel[] getPanels() {
        return panels;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public String[] getButtonsText() {
        return buttonsText;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public double[] getTemporaryValues() {
        return temporaryValues;
    }

    public boolean[] getFunctions() {
        return functions;
    }

    public void setPanels(JPanel[] panels) {
        this.panels = panels;
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    public void setButtonsText(String[] buttonsText) {
        this.buttonsText = buttonsText;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void setTemporaryValues(double[] temporaryValues) {
        this.temporaryValues = temporaryValues;
    }

    public void setFunctions(boolean[] functions) {
        this.functions = functions;
    }
}




