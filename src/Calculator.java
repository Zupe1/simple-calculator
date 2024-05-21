import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    public static void main(String[] args) {
        new Calculator();
    }

    CalculatorUI calculatorUI;

    double currentResult;
    private String currentOperator;
    private boolean newOperation;

    public Calculator() {
        // Initialize variables
        currentResult = 0;
        currentOperator = "";
        newOperation = true;

        calculatorUI = new CalculatorUI(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        if (isNumber(buttonText)) {
            handleNumberInput(buttonText);
        }
        else {
            handleOperatorInput(buttonText);
        }
    }

    private boolean isNumber(String buttonText) {
        return buttonText.matches("[0-9]");
    }

    private void handleNumberInput(String number) {
        if (newOperation) {
            calculatorUI.setOutputLabelText(number);
            newOperation = false;
            return;
        }

        calculatorUI.setOutputLabelText(calculatorUI.getOutputLabelText() + number);
    }

    private void handleOperatorInput(String operator) {
        if (operator.equals("C")) {
            reset();
            return;
        }

        if (operator.equals("=")) {
            calculate();
            currentOperator = "";
            newOperation = true;
            return;
        }

        calculate();
        currentOperator = operator;
        newOperation = true;

    }

    private void calculate() {
        if (calculatorUI.getOutputLabelText().equals("ERR")) {
            reset();
        }
        double inputVal = Double.parseDouble(calculatorUI.getOutputLabelText());

        switch (currentOperator) {
            case "":
                currentResult = inputVal;
                break;
            case "+":
                currentResult += inputVal;
                break;
            case "-":
                currentResult -= inputVal;
                break;
            case "*":
                currentResult *= inputVal;
                break;
            case "/":
                if (inputVal == 0.0) {
                    calculatorUI.setOutputLabelText("ERR");
                    return;
                }

                currentResult /= inputVal;
                break;
        }

        calculatorUI.setOutputLabelText(String.valueOf(currentResult));
    }

    private void reset() {
        currentResult = 0;
        currentOperator = "";
        calculatorUI.setOutputLabelText("0");
        newOperation = true;
    }
}