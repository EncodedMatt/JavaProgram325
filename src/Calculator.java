public class Calculator {

    public double calculateCircle(double radius){
        return Math.PI*Math.pow(radius,2);
    }

    public double calculateSquare(double side){
        return Math.pow(side,2);
    }

    public double calculateTriangle(double base,double height){
        return (height*base)/2;
    }
}