import javax.swing.*;

/**
 * Created by yinhao on 17/4/6.
 */
public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Jframe");
        JButton jButton = new JButton("My Button");

        jButton.addActionListener(e -> System.out.println("Button Pressed"));

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
