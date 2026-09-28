package com.rafamompo.tema1gradle;

import java.io.*;

public class Main2 {

    static void main(String[] args) {
        System.out.println(args[0]);
        File f1 = new File(args[0]);


        try {
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);

            FileInputStream fis = new FileInputStream(f1);
            String linea = br.readLine();
            while (linea != null) {


                //Imprime el primer byte
                System.out.println(linea);
                linea = br.readLine();
            }

            br.close();
            fr.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}
