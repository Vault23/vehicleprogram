package formulas;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaForBmw extends JFrame implements IFrame, IFormula {

    private final String formulaText = "f(x) = x*x + y/2";
    private String name;
    private JPanel centralPanel = new JPanel();
    private JPanel variablesPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    JTextField textField = new JTextField();
    JTextField xField;
    JTextField yField;
    float result;
    float x, y = 0;

    public FormulaForBmw(String name) {
        this.name = name;
        setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Формула для " + this.name);
        setBounds(dimension.width / 2, dimension.height / 2, 800, 400);
        JButton button = new JButton("Рассчитать");
        button.addActionListener((e) -> calculate());
        JLabel label = new JLabel("Формула: " + formulaText);
        label.setLayout(new GridLayout(1, 1));
        JLabel label2 = new JLabel("Введите x:");
        label2.setLayout(new GridLayout(2, 1));
        xField = new JTextField(5);
        setField(xField);
        JLabel label3 = new JLabel("Введите y:");
        label3.setLayout(new GridLayout(3, 1));
        yField = new JTextField(5);
        setField(yField);
        textField.setName("Ввод формул");
        centralPanel.setLayout(new BorderLayout());
        addOnPanel(label,label2,label3,button);
        add(centralPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.EAST);
        add(variablesPanel, BorderLayout.WEST);
        variablesPanel.revalidate();
        buttonPanel.revalidate();
    }


    private void setField(JTextField field) {
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }


    private void addOnPanel(JLabel label, JLabel label2, JLabel label3, JButton button) {
        centralPanel.add(label);
        variablesPanel.add(label2);
        variablesPanel.add(xField);
        variablesPanel.add(label3);
        variablesPanel.add(yField);
        buttonPanel.add(button);
    }

    @Override
    public void calculate() {
        if (xField.getText().equals("")) {
            x = 0;
        } else if (yField.getText().equals("")) {
            y = 0;
        } else {
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
        }
        result = x * x + y / 2;
        JOptionPane.showMessageDialog(null,
                result,
                "Результат расчета: " + formulaText,
                JOptionPane.PLAIN_MESSAGE);
    }
}
