package Componentes;

public abstract class Personagem {
	private String nome;
	private int vidaMaxima;
	private int vida;
	private int dano;
	private int defesa;
	private int defesaMaxima;
	private int prioridade;
	
	ConsoleColors cor;
	public Personagem(String nome) {
		this.nome = nome;
		this.vidaMaxima = 10;
		this.vida = vidaMaxima;
		this.defesaMaxima = 2;
		this.dano = 5;
		this.defesa = 2;
	}
	
	public Personagem(String nome, int vida, int dano, int defesa) {
		this.nome = nome;
		this.dano = dano;
		this.vidaMaxima = vida;
		this.vida = vida;
		this.defesaMaxima = defesa;
		this.defesa = defesa;
	}
	
	
	
	public int getRandomInt(int max) {
			double num = (Math.floor(Math.random() * max));
			
		  return (int)num;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDano() {
		return dano;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
	public int getDefesaMaxima() {
		return defesaMaxima;
	}

	public void setDefesaMaxima(int defesaMaxima) {
		this.defesaMaxima = defesaMaxima;
	}
	
	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	
	
	public void atacar(Personagem pessoa, boolean defende) {
		int ataque = this.dano;
		if (defende) {
			ataque = this.dano/2;
		}
		if (pessoa.defesa > 0) {
			double ataqueNaDefesa = (ataque * 0.85);
			double ataqueNaVida = (ataque * 0.25);
			
			pessoa.defesa -= Math.floor(ataqueNaDefesa);
			pessoa.vida -= Math.floor(ataqueNaVida);
			System.out.print(cor.RED_BOLD + " ataque direto : " + ataqueNaVida + cor.RESET + "\t");
			System.out.println(cor.BLUE_BOLD + " ataque no escudo : " + ataqueNaDefesa + cor.RESET);
		}else {
			System.out.println(cor.RED_BOLD + " ataque direto : " + this.dano + cor.RESET);
			pessoa.vida -= this.dano;
		}
	}
	
	public boolean defender() {
		return true;
	}
	
	public void equipar() {
		//equipar arma ou armadura;
	}
}
