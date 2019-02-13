/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Salman
 */
public class tweet {

    protected String ConsumerKey;
    protected String ConsumerSecret;
    protected String AccessToken;
    protected String AccessTokenSecret;
    protected String tweet;

    public void display() {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("tweets.txt");
            br = new BufferedReader(fr);

            br = new BufferedReader(new FileReader("tweets.txt"));
            if (br.readLine() == null) {
                System.out.println("NO SAVED TWEETS");
                return;
            }
        } catch (IOException e) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {
                System.out.println("Program File Corrupted or Missing");
                System.exit(0);
            }
        }

        br = null;
        fr = null;

        try {

            fr = new FileReader("tweets.txt");
            br = new BufferedReader(fr);

            br = new BufferedReader(new FileReader("tweets.txt"));
            ArrayList al = new ArrayList();
            String line;

            while ((line = br.readLine()) != null) {
                // System.out.println();
                // System.out.println(br.readLine());
                //System.out.println(line);
                al.add(line);
            }
            int i;
            for (i = 0; i < al.size(); i++) {

                System.out.println(al.get(i));
            }
        } catch (IOException e) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {
                System.out.println("Program File Corrupted or Missing");
                System.exit(0);
            }
        }
    }

    public void tweetWriter(String tweet) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = tweet;

            fw = new FileWriter("tweets.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.newLine();

        } catch (Exception ex) {

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                System.out.println("Program File Corrupted or Missing");
                System.exit(0);
            }

        }

    }
}
