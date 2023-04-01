/*
RESUMO      : Exercicio da pg.39 - Simulação de uma corrida F1, base de todas as escuderias
PROGRAMADORA: Luiza Felix
DATA        : 29/03/2023
 */

package controller;

import java.util.concurrent.Semaphore;

public class Escuderia extends Thread {

	private String equipe, p1, p2;
	private static Semaphore competidoras = new Semaphore(5);
	public Escuderia( String equipe,String p1,String p2) {
		this.equipe = equipe;
		this.p1 = p1;
		this.p2 = p2;
}
	@Override
	public void run() {
//		só inicializo as 5 competidoras
		try {
			competidoras.acquireUninterruptibly();
			System.out.println(equipe + " entrou na corrida!");
//			só inicializo os pilotos se eles forrem correr
			Thread pilotos = new Pilotos(equipe, p1, p2);
			pilotos.start();
		} finally {
			
		}
	}

}
