/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.IOException;
import java.util.Scanner;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Salman
 */
public class login {

    String status1, status2;
    protected String ConsumerKey;
    protected String ConsumerSecret;
    protected String AccessToken;
    protected String AccessTokenSecret;
    Scanner in = new Scanner(System.in);
    String name;

    void login() {

        try {
            new logStatus().checkStatus();
            ConsumerKey = new keys().getConsumerKey();
            ConsumerSecret = new keys().getConsumerSecret();
            AccessToken = new keys().getAccessToken();
            AccessTokenSecret = new keys().getAccessTokenSecret();

        } catch (Exception ex) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
        }
        System.out.println("\n\nLogin.... Please wait...");
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(ConsumerKey)
                    .setOAuthConsumerSecret(ConsumerSecret)
                    .setOAuthAccessToken(AccessToken)
                    .setOAuthAccessTokenSecret(AccessTokenSecret);

            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter4j.Twitter twitter = tf.getInstance();
            twitter4j.User newUser = twitter.showUser(twitter.getScreenName());
            name = newUser.getName();
        } catch (Exception ex) {
            System.out.println("Login Error \nCheck Your Credetials / Internet Connection ");
            System.exit(0);
        }
        System.out.println("Successfully login as " + name);
        System.out.println("\nWelcome to Main Menu\n");

        mainMenu menu = new mainMenu();
        try {

            menu.mainMenu();
        } catch (Exception ex) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
        }
    }

}
