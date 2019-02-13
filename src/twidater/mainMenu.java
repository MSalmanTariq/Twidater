/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import twitter4j.TwitterException;

/**
 *
 * @author Salman
 */
public class mainMenu {

    Scanner in = new Scanner(System.in);

    void mainMenu() throws IOException, TwitterException {
        System.out.println("Press 1 for READ TWEETS");
        System.out.println("Press 2 for WRITE TWEET");
        System.out.println("Press 3 for YOUR SAVED TWEETS");
        System.out.println("Press 4 for RECORD SETTING");
        System.out.println("Press 5 for LINE NUMBER");
        System.out.println("Press 6 for LOG OUT");
        System.out.println("Press 7 for EXIT");

        int i = in.nextInt();

        switch (i) {
            case 1:
                readTweet read = new readTweet();
                read.read();
                break;

            case 2:

                writeTweet write = new writeTweet();
                write.writeTweet();
                break;

            case 3:
                tweets();
                smallMenu();
                break;
            case 4:
                setting();
                break;
            case 5:
                lineMenu();
                break;

            case 6:
                logStatus nullstatus = new logStatus();
                nullstatus.writeNullStatus();
                System.out.println("Successfully Logout ..!!\n");
                login login = new login();
                login.login();
                break;

            case 7:
                System.exit(0);
                break;
        }

    }

    void smallMenu() throws IOException, TwitterException {
        System.out.println("\nPress 1 for MAIN MENU");
        System.out.println("Press 2 for EXIT");

        int i = in.nextInt();

        switch (i) {

            case 1:
                mainMenu();
                break;

            case 2:
                System.exit(0);
                break;

        }
    }

    void setting() throws IOException, TwitterException {
        logStatus setting = new logStatus();
        if (setting.checksettingst() == true) {
            System.out.println("Currenly AUTO RECORD IS ENABLED");
        } else {
            System.out.println("Currenly AUTO RECORD IS DISABLED");
        }
        System.out.println("\nPress 'y' to ENABLE AUTO RECORD TWEETS");
        System.out.println("Press 'n' to DISABLE AUTO RECORD TWEETS");

        char var;
        var = in.next().charAt(0);
        switch (var) {

            case 'y':
                logStatus setting1 = new logStatus();
                setting1.settingst();
                mainMenu();
                break;

            case 'n':
                logStatus setting2 = new logStatus();
                setting2.settingNullst();
                mainMenu();
                break;

        }

    }

    void lineMenu() {
        try {
            lineNum lineObj = new lineNum();
            if (lineObj.checkLineNum() == true) {
                System.out.println("Currenly LINE NUMBER IS ENABLED");
            } else {
                System.out.println("Currenly LINE NUMBER IS DISABLED");
            }
            System.out.println("\nPress 'y' to ENABLE LINE NUMBER");
            System.out.println("Press 'n' to DISABLE LINE NUMBER");

            char var;
            var = in.next().charAt(0);
            switch (var) {

                case 'y':
                    lineObj.setLineNum();
                    mainMenu();
                    break;

                case 'n':
                    lineObj.delLineNum();
                    mainMenu();
                    break;

            }
        } catch (Exception ex) {

        }
    }

    public void tweets() {
        System.out.println("\nPress 1 for READ YOUR SAVED TWEETS");
        System.out.println("Press 2 for CLEAR YOUR SAVED TWEETS");

        int i = in.nextInt();

        switch (i) {

            case 1:
                tweet tweet = new tweet();
                tweet.display();

                break;

            case 2:
                clearTweets();
                break;

        }
    }

    public void clearTweets() {
        try {
            PrintWriter writer = new PrintWriter("tweets.txt", "UTF-8");
            writer.println(" ");
            System.out.println("OPERATION SUCCESSFULL!!");
        } catch (Exception ex) {
            System.out.println("Program File Corrupted or Missing");
        }
    }

}
