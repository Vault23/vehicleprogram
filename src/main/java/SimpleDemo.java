import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static formulas.IFrame.dimension;

public class SimpleDemo {

    public static void main(String[] args) {
        new SimpleDemo();
    }

    public SimpleDemo() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final CardLayout cardLayout = new CardLayout();
                final JFrame frame = new JFrame("Testing");
                frame.setBounds(dimension.width / 2, dimension.height / 2, 800, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(cardLayout);

                JPanel startPanel = new JPanel(new GridBagLayout());
                JButton startButton = new JButton("Start");
                startPanel.add(startButton);
                startButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(frame.getContentPane(), "game");
                    }
                });

                JLabel game = new JLabel("Game On", JLabel.CENTER);

                frame.add(startPanel, "start");
                frame.add(game, "game");

                cardLayout.show(frame.getContentPane(), "start");

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
