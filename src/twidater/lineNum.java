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

/**
 *
 * @author Salman
 */
public class lineNum extends tweet {

    lineNum() {

    }

    public void setLineNum() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "1";

            fw = new FileWriter("line.txt");
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch (IOException e) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
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

    public void delLineNum() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "";

            fw = new FileWriter("line.txt");
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch (IOException e) {
            System.out.println("Program File Corrupted or Missing");
            System.exit(0);
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

    public boolean checkLineNum() {
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("line.txt");
            br = new BufferedReader(fr);

            br = new BufferedReader(new FileReader("line.txt"));

            String status2 = br.readLine();
            if (status2 == null) {

                return false;
            } else {
                return true;

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
        return true;

    }
}
