import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   public static void main(String []args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String[] tempArray = br.readLine().split(" ");
      int arrayLength  = Integer.parseInt(tempArray[0]);
      int numRotations = Integer.parseInt(tempArray[1]);

      int[] inputArray = new int [arrayLength];
      int[] resultArray = new int [arrayLength];
      tempArray = br.readLine().split(" ");
      for(int i=0;i<arrayLength;i++) {
        inputArray[i] = Integer.parseInt(tempArray[i]);
      }

      int finalIndexLocation = (arrayLength-numRotations)-1;
      resultArray[finalIndexLocation] = inputArray[arrayLength-1];
       System.out.print(resultArray[finalIndexLocation]+" ");

      for(int i=0;i<=arrayLength-2;i++) {
        resultArray[(finalIndexLocation+i)%arrayLength] = inputArray[i];
         System.out.print(resultArray[(finalIndexLocation+i)%arrayLength]+" ");
      }
   }
 }
