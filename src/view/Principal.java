package view;

import javax.swing.JOptionPane;

import br.com.serialexperimentscarina.listaobject.ListaObject;
import controller.PlayerController;
import model.Musica;

public class Principal {

	public static void main(String[] args) {
		
		ListaObject playlist = new ListaObject();
		PlayerController player = new PlayerController();
		String input;
		
		do {
			// Oferece ao usuário a opção de inserir ou remover músicas na playlist e executar a playlist.
			input = JOptionPane.showInputDialog("MENU: \n1 - Adicionar música \n2 - Remover música \n3 - Executar playlist \n4 - Sair", "");
			if (input == null) {
				JOptionPane.showMessageDialog(null, "Encerrando.");
				System.exit(0);
			} else {
				switch (input) {
				// No caso da inserção de músicas, deve-se pedir, ao usuário, que digite separadamente cada campo e monte uma String que será mandada ao método adicionaMusica na classe PlayerController.
				case("1"):
					StringBuffer musica = new StringBuffer();
					musica.append(JOptionPane.showInputDialog("Digite o nome da música: ", "Música sem nome") + ";");
					musica.append(JOptionPane.showInputDialog("Digite o artista da música: ", "Música sem artista") + ";");
					musica.append(JOptionPane.showInputDialog("Digite a duração da musica (Em segundos): ", "0") + ";");
					try {
						player.adicionaMusica(playlist, musica.toString());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar adicionar a música", "Erro", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					break;
				case("2"):
					if (!playlist.isEmpty()) {
						try {
							StringBuffer listaDeMusicas = new StringBuffer("Escolha a música que deseja excluir: ");
							for (int i = 0; i < playlist.size(); i++) {
								listaDeMusicas.append("\n" + (i + 1) + " - " + ((Musica) playlist.get(i)).toString());
							}
							player.removeMusica(playlist, Integer.parseInt(JOptionPane.showInputDialog(listaDeMusicas)));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar excluir a música", "Erro", JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Playlist vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					break;
				case("3"):
					try {
						player.executaPlaylist(playlist);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar executar a playlist", "Erro", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					break;
				case("4"):
					JOptionPane.showMessageDialog(null, "Encerrando.");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção não reconhecida", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		} while (!input.equals("4"));
		

	}

}
