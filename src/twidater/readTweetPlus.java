/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.IOException;
import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Salman
 */
public class readTweetPlus extends readTweet {

    int linenum;

    @Override
    public void read() throws TwitterException, IOException {
        try {
            ConsumerKey = new keys().getConsumerKey();
            ConsumerSecret = new keys().getConsumerSecret();
            AccessToken = new keys().getAccessToken();
            AccessTokenSecret = new keys().getAccessTokenSecret();
        } catch (Exception ex) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
        }
        try {
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
            System.out.println("\nRetriving tweets......\n\n\n");
            List<Status> status;
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

                } catch (Exception ex) {

                }

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
