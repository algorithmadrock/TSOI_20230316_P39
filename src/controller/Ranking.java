/*
RESUMO      : Exercicio da pg.39. Simulação pista de corrida, rankeamento
PROGRAMADORA: Luiza Felix
DATA        : 29/03/2023
 */

package controller;

public class Ranking {
	private static String[][] dados = new String[2][10]; // recorde, equipe e nome
	private static Double[] recorde = new Double[10];
	private static int posicao = 0;

	public Ranking(String equipe, String nome, double recorde) {
//		a cada vez que eu conro isso, preencho a posição e reordeno a lista
		Ranking.recorde[posicao] = recorde;
		Ranking.dados[0][posicao] = equipe;
		Ranking.dados[1][posicao] = nome;

		posicao++;
		

		if (posicao > 9) {
			ordenacao();
			System.err.println("\nCLASSIFICACAO POR VELOCIDADE:");
			for (int i = 0; i < 10; i++) {
				System.out.println((i + 1) + "o. Lugar:" + Ranking.dados[0][i] + " - " + Ranking.dados[1][i] + " (" + Ranking.recorde[i] + " ns.)");
			}
		}
	}

	private void ordenacao() {
		subQUICK(0, 9);
	}

	private void subQUICK(int inicio, int fim) {
		if (inicio < fim) {
			// enquanto o fim for maior que o começo o pivô não estoura e a repartição
			// continua, me baseio no pivô anterior na ordenação
			int pivofixado = pivotQUICK(inicio, fim);
			/* subvetor da esquerda */ subQUICK(inicio, (pivofixado - 1));
			/* subvetor da direita */ subQUICK((pivofixado + 1), fim);
		}
	}

	private int pivotQUICK(int inicio, int fim) {
		/* ponteiro começo-fim */ int red = (inicio + 1);
		/* ponteirofim-começo */ int green = fim;
		while (red <= green) {
			while (red <= green && recorde[red] <= recorde[inicio]) {
//					o vermelho pode estourar o comprimento do vetor se só houverem dados menores que o vetor
				red++;
			}
			while (green >= red && recorde[green] > recorde[inicio]) {
//					se não for especificado esse limite, o código estoura tbm (decrementa para além do 0)
				green--;
			}
			if (red < green) {
//					quando altero a posição dos recordes, altero tbm as dos dados;

				double aux_r = recorde[red];
				String aux_e = dados[0][red];
				String aux_n = dados[1][red];

				recorde[red] = recorde[green];
				dados[0][red] = dados[0][green];
				dados[1][red] = dados[1][green];

				recorde[green] = aux_r;
				dados[0][green] = aux_e;
				dados[1][green] = aux_n;

//					logicamente se eles ainda não se cruzaram eu sigo andando
				red++;
				green--;
			}
		}

//			troca dos valores, determinando o novo pivô (número que ocupava a casa 0), vou para o lugar que minha seta verde parou apontando
		double aux_r = recorde[inicio];
		String aux_e = dados[0][inicio];
		String aux_n = dados[1][inicio];

		recorde[inicio] = recorde[green];
		dados[0][inicio] = dados[0][green];
		dados[1][inicio] = dados[1][green];

		recorde[green] = aux_r;
		dados[0][green] = aux_e;
		dados[1][green] = aux_n;

		return green;
	}
}
