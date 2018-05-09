import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataReader {

    public static Map<Double, Double> read(String fileName){

        fileName = "data/"+fileName;

        String line = null;

        Map<Double, Double> data = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] dataArr = line.split(",");
                double x = Double.parseDouble(dataArr[0]);
                double y = Double.parseDouble(dataArr[1]);
                data.put(x,y);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return data;

    }

}
