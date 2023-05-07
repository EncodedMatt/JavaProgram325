import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GUI {
    JFrame frame = new JFrame();
    String[] shapeArr = {"Side of a Square", "Radius of a Circle"};
    JComboBox<String> shapes = new JComboBox<>(shapeArr);
    JTextField tf = new JTextField();

    JPanel pane = new JPanel(new GridBagLayout());
    JButton button = new JButton("Calculate");

    public GUI(){
        tf.setColumns(10);
        button.addActionListener(e->{
            Calculator calc = new Calculator();
            String text = tf.getText();
            try{
                //if combo box is square, calculate square
                if(Objects.equals(shapes.getSelectedItem(), "Side of a Square"))
                    JOptionPane.showMessageDialog(null, "The side of the square is: " + calc.calculateSquare(Double.parseDouble(text)), "Side of a Square", JOptionPane.INFORMATION_MESSAGE);
                //else if combox box is circle, calculate circle
                else if(Objects.equals(shapes.getSelectedItem(), "Radius of a Circle"))
                    JOptionPane.showMessageDialog(null, "The radius of a circle is: " + calc.calculateCircle(Double.parseDouble(text)), "Radius of a Circle", JOptionPane.INFORMATION_MESSAGE);
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Enter numbers only", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        pane.add(shapes,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        pane.add(tf,gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        pane.add(button,gbc);

        frame.add(pane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(400,100));
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }



}
