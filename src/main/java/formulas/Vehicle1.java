package formulas;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Vehicle1 extends JFrame implements IFormula, IFrame {
    private JPanel panel1;
    private JLabel imageLabel;
    private JLabel formula1;
    private JLabel descriptionLabel;
    private JComboBox wbBox;
    private JLabel wbBoxDescription;
    private JLabel fwpBoxDescription;
    private JComboBox fwpBox;
    private JLabel m1Description;
    private JTextField m1Field;
    private JLabel m2Description;
    private JTextField m2Field;
    private JLabel m5Description;
    private JTextField m5Field;
    private JLabel resultsLabel;
    private JLabel result1;
    private JLabel result2;
    private JButton calculateButton;
    BufferedImage image;
    Image dimg;
    int m1, m5, fwp, wb, m2 = 0;
    int resultFormula1, resultFormula2;

    public Vehicle1(String name) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(dimension.width / 2, dimension.height / 2, 680, 600);
        setTitle(new String(("Расчет формул для " + name).getBytes(), StandardCharsets.UTF_8));
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("Vehicle1.JPG");
            image = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimg = image.getScaledInstance(image.getWidth() * 2 / 3, image.getHeight() * 2 / 3,
                Image.SCALE_SMOOTH);
        $$$setupUI$$$();
        add(panel1);
        fwpBox.addItemListener(e -> fwp = Integer.parseInt(String.valueOf(e.getItem())));
        wbBox.addItemListener(e -> wb = Integer.parseInt(String.valueOf(e.getItem())));
        calculateButton.addActionListener(e -> {
            calculate();
            result1.setText(String.valueOf(resultFormula1));
            result2.setText(String.valueOf(resultFormula2));
        });
    }


    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(11, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setAlignmentX(1.0f);
        panel1.setAlignmentY(1.0f);
        panel1.setAutoscrolls(false);
        panel1.setBackground(new Color(-1));
        descriptionLabel = new JLabel();
        descriptionLabel.setText(new String("Введите входные данные:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(descriptionLabel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(170, 16), null, 0, false));
        wbBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("0");
        defaultComboBoxModel1.addElement("3500");
        defaultComboBoxModel1.addElement("3600");
        defaultComboBoxModel1.addElement("3700");
        defaultComboBoxModel1.addElement("3800");
        defaultComboBoxModel1.addElement("3900");
        wbBox.setModel(defaultComboBoxModel1);
        panel1.add(wbBox, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(170, 30), null, 0, false));
        wbBoxDescription = new JLabel();
        wbBoxDescription.setText(new String("Колесная база, мм – WB:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(wbBoxDescription, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fwpBoxDescription = new JLabel();
        fwpBoxDescription.setText(new String("Позиция ССУ, мм – FWP:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(fwpBoxDescription, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        formula1 = new JLabel();
        formula1.setAlignmentX(1.0f);
        formula1.setAlignmentY(1.0f);
        formula1.setText(new String("Нагрузка от полной массы на переднюю ось, кг – M1’:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(formula1, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fwpBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("0");
        defaultComboBoxModel2.addElement("600");
        defaultComboBoxModel2.addElement("625");
        defaultComboBoxModel2.addElement("650");
        defaultComboBoxModel2.addElement("675");
        defaultComboBoxModel2.addElement("700");
        fwpBox.setModel(defaultComboBoxModel2);
        panel1.add(fwpBox, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(170, 30), null, 0, false));
        m1Field = new JTextField();
        m1Field.setAutoscrolls(true);
        m1Field.setText("");
        panel1.add(m1Field, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(170, 30), null, 0, false));
        m1Description = new JLabel();
        m1Description.setText(new String("Нагрузка на переднюю ось от снаряженной массы, кг – M1:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(m1Description, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        m2Field = new JTextField();
        panel1.add(m2Field, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(170, 30), null, 0, false));
        m2Description = new JLabel();
        m2Description.setText(new String("Нагрузка на ведущую ось от снаряженной массы, кг – M2:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(m2Description, new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        m5Field = new JTextField();
        panel1.add(m5Field, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(170, 30), null, 0, false));
        m5Description = new JLabel();
        m5Description.setText(new String("Нагрузка на ССУ, кг – M5:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(m5Description, new GridConstraints(6, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        resultsLabel = new JLabel();
        Font resultsLabelFont = this.$$$getFont$$$(null, Font.BOLD, -1, resultsLabel.getFont());
        if (resultsLabelFont != null) resultsLabel.setFont(resultsLabelFont);
        resultsLabel.setText(new String("Результаты:".getBytes(), StandardCharsets.UTF_8));
        panel1.add(resultsLabel, new GridConstraints(7, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.BOLD, -1, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText(new String("М1 + |М5 · FWP ÷ WB|".getBytes(), StandardCharsets.UTF_8));
        panel1.add(label1, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        result1 = new JLabel();
        Font result1Font = this.$$$getFont$$$("Consolas", Font.BOLD, -1, result1.getFont());
        if (result1Font != null) result1.setFont(result1Font);
        result1.setText("");
        panel1.add(result1, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText(new String("Нагрузка от полной массы на заднюю ось, кг – M2’: ".getBytes(), StandardCharsets.UTF_8));
        panel1.add(label2, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, Font.BOLD, -1, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText(new String("M2 + |M5 · FWP ÷ WB – M5|".getBytes(), StandardCharsets.UTF_8));
        panel1.add(label3, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        result2 = new JLabel();
        Font result2Font = this.$$$getFont$$$("Consolas", Font.BOLD, -1, result2.getFont());
        if (result2Font != null) result2.setFont(result2Font);
        result2.setText("");
        panel1.add(result2, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        imageLabel = new JLabel();
        imageLabel.setAlignmentX(0.0f);
        imageLabel.setAutoscrolls(false);
        imageLabel.setIcon(new ImageIcon(dimg));
        imageLabel.setText("");
        imageLabel.setVisible(true);
        panel1.add(imageLabel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        calculateButton = new JButton();
        calculateButton.setAlignmentX(0.0f);
        calculateButton.setMargin(new Insets(0, 0, 0, 0));
        calculateButton.setSelected(false);
        calculateButton.setText(new String("Рассчитать".getBytes(), StandardCharsets.UTF_8));
        panel1.add(calculateButton, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }


    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }


    @Override
    public void calculate() {
        if (m1Field.getText().equals("")) {
            m1 = 0;
        } else if (m5Field.getText().equals("")) {
            m5 = 0;
        } else if (m2Field.getText().equals("")) {
            m2 = 0;
        } else {
            m1 = Integer.parseInt(m1Field.getText());
            m2 = Integer.parseInt(m2Field.getText());
            m5 = Integer.parseInt(m5Field.getText());
        }
        try {
            resultFormula1 = m1 + Math.abs(m5 * fwp / wb);
            resultFormula2 = m2 + Math.abs(m5 * fwp / wb - m5);
        } catch (ArithmeticException e) {
            log.error("Ошибка при делении на ноль");
        }
    }
}
