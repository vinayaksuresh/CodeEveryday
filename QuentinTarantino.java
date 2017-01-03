import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   public static void main(String []args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int T = Integer.parseInt(br.readLine());
     while (T>0) {
       int arrayLength = Integer.parseInt(br.readLine());

       //Array Length Constraints
       if(arrayLength>=2 && arrayLength<=100){
       int[] UnSortedChapterArray = new int [arrayLength];

       //Since all the elements of the array are given in the same line.
       String[] tempArray = br.readLine().split(" ");
       for(int i=0;i<arrayLength;i++) {
         UnSortedChapterArray[i] = Integer.parseInt(tempArray[i]);
       }
       int correctionCount = 0;
       int[] chapterArray = new int [arrayLength];
       for(int i=0;i<arrayLength;i++) {
        chapterArray[i] = UnSortedChapterArray[i];
       }

       //Sorting array using the in-built sorting algorithms and comparing it with the UnSortedChapterArray
       //If both are the same then we can ignore it by saying no, because Tarantino never has his chapters in order.
       Arrays.sort(chapterArray);

     if(Arrays.equals(UnSortedChapterArray, chapterArray)) {
         correctionCount = 999;
     }

       for(int i=0;i<arrayLength;i++) {
             if((chapterArray[i] == (i+1)) && correctionCount!=999) {
                 correctionCount++;
             }
             else break;
         }
        if(correctionCount == arrayLength) {
            System.out.println("yes");
        }
         else System.out.println("no");
       T--;
     }
    }
   }
}
