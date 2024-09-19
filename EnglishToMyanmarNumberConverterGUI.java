
import javax.swing.*;

public class EnglishToMyanmarNumberConverterGUI {

    // Method to convert English number to Myanmar number
    public static String convertToMyanmarNumber(int number) {
        String[] myanmarNumerals = {"\u1040", "\u1041", "\u1042", "\u1043", "\u1044", "\u1045", "\u1046", "\u1047", "\u1048", "\u1049"};
        String englishNumber = String.valueOf(number);
        StringBuilder myanmarNumber = new StringBuilder();
        for (int i = 0; i < englishNumber.length(); i++) {
            char digit = englishNumber.charAt(i);
            int digitValue = Character.getNumericValue(digit);
            myanmarNumber.append(myanmarNumerals[digitValue]);
        }

        // If the number is a multiple of 100, append "kyat" in Myanmar font
        if (number % 100 == 0 && number != 0) {
            myanmarNumber.append("\u1000\u103b\u1015\u103a"); // Adding "kyat" in Myanmar font
        }

        return myanmarNumber.toString();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("English to Myanmar Number Converter");
        JPanel panel = new JPanel();
        JLabel englishLabel = new JLabel("Enter an English number:");
        JTextField englishTextField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        JLabel myanmarLabel = new JLabel("Myanmar Number:");
        JLabel myanmarValueLabel = new JLabel();

        panel.add(englishLabel);
        panel.add(englishTextField);
        panel.add(convertButton);
        panel.add(myanmarLabel);
        panel.add(myanmarValueLabel);

        frame.add(panel);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        convertButton.addActionListener(e -> {
            String englishNumberString = englishTextField.getText();
            if (!englishNumberString.isEmpty()) {
                int englishNumber = Integer.parseInt(englishNumberString);
                String myanmarNumber = convertToMyanmarNumber(englishNumber);
                myanmarValueLabel.setText(myanmarNumber);
            }
        });
    }
}
