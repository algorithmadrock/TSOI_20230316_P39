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
		
		String[] equipes = {"Mercedes", "RBR", "Ferrari", "Alpine", "Aston Martin", "AlphaTauri", "Alfa Romeo"}; 
		String[] p1 = {"Lewis Hamilton","Max Verstappen","Charles Leclerc","Esteban Ocon","Lance Stroll","Yuki Tsunoda","Valtteri Bottas"};
		String[] p2 = {"George Russel", "Sergio Perez", "Carlos Sainz", "Pierre Gasly", "Fernando Alonso", "Nyck de Vries", "Guanyu Zhou"};
		
		for (int i = 0; i<7; i++) {
			Thread escuderia = new Escuderia(equipes[i],p1[i], p2[i]);
			escuderia.start();
		}
	}
	

}

