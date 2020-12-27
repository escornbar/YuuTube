/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Videos {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        
        //uploadFile();
        //playVideo();
        //deleteVideo();
    
    }
        
    //Method to upload a video
    static void uploadFile(){
        
        File f = new File("C:/Users/user/YuuTube");
            
        if(!f.exists()){
            f.mkdir();
        }
            
        final int BUFFERSIZE = 4 * 1024;
        Scanner s = new Scanner(System.in);
        System.out.print("VIDEO UPLOAD GUIDE\nEnter the file path of the video to be uploaded: C:/My_Folder/videos\n");
        System.out.println("*Note: Both / and \\ can be used");
        System.out.println("Enter the name of the video: test.mp4");
        System.out.print("\nYUUTUBE VIDEO UPLOAD\n");
        System.out.print("Enter the file path of the folder the video is in: ");
        String sourceFilePath = s.nextLine();
       // File videoFile = new File(sourceFilepath);
        //String fileName = videoFile.getName();
        
        System.out.print("Enter the name of video: ");
        String outputFilePath = s.nextLine(); 


   try(
        FileInputStream fin = new FileInputStream(new File(sourceFilePath + "/" + outputFilePath));
        FileOutputStream fout = new FileOutputStream(new File("C:/Users/user/YuuTube/" + outputFilePath));
        ){

        byte[] buffer = new byte[BUFFERSIZE];

        while(fin.available() != 0) {
        fin.read(buffer);
        fout.write(buffer);
        } 

    }
    catch(Exception e) {
        System.out.println("Something went wrong! Reason: " + e.getMessage());
    }

        } 
    
    //Method to play video
    static void playVideo(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter video name: ");
        String chosenFile = s.nextLine();
      
        try{
            File f = new File("C:/Users/user/YuuTube/" + chosenFile);
            Desktop.getDesktop().open(f);
        }catch(IOException e1){
        }
   }
    
    //Method to delete video
    static void deleteVideo(){
        Scanner s =new Scanner(System.in);
        System.out.print("Enter name of video: ");
        String video = s.nextLine();
        File f = new File("C:/Users/user/YuuTube/" + video); 
        if (f.delete()) { 
            System.out.println("Deleted the file: " + f.getName());
        } else {
            System.out.println("Failed to delete the file.");
        } 
    }
    
}
