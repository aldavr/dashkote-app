package com.example.framework.tests;

import java.util.ArrayList;
import java.util.List;

public class CodingChalanges {

    public static void main(String[] args){

        // int[] arr ={2,5,6,7,9};
        // stringIntoCharacter("Davron");
        // findCharacterInString("Davron", 'D');
        // System.out.println(findSum(new int[]{2, 3, 4, 1}));
        // System.out.println(evenNumbers(new int[] {2,4,6,8,9,12}));
        // System.out.println(oddNumbers(new int[] {2,4,5,7,9}));
        // fizzBuzz(15);
        // System.out.println(fizzBuzz2(15));
    }

    // stringIntoCharacter("Davron");;
    static void stringIntoCharacter(String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            System.out.println("char at " + i +" index is: " + c);
        }
    }

    // findCharacterInString("Davron", 'D');
    static void findCharacterInString(String s, char c){
        for (int i = 0; i < s.length(); i++){
            char _c = s.charAt(i);
            if (_c == c){
                System.out.println("We found " + c + " inside the index " + i);
                break;
            }
        }
    }

    // findSum(new int[]{2, 3, 4, 1});
    static int findSum(int[] arr){
        int sum = 0;
        for(int i : arr) sum += i;
        return sum;
    }

    // evenNumbers(new int[] {2,4,6,8,9,12});
    static int evenNumbers(int[] arr){
        int even= 0;
        for (int i : arr){
            if (i % 2 == 0) even++;
        }
        return even;
    }

    // oddNumbers(new int[] {2,4,5,7,9});
    static int oddNumbers(int[] arr) {
        int odd = 0;
        for (int i : arr) if (i % 2 != 0) odd++;
        return odd;
    }

    // fizzBuzz(15);
    static void fizzBuzz(int n){
        for (int i=1; i <= n; i++){
            if (i % 15 == 0) System.out.println("FizzBuzz"); // if i is divisible by 3 and 5
            else if (i % 3 == 0) System.out.println("Fizz"); // if i is divisible by 3
            else if (i % 5 == 0) System.out.println("Buzz"); //  if i is divisible by 5
            else System.out.println(i);
        }
    }

    static List<String> fizzBuzz2(int n) {
        List<String> stringArray = new ArrayList<>();
        for (int i=1; i<=n; i++){
            if (i % 15 == 0) stringArray.add("FizzBuzz");
            else if (i % 3 == 0) stringArray.add("Fizz");
            else if (i % 5 == 0) stringArray.add("Buzz");
            else stringArray.add(String.valueOf(i));
        }
        return stringArray;
    }

    // Find a letter from String
    static void findLetter(String name, char x){
        for (int i=0; i < name.length(); i++){
            char c = name.charAt(i);
            if (c == x){
                System.out.println("We found " + x);
                break;
            }
        }
    }

    // Method returns each char from String
    static ArrayList<String> listChar(String name) {
        ArrayList<String> arrList = new ArrayList<String>();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            arrList.add(String.valueOf(c));
        }
        return arrList;
    }


}
