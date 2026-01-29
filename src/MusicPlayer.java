import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
      public static void main(String[] args) {
        String filePath = "/home/yassin/mother.wav";
        File file = new File(filePath);
        

        try (Scanner clv = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String choice="";
            
            while(!choice.equals("Q")){
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("enter your choice : ");
                choice = clv.next().toUpperCase();
                
                switch (choice) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("invalid choice");
                        
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }finally{
            System.out.println("Bye =)");           
        }

    }
}
