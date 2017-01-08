import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public CalculateLCM(int x, int y) {
    if(x%y==0 || y%x==0) {
      if(x>y) return x;
      else return y;
    }
    else
    return x*y;
  }

   public static void main(String []args) throws IOException {
     int T = Integer.parseInt(br.readLine());
     while(T>0) {
        int arrayLength = Integer.parseInt(br.readLine());
        int[] SensorArray = new int [arrayLength];

        //Since all the elements of the array are given in the same line.
        String[] tempArray = br.readLine().split(" ");
        for(int i=0;i<arrayLength;i++) {
          SensorArray[i] = Integer.parseInt(tempArray[i]);
        }

        Arrays.sort(SensorArray);
        int Time = CalculateLCM(SensorArray[0],SensorArray[1]);
        System.out.println(Time);
       T--;
     }
   }
