package controller;

import br.com.serialexperimentscarina.listaobject.ListaObject;
import model.Musica;

public class PlayerController {
	
	public PlayerController() {
		super();
	}
	
	// Recebe uma String no formato: Nome_da_musica;nome_artista;duracao (obrigatoriamente dessa forma), 
	// faz o split e grava em um objeto Musica e, se a lista estiver vazia, adiciona na primeira posição. 
	// A partir do segundo elemento, todas as outras músicas devem entrar no final da lista
	public void adicionaMusica(ListaObject lista, String musica) throws Exception {
		String[] vet = musica.split(";");
		
		Musica novaMusica = new Musica();
		novaMusica.nome = vet[0];
		novaMusica.nomeArtista = vet[1];
		novaMusica.duracao = Integer.parseInt(vet[2]);
		
		// A implementação da biblioteca adicionará ao inicio por si só, caso a lista esteja vazia
		lista.addLast(novaMusica);
	}
	
	// Permite que o usuário remova qualquer música da lista.
	public void removeMusica(ListaObject lista, int pos) throws Exception {
		// Se a lista estiver vazia, uma exceção deve ser mostrada
		if (lista.isEmpty()) {
			throw new Exception("Playlist vazia!");
		}
		if (lista.size() < pos || pos < 0) {
			throw new Exception("Posição de música inválida!");
		}
		
		lista.remove(pos - 1);
	}
	
	// Exibirá, do primeiro ao último elemento, no formato [Música: nome da música – Artista: nome artista – Duração: duracao].
	public void executaPlaylist(ListaObject lista) throws Exception {
		// Se a lista estiver vazia, uma exceção deve ser mostrada
		if (lista.isEmpty()) {
			throw new Exception("Playlist vazia!");
		}
		
		System.out.println("Executando playlist");
		for (int i = 0; i < lista.size(); i++) {
			Musica musica = (Musica) lista.get(i);
			System.out.println("Tocando agora: ");
			System.out.println(musica);
			
			Thread.sleep(musica.duracao * 1000);
		}
		
		System.out.println("Fim da playlist!");
	}
	
	

}
