package task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    Score(int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon image = new ImageIcon(getClass().getResource("/task4/score.png"));
        Image i = image.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(i);
        JLabel label = new JLabel(i1);
        label.setBounds(0, 200, 300, 250);
        add(label);
        JLabel heading = new JLabel("Thank You For Playing");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        add(heading);
        JLabel score1 = new JLabel("Your Score is " + score);
        score1.setBounds(350, 200, 300, 30);
        score1.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        add(score1);
        setVisible(true);
        JButton play = new JButton("Play Again");
        play.setBounds(380, 270, 120, 30);
        play.setBackground(Color.WHITE);
        play.addActionListener(this);
        add(play);
        play.setEnabled(true);
    }

    public static void main(String[] args) {
        new Score(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Quiz().setVisible(true);
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
