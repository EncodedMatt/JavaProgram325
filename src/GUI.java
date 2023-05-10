import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class GUI {
    JFrame frame = new JFrame();
    String[] shapeArr = {"Area of a Square", "Area of a Circle"};
    JComboBox<String> shapes = new JComboBox<>(shapeArr);
    JTextField tf = new JTextField();
    JLabel label1 = new JLabel("Solve for: ");
    JLabel valueLabel = new JLabel("Enter side: ");
    JPanel pane = new JPanel(new GridBagLayout());
    JButton button = new JButton("Calculate");

    public GUI(){
        shapes.addActionListener(e->{
            //if combo box is square, calculate square
            if(Objects.equals(shapes.getSelectedItem(), "Area of a Square"))
                valueLabel.setText("Enter side: ");
                //else if combox box is circle, calculate circle
            else if(Objects.equals(shapes.getSelectedItem(), "Area of a Circle"))
                valueLabel.setText("Enter radius: ");
        });


        tf.setColumns(10);
        button.addActionListener(e->{
            Calculator calc = new Calculator();
            String text = tf.getText();
            try{
                //if combo box is square, calculate square
                if(Objects.equals(shapes.getSelectedItem(), "Area of a Square"))
                    JOptionPane.showMessageDialog(null, "The area of the square is: " + calc.calculateSquare(Double.parseDouble(text)), "Side of a Square", JOptionPane.INFORMATION_MESSAGE);
                //else if combox box is circle, calculate circle
                else if(Objects.equals(shapes.getSelectedItem(), "Area of a Circle"))
                    JOptionPane.showMessageDialog(null, "The area of the circle is: " + calc.calculateCircle(Double.parseDouble(text)), "Radius of a Circle", JOptionPane.INFORMATION_MESSAGE);
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Enter numbers only", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        pane.add(label1,gbc);
        pane.add(Box.createHorizontalStrut(5)); // Fixed width invisible separator.
        gbc.gridx=1;
        gbc.gridy=0;
        pane.add(shapes,gbc);
        pane.add(Box.createHorizontalStrut(5)); // Fixed width invisible separator.
        gbc.gridx=0;
        gbc.gridy=1;
        pane.add(valueLabel,gbc);
        pane.add(Box.createHorizontalStrut(5)); // Fixed width invisible separator.
        gbc.gridx=1;
        gbc.gridy=1;
        pane.add(tf,gbc);
        pane.add(Box.createHorizontalStrut(5)); // Fixed width invisible separator.
        gbc.gridx=0;
        gbc.gridy=2;
        pane.add(Box.createHorizontalStrut(5)); // Fixed width invisible separator.
        pane.add(button,gbc);


        frame.add(pane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(400,150));
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }
}


