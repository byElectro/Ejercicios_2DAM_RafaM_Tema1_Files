package com.rafamompo.tema1gradle;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void main() {

        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 1******************************************************************\n" +
                "****************************************************************************************************************************************************");

        File f1 = new File("C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Planos\\Bienvenido.txt");

        if (f1.isFile()){
            System.out.println("Esto es un fichero");

        }else {
            System.out.println("Esto es un directorio");

        }
       System.out.println();
       System.out.println();
       System.out.println("****************************************************************************************************************************************************\n" +
               "***********************************************************************EJERCICIO 2******************************************************************\n" +
               "****************************************************************************************************************************************************");


            File directorioEjer2 = new File ("C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Planos");

            String[] listaFicherosEjer2 = directorioEjer2.list();

        System.out.println("La lista de ficheros es: ");
            for (int x = 0; x < listaFicherosEjer2.length; x++){
                System.out.println(listaFicherosEjer2[x]);
            }

        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 3******************************************************************\n" +
                "****************************************************************************************************************************************************");




        String opc;
        do {
            String opciones =  " a) El nombre de la carpeta\n" +
                    " b) La ruta absoluta\n" +
                    " c) Si se puede leer\n" +
                    " d) Si se puede escribir\n" +
                    " e) Salir";

            System.out.println(opciones);

            System.out.println("Elige una de estas opciones: ");
            opc = sc.nextLine();

            switch (opc){
                case "a":
                    System.out.println(directorioEjer2.getName());
                    break;
                case "b":
                    System.out.println(directorioEjer2.getAbsolutePath());
                    break;
                case "c":
                    System.out.println(directorioEjer2.canRead());
                    break;
                case "d":
                    System.out.println(directorioEjer2.canWrite());
                    break;
                case "e":
                    System.out.println("Has salido del programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta, tiene que ser a/b/c/d/e");

            }

        }while(!opc.equals("e") );

        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 4******************************************************************\n" +
                "****************************************************************************************************************************************************");


        String opc2;
        File f2= new File("C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Planos\\Despedida.txt");
        File f3 = new File ("C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Binarios\\SteelSeriesGG95.0.0Setup.exe");
        do {
            String opciones2 =  "  a) El nombre del archivo\n" +
                    " b) La ruta absoluta\n" +
                    " c) Si se trata de un archivo oculto\n" +
                    " d) Si se puede leer\n" +
                    " e) Si se puede escribir\n" +
                    " f) La fecha de la última modificación (ayúdate de DateTimeFormatter). Luego cambia la fecha de\n" +
                    "modificación a la hora actual y vuélvela a comprobar.\n" +
                    " g) El tamaño en bytes, en KB y en MB.\n"+
                    " h) Salir";

            System.out.println(opciones2);

            System.out.println("Elige una de estas opciones: ");
            opc2 = sc.nextLine();

            switch (opc2){
                case "a":
                    System.out.println(f2.getName());
                    break;
                case "b":
                    System.out.println(f2.getAbsolutePath());
                    break;
                case "c":
                    System.out.print("Es oculto" + f2.isHidden());
                    break;
                case "d":
                    System.out.println("Puede leer: " + f2.canRead());
                    break;
                case "e":
                    System.out.println("Puede escribir: " + f2.canWrite());
                    break;
                case "f":
                    System.out.println("Fecha actual:");
                    System.out.println(f2.lastModified());

                    DateTimeFormatter formato =
                            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                    LocalDateTime nuevaFechaModificacion =
                            Instant.ofEpochMilli(f2.lastModified())
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime();

                    // Mostrar la nueva fecha
                    System.out.println("Fecha modificacion: "
                            + nuevaFechaModificacion.format(formato));

                    //sumo 1 dia ( 24 * 60 * 60 * 1000 )
                    f2.setLastModified(f2.lastModified() + 86400000);

                     nuevaFechaModificacion =
                            Instant.ofEpochMilli(f2.lastModified())
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime();

                    // Mostrar la nueva fecha
                    System.out.println("Fecha sumando 1 dia: "
                            + nuevaFechaModificacion.format(formato));

                    break;
                case "g":
                    System.out.println("Has salido del programa");

                    long bytes = f3.length();
                    long KB = bytes / 1024;
                    long MB = KB / 1024;

                    System.out.println ( "El tamaño en bytes: " + bytes);
                    System.out.println ( "El tamaño en KB: " + KB);
                    System.out.println ( "El tamaño en MB: " + MB);

                    break;
                default:
                    System.out.println("Opcion incorrecta, tiene que ser a/b/c/d/e/f/g");

            }

        }while(!opc2.equals("h") );

        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 5******************************************************************\n" +
                "****************************************************************************************************************************************************");

        System.out.println("a)");


        System.out.println("Dime el directorio donde lo quieres guardar: ");
        String directorioEjer5 = sc.nextLine();


        System.out.println("Dime con que nombre quieres guardar el archivo: ");
        String archivoEjer5 = sc.nextLine();
        GestionArchivos.crearArchivos(directorioEjer5,archivoEjer5);

        System.out.println("b)");
        GestionArchivos.listarDirectorio(directorioEjer5);

        System.out.println("c)");
        GestionArchivos.verInfo(directorioEjer5,archivoEjer5);


        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 6******************************************************************\n" +
                "****************************************************************************************************************************************************");

        String directorioEjer6 = "C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Planos";
        String ficheroEjer6 = "Bienvenido.txt";
        GestionArchivos.leerArchivo(directorioEjer6, ficheroEjer6);


        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 7******************************************************************\n" +
                "****************************************************************************************************************************************************");


        GestionArchivos.contenidoBinarioHexadecimal();


        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 9******************************************************************\n" +
                "****************************************************************************************************************************************************");


        boolean resultado = GestionArchivos.compararArchivos(
                "C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Planos\\Bienvenido.txt",
                "C:\\2DAM\\AccesoaDatos\\Tema1\\Ficheros_Boletin_1\\Ficheros_Planos\\Despedida.txt");

        System.out.println("¿Son iguales? " + resultado);


        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 10******************************************************************\n" +
                "****************************************************************************************************************************************************");


        System.out.println("----- CONCATENAR CONTENIDO -----");

        System.out.print("Introduce el primer archivo: ");
        String archivo1Ejer10 = sc.nextLine();

        System.out.print("Introduce el segundo archivo: ");
        String archivo2Ejer10 = sc.nextLine();

        System.out.print("Introduce el nombre del archivo resultado: ");
        String archivo3Ejer10 = sc.nextLine();

        GestionArchivos gestion = new GestionArchivos();

        gestion.concatenarContenidoArchivos(archivo1Ejer10, archivo2Ejer10, archivo3Ejer10);

        System.out.println("Archivos concatenados correctamente.");




        System.out.println();
        System.out.println();
        System.out.println("****************************************************************************************************************************************************\n" +
                "***********************************************************************EJERCICIO 11******************************************************************\n" +
                "****************************************************************************************************************************************************");

        System.out.println("----- CONCATENAR LINEAS -----");

        System.out.print("Introduce el primer archivo: ");
        String archivo1Ejer11 = sc.nextLine();

        System.out.print("Introduce el segundo archivo: ");
        String archivo2Ejer11 = sc.nextLine();

        System.out.print("Introduce el nombre del archivo resultado: ");
        String archivo3Ejer11 = sc.nextLine();

        gestion.concatenarLineas(archivo1Ejer11, archivo2Ejer11, archivo3Ejer11);

        System.out.println("Líneas concatenadas correctamente.");
    }
}
