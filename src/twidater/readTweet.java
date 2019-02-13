/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Salman
 */
public class readTweet extends tweet {

    void read() throws IOException, TwitterException {
        try {
            ConsumerKey = new keys().getConsumerKey();
            ConsumerSecret = new keys().getConsumerSecret();
            AccessToken = new keys().getAccessToken();
            AccessTokenSecret = new keys().getAccessTokenSecret();
        } catch (Exception ex) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
        }
        logStatus st1 = new logStatus();
        boolean stat = st1.checksettingst();
        try {
            Date dNow = new Date();
            SimpleDateFormat ft
                    = new SimpleDateFormat("E dd-MM-yyyy hh'h'-mm'm'-ss's' a zzz");

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(ConsumerKey)
                    .setOAuthConsumerSecret(ConsumerSecret)
                    .setOAuthAccessToken(AccessToken)
                    .setOAuthAccessTokenSecret(AccessTokenSecret);

            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter4j.Twitter twitter = tf.getInstance();
            boolean flag;
            lineNum lineNum = new lineNum();
            int line = 1;
            flag = lineNum.checkLineNum();

            List<Status> status;
            String datetime = ft.format(dNow);
            if (stat == true) {
                System.out.println("\nRetriving tweets......\n\n\n");
                File file = new File("Record/" + datetime + ".txt");
                file.getParentFile().mkdirs();
                PrintWriter writer = new PrintWriter(file);

                status = twitter.getHomeTimeline();
                for (Status st : status) {
                    try {

                        tweet = st.getUser().getName() + "  " + st.getText();
                        if (flag == true) {
                            writter(line++);
                            System.out.print(" " + tweet + "\n");
                            System.out.println(" ");
                        } else {
                            writter();
                            System.out.print(" " + tweet + "\n");
                            System.out.println(" ");
                        }

                        writer.println(tweet);
                        writer.println(" ");

                    } catch (Exception ex) {

                    }

                }

                writer.close();
                mainMenu smenu = new mainMenu();
                smenu.smallMenu();
            } else {
                new readTweetPlus().read();

                mainMenu smenu = new mainMenu();
                smenu.smallMenu();
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong...Check Your Credetials / Internet Connection / Program Files");
            System.exit(0);
        }
    }

    public void writter(int linenum) {
        System.out.print(linenum);
    }

    public void writter() {
        System.out.print("");
    }
}
