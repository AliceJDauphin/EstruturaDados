package Componentes;

public class Criatura extends Personagem{

	private int id;
	
	
	public Criatura(String nome, int vida, int dano, int defesa, int id){
		super(nome, vida, dano, defesa);
		this.id = id;
	}

	public Criatura(Criatura criatura) {
		super(criatura.getNome(), criatura.getVidaMaxima(), criatura.getDano(), criatura.getDefesaMaxima());
		criatura.getId();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
