/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 *
 * @author Fernando Iraira <fmiraira@gmail.com>
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int cantPasajeros = 25;
        int capacidadCentro = 4;

        Compartido centro = new Compartido(capacidadCentro);

        for (int i = 1; i <= cantPasajeros; i++) {
            Pasajero p = new Pasajero(centro);
            Thread pasajero = new Thread(p, "Pasajero " + i);
            pasajero.start();
        }

        Recepcionista r = new Recepcionista(centro);
        Thread recepcionista = new Thread(r, "RECEPCIONISTA");
        recepcionista.start();

    }

}
