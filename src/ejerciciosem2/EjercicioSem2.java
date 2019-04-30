/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosem2;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Estudiantes
 */
public class EjercicioSem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        File archivo = new File("C:/Users/Estudiantes/Desktop/prueba.csv");
        FileReader reader = new FileReader(archivo);
        BufferedReader br = new BufferedReader(reader);
        String linea;
        int uno = 0, dos = 0, tres = 0;
        
        while ((linea = br.readLine()) != null) {
            String[] info = linea.split(",");

            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(info[2], formato);
            LocalDate ahora = LocalDate.now();

            Period periodo = Period.between(fechaNac, ahora);
            if (periodo.getYears() > 0 && periodo.getYears() <= 18) {
                uno++;
            }
            if (periodo.getYears() > 18 && periodo.getYears() <= 30) {
                dos++;
            }
            if (periodo.getYears() > 30) {
                tres++;
            }
            System.out.println("La edad de " + info[1] + " es " + periodo.getYears());
        }
        System.out.println("Hay " + uno + " usuario(s) entre 0 y 18 años: ");
        System.out.println("Hay " + dos + " usuario(s) entre 18 y 30 años: ");
        System.out.println("Hay " + tres + " usuario(s) mayores a 30 años: ");
    }
    
}
