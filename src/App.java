public class App {

    public static void main(String[] args) {

        Regression regression = new Regression();
        regression.run();
        System.out.println("Predict value for 6 (x): " + regression.predict(33.33) );

    }
}
