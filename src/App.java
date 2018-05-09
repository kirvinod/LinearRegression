public class App {

    public static void main(String[] args) {

        double data[][] = { {1,2}, {2,2}, {3,2}, {4,2}, {5,2},
                {6,2}, {7,2}, {8,2}, {9,2}, {10,2} };

        Predictor predictor = new Predictor(data);
        predictor.calculateError();

    }
}
