import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MContainer {
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    String vehicleType;
    Dimension dimension = toolkit.getScreenSize();
    JFrame jFrame;
    private JButton button = new JButton("Применить");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Выберите тип автомобиля:");
    private JPanel jPanel = new JPanel();
    String[] s1 = {"Volvo", "Bmw", "Skoda", "Toyota"};
    private JComboBox comboBox = new JComboBox(s1);

    public MContainer() {
        jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setTitle("Расчет формул");
        jFrame.setBounds(dimension.width / 2, dimension.height / 2, 800, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(e -> new Formula(vehicleType));
        comboBox.addItemListener(e -> vehicleType = (String) e.getItem());

        run();
    }

    private void run() {
        jFrame.add(jPanel);
        jPanel.add(label);
        jPanel.add(comboBox);
        jPanel.add(button);
        jPanel.revalidate();
    }


    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Text is " + input.getText() + "\n";

            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

}
