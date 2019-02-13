/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Salman
 */
public class writeTweet extends tweet {

    Scanner in = new Scanner(System.in);

    void writeTweet() throws IOException, TwitterException {

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        try {
            ConsumerKey = new keys().getConsumerKey();
            ConsumerSecret = new keys().getConsumerSecret();
            AccessToken = new keys().getAccessToken();
            AccessTokenSecret = new keys().getAccessTokenSecret();
        } catch (Exception ex) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
        }
        System.out.println("Write your Tweet and Press enter: ");

        tweet = in.nextLine();
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(ConsumerKey)
                    .setOAuthConsumerSecret(ConsumerSecret)
                    .setOAuthAccessToken(AccessToken)
                    .setOAuthAccessTokenSecret(AccessTokenSecret);

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            twitter.updateStatus(tweet);

            System.out.println("\n[" + df.format(dateobj) + "] ==> Tweet:" + "\"" + tweet + "\"------Successfull!!!\n");
            tweet writer = new tweet();
            writer.tweetWriter("[" + df.format(dateobj) + "] ==> Tweet:  " + "\"" + tweet + "\"");
            mainMenu smenu = new mainMenu();
            smenu.smallMenu();
        } catch (Exception ex) {
            System.out.println("Something went wrong...Check Your Credetials / Internet Connection / Program Files");
            System.exit(0);
        }
    }
}
