import java.io.*;
import java.util.*;

public class Main {
  public static void main(String []args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int TestCase = Integer.parseInt(br.readLine());
    while(TestCase>0) {
      String[] tempArray =br.readLine().split(" ");

        double S = Double.parseDouble(tempArray[0]);
        double SG = Double.parseDouble(tempArray[1]);
        double FG = Double.parseDouble(tempArray[2]);
        double D = Double.parseDouble(tempArray[3]);
        double T = Double.parseDouble(tempArray[4]);

        double DistanceInKm = (D*50)/1000;
        double TimeInMins = T/60;
        double SpeedOfOtherCar = DistanceInKm*TimeInMins*60;
        double Speed = S+SpeedOfOtherCar;

        double SpeedDiffOfSebi = java.lang.Math.abs(Speed-SG);
        double SpeedDiffOfDad = java.lang.Math.abs(Speed-FG);

        if(SpeedDiffOfDad>SpeedDiffOfSebi) {
          System.out.println("SEBI");
        }
        else {
          System.out.println("FATHER");
        }

      TestCase--;
    }
  }
}
