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
public class Recepcionista implements Runnable {

    private Compartido referencia;

    public Recepcionista(Compartido ref) {
        this.referencia = ref;
    }

    public void run() {
        while (true) {
            this.referencia.atender();
        }
    }
}
