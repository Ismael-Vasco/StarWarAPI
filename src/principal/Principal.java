package principal;

import modelos.ConsultaPelicula;
import modelos.GeneradorDeArchivo;
import modelos.Pelicula;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("""
                \n*********************************************************************
                  Escriba el número de la película de Star Wars que desea consultar
                                          ****************
                             Solo se encuentran disponibles de la 1 a la 6
                 *********************************************************************\n
                """);


        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            System.out.println("\n***********************************************");
            System.out.println(pelicula.title());
            System.out.println("***********************************************\n");
            System.out.println("***********************************************");
            System.out.println("    ************** Sinopsis **************     ");
            System.out.println("***********************************************");
            System.out.println(pelicula.opening_crawl());
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println("Numero no enconrado: " +e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }

    }
}
