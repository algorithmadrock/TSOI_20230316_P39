/*
RESUMO      : Exercicio da pg.39. Simulação pista de corrida, piloto da escuderia competidora
PROGRAMADORA: Luiza Felix
DATA        : 29/03/2023
 */

package controller;

import java.util.concurrent.Semaphore;

public class Piloto extends Thread {

	private static Semaphore piloto = new Semaphore(1);
	private String nome, equipe;
	private double recorde;
	

	public Piloto(String equipe, String nome) {
		this.nome = nome;
		this.equipe = equipe;
	}
	@Override
	public void run() {
		try {
			piloto.acquire();
			System.err.println(nome + ", piloto da " + equipe + " entrou na pista.");
			corrida();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Ranking ranking = new Ranking(equipe, nome, recorde);	
			piloto.release();
		}
	}

	private void corrida() {

		for (int volta = 1; volta < 3; volta++) {
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
