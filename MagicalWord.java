import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

class TestClass {

    static boolean isPrime(int n) {
    for(int i=2;i<n;i++) {
        if(n%i==0)
            return false;
    }
    return true;
}

    static long int calculateNearPrime(long int num) {
        long int tempNum1 = 0, tempNum2 = 0, BeforeCount = 0, AfterCount = 0;
        for(int j=num-1;j<num;j--) {
            BeforeCount++;
            if(isPrime(j)) {
                tempNum1 = j;
                break;
            }
        }
        for(int j=num+1;j>num;j++) {
            AfterCount++;
            if(isPrime(j)) {
                tempNum2 = j;
                break;
            }
        }
        if(BeforeCount<=AfterCount) {
            return tempNum1;
        }
        else
            return tempNum2;
}

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long int T = Integer.parseInt(br.readLine());
        while (T>0) {
            long int wordLength = Integer.parseInt(br.readLine());
            long int[] ASCIIword = new int[wordLength];
            String tempArray = br.readLine();
            for(long int i=0;i<wordLength;i++) {
                ASCIIword[i] = (long int)(tempArray.charAt(i));
                if (!isPrime(ASCIIword[i])) {
                    ASCIIword[i] = calculateNearPrime(ASCIIword[i]);
                }
            }
            for(int j=0;j<wordLength;j++){
                System.out.print((char)ASCIIword[j]);
            }
            System.out.println();
            T--;
        }
    }
}
