package Math;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicMath{
    public static void main(String[] args) {
        Digits obj = new Digits();
        // int result = obj.countDigits(12345);
        // System.out.println(result);

        // int reverse = obj.reverseNumber(12345);
        // System.out.println(reverse);

        // if(obj.isPallindrome(1221)){
        //     System.out.println("The number is Pallindrome");
        // }else{
        //     System.out.println("The number is not a pallindrome! ");
        // }
        
        // if(obj.isArmstrong(371)){
        //     System.out.println("Yeah! this is the ArmStrong number");
        // }else{
        //     System.out.println("Not an ArmStrong number");
        // }

        // ArrayList<Integer>list = obj.allDivisors(36);
        // System.out.println(list.toString());

        // if(obj.isPrime(17)) System.out.println("Prime");
        // else System.out.println("Not prime");

        // int gcd = obj.greatestCommonDivisor(20, 40);
        // System.out.println(gcd);
        // int euc = obj.EuclideanAlgo(20, 15);
        // System.out.println(euc);

        int number = 20;
        // obj.printPrimeNumbers(number);
        obj.sieveOfEratosthenes(number);

            
    }
}


class Digits{
    public int countDigits(int number){
// ---------------------------------------------
//      Bruteforce Solution: TimeComplexity= O(logn)
        // int result = 0;
        // while(number>0){
        //     // int lastDig = number%10;
        //     result+=1;
        //     number/=10;
        // }
        // return result;
        // ----------------------------------------------
        // Optimal solution -Time Complexity-O(1)
        return (int)Math.floor(Math.log10(number))+1;
    }

    public int reverseNumber(int number){
        int result = 0;
        while(number>0){
            int lastDig = number%10;
            result = result*10+lastDig;
            number/=10;
        }
        return result;
    }

    public boolean isPallindrome(int number){
        if(number == reverseNumber(number)){
            return true;
        }
        return false;
    }

    public boolean isArmstrong(int number){
        int result = number;
        int sum = 0;
        while(number>0){
            int lastDig = number%10;
            sum+=lastDig*lastDig*lastDig;
            number/=10;
        }
        if(sum == result){
            return true;
        }
        return false;
    }

    public ArrayList<Integer> allDivisors(int number){
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=1;i*i<=number;i++){
            if(number%i == 0){
                list.add(i);
                if(number/i!=i){
                    list.add(number/i);
                }
            }
        }
        return list;
    }
    public boolean isPrime(int number){
        int cnt = 0;
        for(int i=1;i<number;i++){
            if(number%i == 0){
                cnt++;
            }
        }
        if(cnt>2){
            return false;
        }else{
            return true;
        }
    }
    public int greatestCommonDivisor(int num1, int num2){
        int gcd = 0;
        for(int i=1;i<=(num1>num2?num2:num1);i++){
            if(num1%i == 0 && num2%i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
    public int EuclideanAlgo(int num1,int num2){
        if(num1 == 0){
            return num2;
        }
        int min = Math.min(num1, num2);
        num1 = (int)Math.max(num1, num2) % (int)Math.min(num1, num2); 
        
        return EuclideanAlgo(num1, min);
    }
    public void printPrimeNumbers(int number){
        for(int i=1;i<number;i++){
            int cnt = 0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    cnt++;
                }
            }
            if(cnt == 2){
                System.out.print(i+" ");
            }
        }
    }
    public void sieveOfEratosthenes(int number){
        int prime[] = new int[number+1];
        for(int i=2;i<prime.length;i++){
            prime[i] = 1;
        }
        for(int i=2;i*i<=number;i++){
            if(prime[i] == 1){
                for(int j=i*i;j<=number;j+=i){
                    prime[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(prime));
        for(int j=0;j<prime.length;j++){
            if(prime[j] == 1){
                System.out.print(j+" ");
            }
        }
    }

}


// 1)   extraction of digits should be done by the number%10 this gives the last digit of the number 