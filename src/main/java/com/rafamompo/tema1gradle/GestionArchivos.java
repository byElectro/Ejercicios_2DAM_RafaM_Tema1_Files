package com.rafamompo.tema1gradle;

import java.io.*;
import java.util.Scanner;

public class GestionArchivos {

    static Scanner sc = new Scanner(System.in);


    static boolean crearArchivos(String directorio, String archivo) {


        File f1 = new File(directorio, archivo);
        try (FileWriter fw = new FileWriter(f1)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("El fichero se ha creado correctamente");
        return true;
    }

    static void listarDirectorio(String directorio){

        File f1 = new File (directorio);
        File[] ficheros = f1.listFiles();

        if (ficheros == null){
            System.out.println("El directorio no existe...");
            return;
        }

        for (int x = 0; x < ficheros.length; x++){

            String tipo;
            String permisos = "";


            if (ficheros[x].isFile() ){
                tipo = " f";

            }else{
                tipo = " d";
            }


            if (ficheros[x].canRead()) permisos += "r";

            if (ficheros[x].canWrite()) permisos += "w";

            System.out.println(ficheros[x].getName() + tipo + " " + ficheros.length + " bytes " + permisos);


        }

    }

    static void verInfo(String directorio, String archivo) {

        File fichero1 = new File(directorio, archivo);

        System.out.println("Nombre: " + fichero1.getName());
        System.out.println("Ruta absoluta: " + fichero1.getAbsolutePath());
        System.out.println("Se puede escribir: " + fichero1.canWrite());
        System.out.println("Se puede leer: " + fichero1.canRead());
        System.out.println("Tamaño: " + fichero1.length() + " bytes");
        System.out.println("Es directorio: " + fichero1.isDirectory());
        System.out.println("Es archivo: " + fichero1.isFile());
    }

    static void leerArchivo(String directorio, String archivo) {

        File fichero = new File(directorio, archivo);

        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    static void contenidoBinarioHexadecimal (){

        File f1 = new File ("C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Planos\\Bienvenido.txt");
        String res = null;
        int n = 0;
        try (FileInputStream fis = new FileInputStream(f1)){

            int dato = fis.read();

            while (dato != -1){

                //% es para especificaar el sistema numérico con el que quieres representar el dato. La X es de hexadecimal (en minus saldran letras en minuscula).
                //0 significa que rellena con ceros
                //2 significa que sean 2 digitos.
                res = String.format("%02X ", dato);

                //Imprime el primer byte
                System.out.print(res);
                n++;

                //una vez llegue a 11 Bytes hace un salto de linea.
                if ( n % 11 == 0){
                    System.out.println();
                }


                dato = fis.read();
            }

            fis.close();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }



    }



    static boolean compararArchivos(String fichero1, String fichero2) {

        try {
            FileInputStream f1 = new FileInputStream(fichero1);
            FileInputStream f2 = new FileInputStream(fichero2);

            int dato1;
            int dato2;

            do {
                dato1 = f1.read();
                dato2 = f2.read();

                if (dato1 != dato2) {
                    f1.close();
                    f2.close();
                    return false;
                }

            } while (dato1 != -1);

            f1.close();
            f2.close();

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public void concatenarContenidoArchivos(String archivo1, String archivo2, String archivo3) {

        try {

            FileInputStream f1 = new FileInputStream(archivo1);
            FileInputStream f2 = new FileInputStream(archivo2);

            FileOutputStream f3 = new FileOutputStream(archivo3);

            int dato;

            // Primero copiamos el archivo 1
            while ((dato = f1.read()) != -1) {
                f3.write(dato);
            }

            // Después copiamos el archivo 2
            while ((dato = f2.read()) != -1) {
                f3.write(dato);
            }

            f1.close();
            f2.close();
            f3.close();

        } catch (IOException e) {
            System.out.println("Error al concatenar.");
        }
    }


    public void concatenarLineas(String archivo1, String archivo2, String archivo3) {

        try {

            // Abrimos el primer archivo para poder LEERLO línea por línea
            BufferedReader br1 = new BufferedReader(new FileReader(archivo1));

            // Hacemos lo mismo con el segundo archivo
            BufferedReader br2 = new BufferedReader(new FileReader(archivo2));

            // Creamos/abrimos el tercer archivo para ESCRIBIR el resultado
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo3));

            String linea1;
            String linea2;

            /*
             * Lee una línea de cada archivo.
             *
             * readLine() devuelve:
             * - El contenido de la línea si existe.
             * - null cuando ya no queden más líneas.
             *
             * Por eso usamos != null para saber si todavía podemos seguir leyendo.
             */
            while ((linea1 = br1.readLine()) != null
                    && (linea2 = br2.readLine()) != null) {

                // Juntamos la misma línea de los dos archivos
                bw.write(linea1 + linea2);

                // Bajamos a la siguiente línea del archivo resultado
                bw.newLine();
            }

            br1.close();
            br2.close();
            bw.close();

        } catch (IOException e) {

            // Si ocurre algún error al abrir, leer o escribir
            System.out.println("Error al concatenar líneas.");
        }
    }




}
