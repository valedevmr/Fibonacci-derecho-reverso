/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibo;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String... argumentos) {

        SerieFibonacci ObjFibo = new SerieFibonacci();
        Fibonacci.pedirDatos(ObjFibo);

    }

    public static void pedirDatos(SerieFibonacci ObjFibo) {

        try {
            //si lo que se ingresa es diferente a un entero se captura la excepcion
            //y se ejecuta la linea 54 usando recursividad para ejecutar nuevamente la funcion pedirDatos()
            int opcion;
            System.out.println("Serie Fibonacci al derecho y al revés\nDihite 1 - para ingresar limite\nDigite 2 - limite aleatorio\n");
            opcion = new Scanner(System.in).nextInt();
            //si la opcion es valida a 1 el usuario podra ingresar el numero a limite de la serie fibonacci
            if (opcion == 1) {
                try {
                    //el try atrapa la excepcion en caso de no ingresar un numero mayor a cero o no entero
                    Scanner entradaDatos = new Scanner(System.in);
                    int limitefibonacci = 0;

                    System.out.print("Ingresa limite\t");
                    limitefibonacci = entradaDatos.nextInt();

                    if (limitefibonacci > 0) {
                        ObjFibo.fibonaccii(limitefibonacci, "Introducido por el usuario");
                    } else {
                        System.out.println("valor no valido");
                        pedirDatos(ObjFibo);

                    }

                } catch (Exception e) {
                    System.out.println("valor no valido");
                    pedirDatos(ObjFibo);
                }
            } //si la opcion es 2 entonces el progrma acalcular un numero aleatorio para que se el limite de la serie fibonacci
            else if (opcion == 2) {
                ObjFibo.fibonaccii(Fibonacci.obtenerSemilla(), "aleatorio");
            } //si la opcion no es 1 o 2 vuelve a ejecutar la funcion pedirDatos()
            else {
                System.out.println("\nOpción no valida, intente nuevamente"
                        + "");
                pedirDatos(ObjFibo);
            }

        } catch (Exception e) {
            System.out.println("\nOpción no valida, intente nuevamente");
            pedirDatos(ObjFibo);
        }

    }

    public static int obtenerSemilla() {
        Random numeroAl = new Random();
        int numero = numeroAl.nextInt(2000);
        if (numero > 1) {
            return numero;
        } else {
            return 1;
        }
    }

}

//Clase encargada de generar la serie de Fibonnaci
class SerieFibonacci {

    private int numeroActual;
    private int limite;
    private int temporal;

    public SerieFibonacci() {
        this.numeroActual = 1;
        this.temporal = 0;
        this.limite = 0;
    }

    //metodo para Gnerar Serie de Fibonacci, recibe como parametro el numero del limite a calcular 
    public void fibonaccii(int limite, String tipo) {
        //asignamos el valor del limite añ atributo limite
        this.limite = limite;
        int contador = 0;
        //declaramos una variable de tipo arraylist para guardar la serie fibonacci alderecho y al revés
        ArrayList arrayFibonacci = new ArrayList();

        System.out.println("Serie Fibonacci con limite de valor " + tipo + " :" + this.limite);
        //aui esta la lógica para la generacion de la serie.
        //el numero actual en si sera el contador ya que este ira cambiando en el trascurso del recorrido 
        //de los numero hasta llegtar al limite
        for (contador = 0; contador < limite; contador = temporal) {
            temporal = numeroActual;
            numeroActual = contador + numeroActual;
            //guardamos el numero actual dentro del aregllo arrayFibonacci
            arrayFibonacci.add(contador);
        }
        //recorremos el numero total de elementos que contiene el arraylist de nombre arrayFibonacci de manera inversa
        //con el fin de agregar al mismo areglo con los elementos inversos
        for (contador = arrayFibonacci.size() - 2; contador >= 0; contador--) {
            arrayFibonacci.add(arrayFibonacci.get(contador));
        }
        //Recorremos todo los elementos del array para imprimnir la serie fibonacci al derecho y al revés
        for (contador = 0; contador < arrayFibonacci.size(); contador++) {
            System.out.print(arrayFibonacci.get(contador) + " ");
        }
        System.out.println("");

    }

}
