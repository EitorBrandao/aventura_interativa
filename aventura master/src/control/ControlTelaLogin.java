package control;

import entity.Jogador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControlTelaLogin {

	private List<Jogador> listaJogador = new ArrayList<>();

	public Jogador login(String nome) {

		for (Jogador jogador : listaJogador) {
			if (jogador.getNome().contains(nome)) { 
				return jogador;

				// System.out.println (jogador.getNome ());
				// System.out.println (jogador.getSenha ());
			}
		}
		return null;
	}

	public void cadastrar(Jogador jogador) {
		listaJogador.add(jogador);
		System.out.println("Jogador Cadastrado");

		for (Iterator<Jogador> iter = listaJogador.iterator(); iter.hasNext();) {
			Jogador jogadorAtual = iter.next();
			System.out.println(jogadorAtual.getNome());
		}

	}

}