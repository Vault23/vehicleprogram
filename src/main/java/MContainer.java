import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class MContainer {
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    String vehicleType;
    Dimension dimension = toolkit.getScreenSize();
    JFrame jFrame;
    private JButton button = new JButton(new String("Применить".getBytes(),StandardCharsets.UTF_8));
    private JLabel label = new JLabel(new String("Выберите тип автомобиля:".getBytes(),StandardCharsets.UTF_8));
    private JPanel jPanel = new JPanel();
    String vehicle1 = new String("Седельный тягач T, C, K 4х2 или 4х4".getBytes(),StandardCharsets.UTF_8);
    String[] s1 = {vehicle1};
    private JComboBox comboBox = new JComboBox(s1);

    @SneakyThrows
    public MContainer() {
        jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setTitle(new String("Расчет формул".getBytes(), StandardCharsets.UTF_8));
        jFrame.setBounds(dimension.width / 2, dimension.height / 2, 800, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(e -> new Switcher(vehicleType));
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

}
