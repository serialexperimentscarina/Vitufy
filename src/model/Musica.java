package model;

public class Musica {
	
	public String nome;
	public String nomeArtista;
	public int duracao;
	
	public Musica() {
		super();
	}
	
	@Override
	public String toString() {
		return("[Música: " + nome + " - Artista: " + nomeArtista + " - Duração: " + String.format("%02d", (duracao/60)) + ":" + String.format("%02d", (duracao % 60)) + "]");
	}

}
