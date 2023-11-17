package Componentes;

public class Item {
	private int vida;
	private int dano;
	private	int defesa;
	private String nome;
	private char tipo;
	//W = arma // H = capacete // C = peitoral // L = calças // 
	

	private int id;
	
	
	public Item(int id, char tipo, String nome, int vida, int dano, int defesa) {
		this.id = id;
		this.nome = nome;
		this.vida = vida;
		this.defesa = defesa;
		this.dano = dano;
		this.tipo = tipo;
	}

	
	

	
	
	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
