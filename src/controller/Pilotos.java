/*
RESUMO      : Exercicio da pg.39. Simulação pista de corrida, piloto da escuderia competidora
PROGRAMADORA: Luiza Felix
DATA        : 29/03/2023
 */

package controller;

import java.util.concurrent.Semaphore;

public class Pilotos extends Thread {

	
	private String p1, p2, equipe;
	private double recorde;
	private Semaphore corredor = new Semaphore(1);

	public Pilotos(String equipe, String p1, String p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.equipe = equipe;
	}
	@Override
	public void run() {
			
			System.err.println(p1 + ", piloto da " + equipe + " entrou na pista.");
			corrida(p1);
			
			
			System.err.println(p2 + ", piloto da " + equipe + " entrou na pista.");
			corrida(p2);
			
	
	}

	private void corrida(String nome) {

		for (int volta = 1; volta <= 3; volta++) {
			int correu = 0;

			long inicio = System.nanoTime();
			while (correu < 4563) {
				correu += Math.random() * 81 + 260;
//				velocidade "média" de uma corrida normal à velocidade do Relâmpago Mcqueen
			}
			long fim = System.nanoTime();

			int tempo = (int) (fim - inicio);
			recorde(volta, tempo);

			System.out.println(nome + " da " + equipe + " : " + volta + "a. " + tempo + "ns.");

		}
		new Ranking(equipe, nome, recorde);
		
	}

	private void recorde(int volta, int tempo) {
		if (volta == 1) {
			recorde = tempo;
		}
		if (tempo < recorde) {
			recorde = tempo;
		}
	}

	

}
