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
      String[] tempArray = br.readLine().split(" ");
      for(int i=1,i<=arrayLength;i++) {
        inputArray[i] = Integer.parseInt(tempArray[i]);
      }

      int finalIndexLocation = arrayLength-numRotations;
      resultArray[arrayLength-numRotations] = inputArray[arrayLength];
      for(int i=1;i<finalIndexLocation;i++) {
        resultArray[(finalIndexLocation+i)%arrayLength] = inputArray[i];
      }
      for(int i=finalIndexLocation+1;i<=arrayLength;i++) {
        resultArray[(finalIndexLocation+i)] = inputArray[i];
      }
   }
 }
