/*
https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/
Dhananjay has recently learned about ASCII values.He is very fond of experimenting. With his knowledge of ASCII values and character he has developed a special word and named it Dhananjay's Magical word.

A word which consist of alphabets whose ASCII values is a prime number is an Dhananjay's Magical word. An alphabet is Dhananjay's Magical alphabet if its ASCII value is prime.

Dhananjay's nature is to boast about the things he know or have learnt about. So just to defame his friends he gives few string to his friends and ask them to convert it to Dhananjay's Magical word. None of his friends would like to get insulted. Help them to convert the given strings to Dhananjay's Magical Word.

Rules for converting:

1.Each character should be replaced by the nearest Dhananjay's Magical alphabet.

2.If the character is equidistant with 2 Magical alphabets. The one with lower ASCII value will be considered as its replacement.

Input format:

First line of input contains an integer T number of test cases. Each test case contains an integer N (denoting the length of the string) and a string S.

Output Format:

For each test case, print Dhananjay's Magical Word in a new line.

Constraints:

1 <= T <= 100

1 <= |S| <= 500

SAMPLE INPUT
1
6
AFREEN

SAMPLE OUTPUT
CGSCCO

*/
import java.io.*;
import java.util.*;

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
            int[] ASCIIword = new int[wordLength];
            char[] word = new char[wordLength];
            br.read(word);
            br.readLine();
            for(int i=0;i<wordLength;i++) {
                ASCIIword[i] = (int)word[i];
                    if (!isPrime(ASCIIword[i])) {
                        ASCIIword[i] = calculateNearPrime(ASCIIword[i]);
                        word[i] = (char)ASCIIword[i];
                    }
                }
            System.out.println(word);
            T--;
        }
    }
}
