
import java.util.Map;

public class Regression {

    private Map<Double, Double> data;

    private double LEARNING_RATE = 0.0001;
    private int LEARNING_ITERATIONS = 1000;
    private int dataLength = 0;

    private double b = 0; // initial y-intercept guess
    private double m = 0; // initial slope guess

    public Regression(){
        System.out.println("Reading data from CSV file");
        this.data = DataReader.read("dataset1.csv");
        this.dataLength = data.size();
        System.out.println("Reading completed, Fetched " + dataLength + " objects");
    }

    public double predict(double x){
        double y = b + m * x;
        return y;
    }

    public void run(){
        System.out.println("Starting gradient descent at b = 0, m = 0, error = " + calculateError());
        System.out.println("Training...");
        train();
        System.out.println("After training gradient descent at b = "+ b +", m = "+ m +", error = " + calculateError());
    }

    private void train() {
        for (int i = 0; i < LEARNING_ITERATIONS; i++) {
            stepGradient(i+1);
        }
    }

    private void stepGradient(int trainingNum) {

       // System.out.println("===== Training feed number #"+trainingNum+" =====");

        double b_gradient = 0;
        double m_gradient = 0;
        int dataLength = data.size();

        for (Map.Entry<Double, Double> entry : data.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            b_gradient += -(2d/dataLength) * (y - ((m * x) + b));
            m_gradient += -(2d/dataLength) * x * (y - ((m * x) + b));
        }

        b = b - (LEARNING_RATE * b_gradient);
        m = m - (LEARNING_RATE * m_gradient);
    }

    private double calculateError() {

        //Should return MSE (Mean Squared Error)
        double totalError = 0;

        for (Map.Entry<Double, Double> entry : data.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            //System.out.println("M => " + m + " | b => " + b);
            totalError += Math.pow(y - (m * x + b), 2);
        }

        return totalError/data.size();
    }
}
