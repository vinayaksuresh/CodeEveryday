import java.io.*;
import java.util.*;
Class Main() {
  public static void main(string[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long T = integer.parseInt(br.readLine());
    while (T>0) {
      long catCount,catOnFloor,catOnDogs,dogCount,chefCount;
      String tempArray = br.readLine().split(" ");
      catCount = Interger.parseInt(tempArray[1]);
      dogCount = Integer.parseInt(tempArray[2]);
      chefCount = Integer.parseInt(tempArray[3]);

      if (chefCount=4*dogCount) {
        if ((catCount/dogCount)<=2) {
            System.out.println("yes");
        }
        else
        System.out.println("no");
      }
      else if (chefCount>4*dogCount) {
        catOnFloor = chefCount - 4*dogCount;
        if ((catOnFloor/4)==catCount) {
          System.out.println("yes");
        }
        else if ((catOnFloor/4)<catCount) {
          (catOnFloor/4) - catCount = catOnDogs;
          if ((catCount/dogCount)<=2) {
              System.out.println("yes");
          }
          else
          System.out.println("no");
        }
      else
        System.out.println("no");
      }
    }
  }
}
