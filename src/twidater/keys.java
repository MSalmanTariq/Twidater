/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Salman
 */
public class keys extends login {

    protected void writeKey() {

        System.out.println("\nWelcome to TWIDATER Login menu, Please provide these keys:");
        System.out.println("Enter Consumer Key: ");
        ConsumerKey = in.next();

        System.out.println("Enter Consumer Secret: ");
        ConsumerSecret = in.next();
        System.out.println("Enter Access Token: ");
        AccessToken = in.next();
        System.out.println("Enter Access Token Secret: ");
        AccessTokenSecret = in.next();

        try {

            PrintWriter writer = new PrintWriter("keys.txt", "UTF-8");
            writer.println(ConsumerKey);
            writer.println(ConsumerSecret);
            writer.println(AccessToken);
            writer.println(AccessTokenSecret);
            writer.close();
            new logStatus().writeStatus();
        } catch (IOException e) {

        }

    }

    protected String getConsumerKey() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("keys.txt");
        BufferedReader textReader = new BufferedReader(fr);
        return textReader.readLine();
    }

    protected String getConsumerSecret() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("keys.txt");
        BufferedReader textReader = new BufferedReader(fr);
        textReader.readLine();
        return textReader.readLine();
    }

    protected String getAccessToken() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("keys.txt");
        BufferedReader textReader = new BufferedReader(fr);
        textReader.readLine();
        textReader.readLine();
        return textReader.readLine();
    }

    protected String getAccessTokenSecret() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("keys.txt");
        BufferedReader textReader = new BufferedReader(fr);
        textReader.readLine();
        textReader.readLine();
        textReader.readLine();
        return textReader.readLine();
    }

}
