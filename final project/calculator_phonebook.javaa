import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private String num1 = "", num2 = "", operator = "";
    private boolean newCalculation = true;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setBackground(new Color(230, 230, 250));
        display.setForeground(Color.BLACK);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        buttonPanel.setBackground(new Color(216, 191, 216));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(new Color(221, 160, 221));
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            if (newCalculation) {
                display.setText("");
                newCalculation = false;
            }
            display.setText(display.getText() + command);
        } else if ("/*-+".contains(command)) {
            if (!display.getText().isEmpty()) {
                num1 = display.getText(); 
                operator = command;       
                display.setText("");      
                newCalculation = false;
            }
        } else if ("=".equals(command)) {
            if (!display.getText().isEmpty() && !num1.isEmpty() && !operator.isEmpty()) {
                num2 = display.getText(); 
                try {
                    double result = calculate(Double.parseDouble(num1), Double.parseDouble(num2), operator);
                    display.setText(formatResult(result));
                    saveToHistory(num1, operator, num2, result); 
                    newCalculation = true; 
                    num1 = String.valueOf(result); 
                    num2 = "";
                    operator = "";
                } catch (Exception ex) {
                    display.setText("Error");
                    newCalculation = true;
                }
            }
        } else if ("C".equals(command)) {
            display.setText("");  
            num1 = num2 = operator = ""; 
            newCalculation = true;
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    display.setText("Cannot divide by zero");
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private String formatResult(double result) {
        // Check if the result is a whole number
        if (result == (int) result) {
            return String.valueOf((int) result); // Display as an integer
        }
        return String.valueOf(result); // Display as a decimal if not a whole number
    }

    private void saveToHistory(String num1, String operator, String num2, double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("calculator_history.txt", true))) {
            writer.write(num1 + " " + operator + " " + num2 + " = " + formatResult(result) + "\n");
        } catch (IOException e) {
            System.out.println("Error saving history: " + e.getMessage());
            display.setText("History save error");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
