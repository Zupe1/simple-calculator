import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    public static void main(String[] args) {
        new Calculator();
    }

    // Output Label
    JLabel outputLabel;

    double currentResult;
    private String currentOperator;
    private boolean newOperation;

    public Calculator() {
        // Initialize variables
        currentResult = 0;
        currentOperator = "";
        newOperation = true;

        // Initialize swing interface
        initializeInterface();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        String numberString = "0123456789";
        if (numberString.contains(buttonText)) {
            handleNumberInput(buttonText);
            return;
        }

        handleOperatorInput(buttonText);
    }

    private void handleNumberInput(String number) {
        if (newOperation) {
            outputLabel.setText(number);
            newOperation = false;
            return;
        }

        outputLabel.setText(outputLabel.getText() + number);
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
        double inputVal = Double.parseDouble(outputLabel.getText());

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
                    outputLabel.setText("ERR");
                    return;
                }

                currentResult /= inputVal;
                break;
        }

        outputLabel.setText(String.valueOf(currentResult));
    }

    private void reset() {
        currentResult = 0;
        currentOperator = "";
        outputLabel.setText("0");
        newOperation = true;
    }

    private void initializeInterface() {
        // Frame
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setSize(400,450);

        // Font
        Font font = new Font("Dialogue", Font.PLAIN, 40);

        // Output Panel
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        outputPanel.setPreferredSize(new Dimension(400, 50));
        outputLabel = new JLabel("0");
        outputLabel.setFont(font);
        outputPanel.add(outputLabel);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonNames = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "C", "0", "/", "="
        };

        for (int i = 0; i < 16; i++) {
            // Instantiate button with name
            JButton button = new JButton(buttonNames[i]);
            button.setFont(font);
            button.addActionListener(this);

            // Add buttons to Panel
            buttonPanel.add(button);
        }

        // Add Panels to Frame and make visible
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().add(outputPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}