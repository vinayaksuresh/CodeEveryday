import java.io.*;
import java.util.*;
import java.lang.*;

class TestClass {

    static boolean isPrime(int n) {
    for(int i=2;i<n;i++) {
        if(n%i==0)
            return false;
    }
    return true;
}

    static int calculateNearPrime(int num) {
        int tempNum1 = 0, tempNum2 = 0, BeforeCount = 0, AfterCount = 0;
        for(int j=num-1;j<num;j--) {
            if (j>49) {
            BeforeCount++;
            if(isPrime(j)) {
                tempNum1 = j;
                break;
            }
            }
            else
            {
                BeforeCount = 9999;
                break;
            }
        }
        for(int j=num+1;j>num;j++) {
            if (j<126) {
                AfterCount++;
                if(isPrime(j)) {
                    tempNum2 = j;
                    break;
                }
            }
            else {
                AfterCount = 9999;
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
        int T = Integer.parseInt(br.readLine());
        while (T>0) {
            int wordLength = Integer.parseInt(br.readLine());
            int[] ASCIIword_Letter = new int[wordLength];
            char[] ASCIIword_Digit = new char[wordLength];
            char[] word = new char[wordLength];
            br.read(word);
            br.readLine();
            for(int i=0;i<wordLength;i++) {

                ASCIIword_Digit[i] = 0;
                ASCIIword_Letter[i] = 0;

                if(Character.isDigit((word[i]))) {
                    System.out.println("here");
                    ASCIIword_Digit[i] = (char)word[i];
                    System.out.println(ASCIIword_Digit[i]);
                }
                else {
                    ASCIIword_Letter[i] = (int)word[i];
                }



                if (!isPrime(ASCIIword[i])) {
                    ASCIIword[i] = calculateNearPrime(ASCIIword[i]);
                    word[i] = (char)ASCIIword[i];
                    }
                }
            //System.out.println(ASCIIword[0]);
            T--;
        }
    }
}
