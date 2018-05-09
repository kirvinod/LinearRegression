
public class Predictor {

    private double[][] data;

    //private double LEARNING_RATE = 0.0001;

    public Predictor(double[][] data){
        this.data = data;
    }

    public void calculateError(){

        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public void train() {

    }
}
