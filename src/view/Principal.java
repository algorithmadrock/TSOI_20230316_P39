/*
RESUMO      : Exercicio da pg.39. Simulação pista de corrida, execução da corrida
PROGRAMADORA: Luiza Felix
DATA        : 29/03/2023
 */

package view;

import javax.swing.JOptionPane;

import controller.Escuderia;

public class Principal {
	public static void main(String[] args) {
		int iniciar = 0;
		do {
			iniciar = JOptionPane.showConfirmDialog(null, "DADOS DA CORRIDA:\n    Pista Fuji Speedway Oyama Japão (4563km)\n    Velocidade Mínima: 260 km/h (baseada na média de uma corrida na Itália)\n    Velocidade Máxima: 340 km/h (baseada na velocidade oficial do Relâmpago Mcqueen)\n\n **A corrida só será iniciada após CONFIRMAÇÃO.");
		} while(iniciar!=0);
		iniciar();
		
	}

	private static void iniciar() {
		Thread Mercedes = new Escuderia("Mercedes", "Lewis Hamilton", "George Russel");
		Thread RBR = new Escuderia("RBR", "Max Verstappen", "Sergio Perez");
		Thread Ferrari = new Escuderia("Ferrari", "Charles Leclerc", "Carlos Sainz");
		Thread Alpine = new Escuderia("Alpine", "Esteban Ocon", "Pierre Gasly");
		Thread AstonMartin = new Escuderia("Aston Martin", "Lance Stroll", "Fernando Alonso");
		Thread AlphaTauri = new Escuderia("AlphaTauri", "Yuki Tsunoda", "Nyck de Vries");
		Thread AlfaRomeo  = new Escuderia("Alfa Romeo", "Valtteri Bottas", "Guanyu Zhou");

		Mercedes.start();
		RBR.start();
		Ferrari.start();
		Alpine.start();
		AstonMartin.start();
		AlphaTauri.start();
		AlfaRomeo.start();

	}
	

}

