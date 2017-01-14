import java.io.*;
import java.util.*;

public class Main {
  public static void main(String []args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int TestCase = Integer.parseInt(br.readLine());
    while(TestCase>0) {
      String[] tempArray =br.readLine().split(" ");

        int S = Integer.parseInt(tempArray[0]);
        int SG = Integer.parseInt(tempArray[1]);
        int FG = Integer.parseInt(tempArray[2]);
        int D = Integer.parseInt(tempArray[3]);
        int T = Integer.parseInt(tempArray[4]);

        double DistanceInKm = (D*50)/1000;
        System.out.println(DistanceInKm);
        double TimeInMins = T/60;
        System.out.println(TimeInMins);
        double SpeedOfOtherCar = DistanceInKm*TimeInMins*60;
        System.out.println(SpeedOfOtherCar);
        double Speed = S+SpeedOfOtherCar;
        System.out.println(Speed);

        double SpeedDiffOfSebi = java.lang.Math.abs(Speed-SG);
        double SpeedDiffOfDad = java.lang.Math.abs(Speed-FG);
        System.out.println(SpeedDiffOfDad+" "+SpeedDiffOfSebi);

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
