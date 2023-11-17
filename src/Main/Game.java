package Main;

import Componentes.*;

import java.sql.SQLOutput;
import java.util.*;
public class Game {
	public static void main(String[] arg) {
		
		//Inicializando objetos
		ConsoleColors cor = new ConsoleColors();
		Scanner ler = new Scanner(System.in);
		System.out.println(cor.GREEN_BOLD_BRIGHT + "Digite SEU nome :) ");

		String jogadorNome = ler.next();
		
		//Inicializando Campanha (arvore);
		Tree campanha = new Tree();
		campanha.iniciar(jogadorNome);
		
		
		Jogador player = new Jogador(jogadorNome);
		Bestiario bestiario = new Bestiario();
		Catalogo catalogo = new Catalogo();
		
		
		//Bestiario de Inimigos
		bestiario.adicionar(new Criatura("Marcio Reverso", 10, 3, 5, 0));
		bestiario.adicionar(new Criatura("Muralha", 15, 2, 5, 1));
		bestiario.adicionar(new Criatura("Cabelo Curto", 5, 3, 10, 2));
		bestiario.adicionar(new Criatura("Ladrao de Motos", 10, 3, 0, 3));
		bestiario.adicionar(new Criatura("Cornelio ,O cafetão", 30, 8, 20, 4));
		//Catalogo de Items
		catalogo.adicionar(new Item(0, 'W', "Peixeira da Cabelo Curto", 0, 3, 1));
		catalogo.adicionar(new Item(1, 'W', "Dedo do Meio", 5, 6, 4));
		catalogo.adicionar(new Item(2, 'P', "Hamburgão do Muralha", 5, 0, 10));
		catalogo.adicionar(new Item(3, 'H', "Capacete do Carlinhos", 5, 0, 5));



		Criatura enemy = new Criatura(bestiario.getNo(0).getCriatura());
		enemy.setVida(0);
		
		
		System.out.println(cor.YELLOW + "Use o Terminal para escolher sua Ação : \n" + cor.BLUE_UNDERLINED + "1 para Esquerda\n" + cor.RED_UNDERLINED + "2 para Direita\n" + cor.GREEN_UNDERLINED + "3 para Abrir Inventario" + cor.RESET);

		//Jogador vivo (Jogando)
		while(player.getVida() > 0 && !campanha.GameOver()) {
			
			switch(campanha.atual.Event) {
			case('E'):
				
				if (campanha.atual.EventAux != -1) {
					enemy = new Criatura(bestiario.getNo(campanha.atual.EventAux).getCriatura());	
				}else {
					enemy = new Criatura(bestiario.getNo(enemy.getRandomInt(4)).getCriatura());	
				}

				System.out.println(cor.RED + enemy.getNome() + cor.RESET + " selvagem apareceu :");
				System.out.println("Vida : " + cor.RED + enemy.getVida() + cor.RESET + "\nDefesa : " + cor.BLUE + enemy.getDefesa() + cor.RESET + "\nDano : " + cor.CYAN + enemy.getDano() + cor.RESET);


				//Enemigo vivo 
				while(enemy.getVida() > 0) {
					boolean defende = false;
					boolean defendeInimigo = false;
					boolean fugiu = false;
					System.out.println(cor.BLUE + "Atacar" + cor.RESET + "|||" + cor.RED + "Fugir" + cor.RESET + "(10%)");
					
					
					switch(ler.next()) {
						case("1"):
							System.out.println(player.getNome() + " Atacou : " + cor.RED + enemy.getNome() + cor.RESET);
							player.atacar(enemy, defendeInimigo);
							break;
							
						case("2"):
							if (player.getRandomInt(10) > 8) {
								System.out.println("Você fugiu, cagão!!!");
								fugiu = true;
							}else System.out.println("Falhou ao tentar fugir, tem dificuldade em tudo Mds....");
							break;
					}
					if (fugiu) break;

					System.out.println(cor.RED + enemy.getNome() + cor.RESET + " Atacou : " + player.getNome());


					enemy.atacar(player, defende);

					System.out.println("----------------------------------" + cor.RESET);
					System.out.println("Vida do " + enemy.getNome() + " : " + cor.RED +  enemy.getVida() + "/" + enemy.getVidaMaxima()  + cor.RESET +  "\nDefesa do " + enemy.getNome() + " : " + cor.BLUE + enemy.getDefesa() + cor.RESET + "\nDano : " + cor.GREEN + enemy.getDano() + cor.RESET);

					System.out.println("----------------------------------" + cor.RESET);

					System.out.println("Sua vida : " + cor.RED + player.getVida() + "/" + player.getVidaMaxima() + cor.RESET + "\nSua defesa : " + cor.BLUE + player.getDefesa() + cor.RESET +"\nSeu dano : " + cor.GREEN + player.getDano() + cor.RESET);
					
					if (player.getVida() < 0) {
						System.out.println(enemy.getNome() + " Desceu o K7 em você");
						break;
					}
					if (enemy.getVida() <= 0) {
						System.out.println("Desceu o C7 em " + enemy.getNome());
					}
				}
				if (player.getVida() > 0) {	
					if (player.getVida() >= player.getVidaMaxima()/2) {
						System.out.println("Você descansou após a batalha, recuperou toda sua vida");
						player.setVida(player.getVidaMaxima());
					}else {
						System.out.println("Você descansou após a batalha, recuperou parte de sua vida");
						player.setVida(player.getVidaMaxima()/2);
					}
				}
					player.setDefesa(player.getDefesaMaxima());
					
				campanha.atual.Event = 'N';
				break;
			case('I'):
				if (campanha.atual.EventAux != -1) {
					System.out.println(cor.GREEN_UNDERLINED + "Você recebeu um(a) : " + player.inventario.inserirPrimeiro(catalogo.getNo(campanha.atual.EventAux).getItem()).getNome() + cor.RESET);
				}else System.out.println("Você recebeu um(a) : " + player.inventario.inserirPrimeiro(catalogo.getNo(player.getRandomInt(catalogo.getSize())).getItem()).getNome());
				campanha.atual.Event = 'N';
				break;
			case('T'):
				if (campanha.atual.EventAux != -1) {
					System.out.println("Por conta de Sua ação, recebeu " + player.danoInstantaneo(campanha.atual.EventAux) + " de dano");
				}else System.out.println("Por conta de Sua ação, recebeu " + player.danoInstantaneo(10) + " de dano");
				campanha.atual.Event = 'N';
				break;
			case('B'):
				break;
			}
			
			//Game Over por zerar Vida
			if (player.getVida() < 0) {
				break;
			}
			
				System.out.println(campanha.atual.getTexto());
				
				System.out.println(cor.BLUE + campanha.atual.getDecisaoEsq() + "\n" + cor.RED + campanha.atual.getDecisaoDir() + cor.RESET + "\n Abrir Inventario...");
			switch(ler.next()) {
			case("1"):
				campanha.goLeft();
				break;
			case("2"):
				campanha.goRight();
				break;
			case("3"):
				String fecharInventario = "4";
				boolean fechar = false;
				player.Inventario();
				while(!fechar) {

					System.out.println(cor.BLUE + "Selecionar Cima\n" + cor.RED + "Selecinar Baixo\n" + cor.GREEN + "Usar/Equipar Selecionado\n"+ cor.RESET + "'0' para fechar inventario");
					System.out.println("----");
					if (!fechar) {
						fecharInventario = ler.next();
					}
					switch(fecharInventario) {
					
					case("1"):
						player.inventario.selecionarCima();
						player.Inventario();
						break;
					case("2"):
						player.inventario.selecionarBaixo();
						player.Inventario();
						break;
					case("3"):
						player.equipar();
						player.Inventario();
						break;
					case("0"):
						fechar = !fechar;
						break;
					}
					
				}
				break;
			}
			
		}
				
		System.out.println(cor.RED + "Game over");
		
	}
	
}
