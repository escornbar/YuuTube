package Yuutube;

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String key;
        
        System.out.print("Search here : ");
        key = s.nextLine();
        
        String[] search = key.split(" ");
        for (String search1 : search) {
            for (int j = 0; j < search1.length(); j++) {
                while (search1.length()>j) {
                    System.out.print(search1.charAt(j));
                    j++;
                }
                System.out.println("");
            }
        }
    }
    static String searching (String search) {
        Scanner s = new Scanner(System.in);
        int k=0;
        String videos;
        System.out.println("You may upload your videos");
        videos = s.nextLine();
        
        while (k>0) {
            System.out.println("Do you want to enter another video? Click 1 if YES and 0 if NO");
        }
        return search;
    }
    
}
