package task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String answers_given[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton option1, option2, option3, option4;
    public static int timer = 15;
    public static int given = 0;
    public static int count = 0;
    public static int score = 0;
    ButtonGroup options;
    JButton next, submit;

    Quiz() {
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon image = new ImageIcon(getClass().getResource("/task4/quiz.jpg"));
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, 1440, 390);
        add(label);
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(qno);
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(question);
        setVisible(true);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        option1 = new JRadioButton();
        option1.setBounds(170, 520, 700, 30);
        option1.setBackground(Color.WHITE);
        option1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option1);

        option2 = new JRadioButton();
        option2.setBounds(170, 550, 700, 30);
        option2.setBackground(Color.WHITE);
        option2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option2);

        option3 = new JRadioButton();
        option3.setBounds(170, 580, 700, 30);
        option3.setBackground(Color.WHITE);
        option3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option3);

        option4 = new JRadioButton();
        option4.setBounds(170, 610, 700, 30);
        option4.setBackground(Color.WHITE);
        option4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option4);
        options = new ButtonGroup();
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        next = new JButton("Next");
        next.setBounds(400, 650, 100, 30);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        next.addActionListener(this);
        add(next);
        submit = new JButton("Submit");
        submit.setBounds(1000, 650, 100, 30);
        submit.setBackground(Color.WHITE);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        add(submit);
        submit.setEnabled(false);
        start(count);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == next) {
            repaint();
            given = 1;
            if (options.getSelection() == null) {
                answers_given[count][0] = "";
            } else {
                answers_given[count][0] = options.getSelection().getActionCommand();
            }
            count++;
            start(count);
            if (count == 9) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
        } else if (a.getSource() == submit) {
            given = 1;
            if (options.getSelection() == null) {
                answers_given[count][0] = "";
            } else {
                answers_given[count][0] = options.getSelection().getActionCommand();
            }
            for (int i = 0; i < answers_given.length; i++) {
                if (answers[i][1].equals(answers_given[i][0])) {
                    score = score + 10;
                }
            }
            setVisible(false);
            new Score(score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left: " + timer + " seconds";
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        if (timer > 0) {
            g.drawString(time, 1100, 510);
        } else {
            g.drawString("Time Up", 1100, 510);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (given == 1) {
            given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            if (options.getSelection() == null) {
                answers_given[count][0] = "";
            } else {
                answers_given[count][0] = options.getSelection().getActionCommand();
            }
            count++;
            start(count);
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);
        options.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
