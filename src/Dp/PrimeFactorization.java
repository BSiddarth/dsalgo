package Dp;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {


    public static void main(String[] args) {
        int number = 315;
        System.out.println(primeFactors(number));
    }

    static List<Integer> primeFactors(int n){

List<Integer> res = new ArrayList<>();
        while (n%2==0){
          res.add(2);
          n=n/2;
        }

 for (int i=3;i<=Math.sqrt(n);i=i+2){
     while (n%i==0){
         res.add(i);
         n=n/i;
     }

 }
        System.out.println(n);
        if (n > 2) {
            res.add(n);
        }


    return res;
    }


//    static boolean isPrimeNumber(int number){
//
//        for (int i=2;i<=Math.sqrt(number);i++){
//            if (number%i==0){
//                return false;
//            }
//        }
//        return true;
//    }
}
