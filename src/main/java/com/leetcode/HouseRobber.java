package com.leetcode;

public class HouseRobber {

    public static void main(String[] args) {
        
        int houses[] = {2,1,1,2};

        System.out.println(rob(houses));
    }

    public static int rob(int[] houses) {

        if(houses.length == 0) return 0;

        if(houses.length < 2) {
            return houses[0];
        }

        houses[1] = Math.max(houses[0], houses[1]);

      
        for(int i = 2; i < houses.length; i++) {
            houses[i] = Math.max(houses[i-2] + houses[i], houses[i-1]);
        }
        return houses[houses.length-1];
    }

}
