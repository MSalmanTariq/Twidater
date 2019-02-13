/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twidater;

import java.io.IOException;
import twitter4j.TwitterException;

/**
 *
 * @author Salman
 */
public class Twidater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException, IOException {

        System.out.println("!!!!!!!!!!!!!!!!!!!!**************************************************!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!                TWIDATER CLI VERSION              !!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!**************************************************!!!!!!!!!!!!!!!!!!!!");

        login l1 = new login();
        l1.login();

    }

}
