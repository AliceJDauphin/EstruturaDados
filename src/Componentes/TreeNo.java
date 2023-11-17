package Componentes;


public class TreeNo {
	private String Texto;

	private String decisaoEsq;

	private String decisaoDir;

	private TreeNo filhoEsq;
	private TreeNo filhaDir;
	
	public char Event;
	// E = Inimigo // I = Item // T = Armadilha // B = Chefe;
	public int EventAux = -1;
	//Numero auxiliar de evento
	//Construtor Vazio (usado para Root)
	public TreeNo() {
		this.Texto = null;
		this.filhaDir = null;
		this.filhoEsq = null;
	}
	
	//Construtor sem posi��o
	public TreeNo(String dado, String esq, String dir) {
		this.Texto = dado;
		this.decisaoDir = dir;
		this.decisaoEsq = esq;
		this.filhaDir = null;
		this.filhoEsq = null;
	}
	
	 
	
	public String getTexto() {
		return Texto;
	}


	public void setTexto(String texto) {
		this.Texto = texto;
	}


	public String getDecisaoEsq() {
		return decisaoEsq;
	}

	public String getDecisaoDir() {
		return decisaoDir;
	}

	public void setDecisaoDir(String decisaoDir) {
		this.decisaoDir = decisaoDir;
	}

	public void setDecisaoEsq(String decisaoEsq) {
		this.decisaoEsq = decisaoEsq;
	}

	public TreeNo getFilhoEsq() {
		return filhoEsq;
	}


	public void setFilhoEsq(TreeNo filhoEsq) {
		this.filhoEsq = filhoEsq;
	}


	public TreeNo getFilhaDir() {
		return filhaDir;
	}


	public void setFilhaDir(TreeNo filhaDir) {
		this.filhaDir = filhaDir;
	}


	//Criar Filha Direita
	public void createFilhaDir(TreeNo no) {
		if (this.filhaDir != null) {
			System.out.println("Ja possui Filha Direita");
		}else {
			this.filhaDir = no;
		}
	}
	
	
	//Criar Filho Esquerda
	public void createFilhoEsq(TreeNo no) {
		if (this.filhoEsq != null) {
			System.out.println("Ja possui Filho Esquerda");
		}else {
			this.filhoEsq = no;
		}
	}
	
}
