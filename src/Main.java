public class Main {
    //test
    public static void main(String[] args) {
        System.out.println(calculateCircle(150));
    }

    public static double calculateCircle(int radius){
        return Math.PI*Math.pow(radius,2);
    }

    public static double calculateSquare(int side){
        return Math.pow(side,2);
    }

    public static double calculateTriangle(int base,double height){
        return (height*base)/2;
    }
}