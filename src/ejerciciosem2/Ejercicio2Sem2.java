/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class Ejercicio2Sem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Se define la lista clave-valor y se guardan los datos
        HashMap<String, String> lista = new HashMap<String, String>();
        lista.put("a", "11");
        lista.put("b", "12");
        lista.put("c", "13");
        lista.put("d", "14");
        lista.put("e", "15");
        lista.put("f", "16");
        lista.put("g", "17");
        lista.put("h", "18");
        lista.put("i", "19");
        lista.put("j", "20");
        lista.put("k", "31");
        lista.put("l", "32");
        lista.put("m", "33");
        lista.put("n", "34");
        lista.put("ñ", "35");
        lista.put("o", "36");
        lista.put("p", "37");
        lista.put("q", "38");
        lista.put("r", "39");
        lista.put("s", "40");
        lista.put("t", "61");
        lista.put("u", "62");
        lista.put("v", "63");
        lista.put("w", "64");
        lista.put("x", "65");
        lista.put("y", "66");
        lista.put("z", "67");
        lista.put("1", "*");
        lista.put("2", "/");
        lista.put("3", "\\");
        lista.put("4", "+");
        lista.put("5", "-");
        lista.put("6", "<");
        lista.put("7", ">");
        lista.put("8", "#");
        lista.put("9", "\"");
        lista.put("0", "!");
        lista.put(" ", "U");

        //Se solicita al usuario que ingrese el codigo
        Scanner teclado = new Scanner(System.in);
        System.out.println(">>>");
        String text = teclado.nextLine();

        //se comprueba que la cadena ingresada inicia con "_"
        if (text.startsWith("_")) { 
            //se obtiene todos los numeros de la cadena ingresada con la función getNumero
            String numeros = getNumero(text);

            //se parsea los numeros obtenidos a enteros para hacer la operacion de obtenerlos de a pares
            int number = Integer.valueOf(numeros);
            int[] digitos = new int[numeros.length()];
            int j = digitos.length - 1;
            //se realiza el ciclo que recorre los numeros obtenidos y los separa de a dos digitos
            while (number > 0) {

                digitos[j] = number % 100;
                number = number / 100;
                j--;

            }

            String pares = "";
            //se recorre la lista de digitos para obtenerlos de a pares
            for (int k = 0; k < digitos.length; k++) {
                if (digitos[k] != 0) {
                    //se obtienen los numeros de a pares y se pasan a string para encontrarlos en la lista
                    //y encontrar su key
                    pares = String.valueOf(digitos[k]);
                    //Se realiza el ciclo que recorre la lista de datos y obtiene por aparte la clave y el valor
                    for (Map.Entry<String, String> caracter : lista.entrySet()) {                        
                        String key = caracter.getKey();
                        String value = caracter.getValue();

                        //Se compara los numeros obtenidos con los de la lista y los imprime
                        if (pares.equals(value)) {
                            System.out.print(key);
                        }
                    }

                }
            }

            //se realiza otro ciclo para buscar en la lista de datos los demás caracteres que no son numeros 
            for (int i = 0; i < text.length(); i++) {

                for (Map.Entry<String, String> caracter : lista.entrySet()) {
                    String key = caracter.getKey();
                    String value = caracter.getValue();
                    //se compara que el caracter se encuentra en la lista de datos y se imprime el resto del código
                    if (String.valueOf(text.charAt(i)).equals(value)) {

                        System.out.print(key);
                    }
                }

            }

            //sino empieza con "_" se busca por caracter en la lista de datos su valor
        } else {
            for (int x = 0; x < text.length(); x++) {
                System.out.print(lista.get(String.valueOf(text.charAt(x))));
            }

        }
    }
    
    
    /**
     * Función que busca en una cadena los que sean números
     * @param cadena: Cadena ingresada
     * @return: Retorna los números que tenga esa cadena 
     */
    public static String getNumero(String cadena) {
        char[] cadenaChar = cadena.toCharArray();
        String retorno = "";
        for (int i = 0; i < cadenaChar.length; i++) {
            if (Character.isDigit(cadenaChar[i])) {
                retorno += cadenaChar[i];
            }            
        }
        return retorno;
    }    
    
}
