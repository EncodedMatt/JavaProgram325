import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GUI {
    JFrame frame = new JFrame();
    String[] shapeArr = {"Square", "Circle"};
    JComboBox<String> shapes = new JComboBox<>(shapeArr);
    JTextField tf = new JTextField();
    JLabel input = new JLabel();
    JLabel outputName = new JLabel("Result: ");
    JLabel outputValue = new JLabel("Dito lalabas yung sagot");
    JPanel pane = new JPanel();
    JButton button = new JButton("Calculate");

    public GUI(){
        tf.setColumns(10);
        button.addActionListener(e->{
            Calculator calc = new Calculator();
            String text = tf.getText();
            try{
                //if combo box is square, calculate square
                if(Objects.equals(shapes.getSelectedItem(), "Square"))
                    outputValue.setText(String.valueOf(calc.calculateSquare(Double.parseDouble(text)))); //change the text in outputValue label
                //else if combox box is circle, calculate circle
                else if(Objects.equals(shapes.getSelectedItem(), "Circle"))
                    outputValue.setText(String.valueOf(calc.calculateCircle(Double.parseDouble(text)))); //change the text in outputValue label
            }catch (NumberFormatException exception){
                outputValue.setText("Enter numbers only");
            }
        });

        pane.add(shapes);
        pane.add(input);
        pane.add(tf);
        pane.add(button);
        pane.add(outputName);
        pane.add(outputValue);

        frame.add(pane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }



}
