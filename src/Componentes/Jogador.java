package Componentes;

public class Jogador extends Personagem{
	
	public Inventario inventario;
	private Item capacete = new Item(-1, 'N', "Nada", 0, 0,0);
	private Item peitoral = new Item(-1, 'N', "Nada", 0, 0,0);
	private Item pernas = new Item(-1, 'N', "Nada", 0, 0,0);
	private Item arma = new Item(-1, 'N', "Nada", 0, 0,0);
	private int vidaBase = this.getVidaMaxima();
	private int danoBase = this.getDano();
	private int defesaBase = this.getDefesa();
	public Jogador(String nome) {
		super(nome);
		this.inventario = new Inventario();
		// TODO Auto-generated constructor stub
	}
	
	public void Inventario() {
		System.out.println("Item de Cabeca : " + cor.GREEN + capacete.getNome() + cor.RESET + " || Defesa : " + cor.BLUE+ capacete.getDefesa() + cor.RESET+ " || Vida : " + cor.RED + capacete.getVida() + cor.RESET);
		System.out.println("Item de Corpo : " + cor.GREEN + peitoral.getNome() + cor.RESET + " || Defesa : " + cor.BLUE+ peitoral.getDefesa() + cor.RESET+ " || Vida : " + cor.RED + peitoral.getVida() + cor.RESET);
		System.out.println("Item das Pernas : " + cor.GREEN + pernas.getNome() + cor.RESET + " || Defesa : " + cor.BLUE+ pernas.getDefesa() + cor.RESET+ " || Vida : " + cor.RED + pernas.getVida() + cor.RESET);
		System.out.println("Armamento : " + cor.GREEN +arma.getNome() + cor.RESET + " || Dano : " + cor.CYAN + arma.getDano() + cor.RESET + " || Defesa : " + cor.BLUE + arma.getDefesa() + cor.RESET);
		System.out.println("=========================================================================================================");
		System.out.println(this.getNome() + " -- Vida = " + cor.RED + this.getVida() + "/" + this.getVidaMaxima() + cor.RESET + " || Dano = " + cor.CYAN + this.getDano() + cor.RESET + " || Defesa = " + cor.BLUE + this.getDefesa() + cor.RESET);
		inventario.exibir();
	}
	
	public int danoInstantaneo(int dano) {
		this.setVida(this.getVida() - dano);
		return dano;
	}
	
	public void equipar() {
		if(inventario.getSelecionado() != null) {
			switch (inventario.getSelecionado().getItem().getTipo()) {
				case ('H'):
					this.capacete = inventario.trocarSelecionado(capacete);
					this.setDefesa(defesaBase + capacete.getDefesa());
					this.setVidaMaxima(vidaBase + capacete.getVida());
					System.out.println("Equipou : " + capacete.getNome());
					break;
				case ('C'):
					this.peitoral = inventario.trocarSelecionado(peitoral);
					this.setDefesa(defesaBase + peitoral.getDefesa());
					this.setVidaMaxima(vidaBase + peitoral.getVida());
					System.out.println("Equipou : " + peitoral.getNome());
					break;
				case ('L'):
					this.pernas = inventario.trocarSelecionado(pernas);
					this.setDefesa(defesaBase + pernas.getDefesa());
					this.setVidaMaxima(vidaBase + pernas.getVida());
					System.out.println("Equipou : " + pernas.getNome());
					break;
				case ('W'):
					this.arma = inventario.trocarSelecionado(arma);
					this.setDano(danoBase + arma.getDano());
					this.setDefesa(defesaBase + arma.getDefesa());
					this.setVidaMaxima(vidaBase + arma.getVida());
					System.out.println("Equipou : " + arma.getNome());
					break;
				case ('P'):
					danoBase += inventario.getSelecionado().getItem().getDano();
					defesaBase += inventario.getSelecionado().getItem().getDefesa();
					vidaBase += inventario.getSelecionado().getItem().getVida();
					System.out.println("Consumiu : " + inventario.getSelecionado().getItem().getNome());
					inventario.removerSelecionado();
					break;
			}
			this.setVidaMaxima( vidaBase + capacete.getVida() + peitoral.getVida() + pernas.getVida() + arma.getVida());
			this.setVida(this.getVidaMaxima());
			this.setDefesa( defesaBase + capacete.getDefesa() + peitoral.getDefesa() + pernas.getDefesa() + arma.getDefesa());
			this.setDano( danoBase + capacete.getDano() + peitoral.getDano() + pernas.getDano() + arma.getDano());
		}
	}
}
