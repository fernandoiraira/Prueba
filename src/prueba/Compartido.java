/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Fernando Iraira <fmiraira@gmail.com>
 */
public class Compartido {

    private int limitePasajeros;
    private BlockingQueue bloque;
    private Semaphore semAtencion = new Semaphore(0);
    private Semaphore semSalir = new Semaphore(0);

    public Compartido(int limitePasajeros) {
        this.limitePasajeros = limitePasajeros;
        bloque = new ArrayBlockingQueue(limitePasajeros);
    }

    public void entrar(Pasajero p) {
        try {
            this.bloque.put(p);
            System.out.println(Thread.currentThread().getName() + " entro al centro.");
            this.semAtencion.release();
            this.semSalir.acquire();

        } catch (Exception e) {
        }
    }

    public void atender() {
        try {
            this.semAtencion.acquire();
        } catch (Exception e) {
        }

        System.out.println(Thread.currentThread().getName() + " esta atendiendo a un pasajero...");
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " termino de atender al pasajero.");

            this.semSalir.release();
            this.bloque.take();
        } catch (Exception e) {
        }

    }

}
