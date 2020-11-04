/*package whatever //do not write package name here */

// Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

// Output:
// For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 107
// 1 <= Ai <= 1010

// Example:
// Input:
// 2
// 5 12
// 1 2 3 7 5
// 10 15
// 1 2 3 4 5 6 7 8 9 10
// Output:
// 2 4
// 1 5

// Explanation :
// Testcase1: sum of elements from 2nd position to 4th position is 12
// Testcase2: sum of elements from 1st position to 5th position is 15

// Reference: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

import java.util.*;
import java.lang.*;
import java.io.*;

public class NoSolutionException extends Exception {
    public NoSolutionException(String errorMessage) {
        super(errorMessage);
    }
}

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while (t > 0) {
            String[] strs = br.readLine().trim().split("\\s+");
            Integer size = Integer.parseInt(strs[0]);
            Integer sum = Integer.parseInt(strs[1]);
            String[] arrString = br.readLine().trim().split("\\s+");
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                arr.add(Integer.parseInt(arrString[i]));
            }
            try {
                Map sol = solution(arr, sum, size);
                sb.append(sol.get("first") + " " + sol.get("last") + "\n");
            } catch (NoSolutionException e) {
                sb.append(-1 + "\n");
            }
            t--;
        }

        System.out.print(sb);
    }

    /**
     * Solution with sliding window approach. 
     * 
     * @param array Input array
     * @param sum Input sum
     * @param size Size of the array
     * @return Map with keys first and last
     * @throws NoSolutionException
     */
    static Map<String, Integer> solution(List<Integer> array, Integer sum, Integer size) throws NoSolutionException {
        Integer currsum = array.get(0);
        Integer first = 0;
        if (currsum.equals(sum)) {
            return Map.of("first", 1, "last", 1);
        }
        for (int i = 1; i < size; i++) {
            if (currsum + array.get(i) == sum) {
                return Map.of("first", first + 1, "last", i + 1);
            }

            if (currsum + array.get(i) < sum) {
                currsum = currsum + array.get(i);
                continue;
            }

            if (currsum + array.get(i) > sum) {
                currsum = currsum + array.get(i);
                while (first <= i) {
                    currsum = currsum - array.get(first);
                    first = first + 1;
                    if (currsum <= sum) {
                        break;
                    }
                }
                if (currsum.equals(sum)) {
                    return Map.of("first", first + 1, "last", i + 1);
                }
            }
        }
        throw new NoSolutionException("No solution found");
    }
}