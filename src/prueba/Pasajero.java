/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author Fernando Iraira <fmiraira@gmail.com>
 */
public class Pasajero implements Runnable {

    private Compartido referencia;

    public Pasajero(Compartido referencia) {
        this.referencia = referencia;
    }

    public void run() {
        this.referencia.entrar(this);
        System.out.println(Thread.currentThread().getName() + " TERMINO SU EJECUCION");
    }
}
