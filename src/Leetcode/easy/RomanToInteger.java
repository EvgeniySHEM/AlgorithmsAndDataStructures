package Leetcode.easy;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("IM"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            char current = s.charAt(i);
            if(i>0 && value(current) > value(s.charAt(i-1))){
                result = value(current) - result;
            } else {
                result += value(current);
            }
        }
        return result;
    }

    public static int value(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
