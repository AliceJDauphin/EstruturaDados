package Componentes;


public class Inventario {

    private InventarioNo primeiro;

    private InventarioNo Selecionado = new InventarioNo(null, null, null);
    private InventarioNo ultimo;
    private int tamanho;
    private ConsoleColors cor;
    
    public Inventario(){
        primeiro = ultimo = Selecionado = null;
        tamanho = 0;
    }

    public InventarioNo getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(InventarioNo primeiro) {
        this.primeiro = primeiro;
    }

    public InventarioNo getUltimo() {
        return ultimo;
    }

    public void setUltimo(InventarioNo ultimo) {
        this.ultimo = ultimo;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public InventarioNo getInventarioNo(int index) {
        InventarioNo atual = primeiro;
        int contador = 0;

        while (contador < tamanho) {
            atual = atual.getDepois();
            if (atual.getItem().getId() == index) {
            	break;
            }
            contador++;
        }

        return atual;
    }


    public Item inserirPrimeiro(Item item) {
            InventarioNo novoItem = new InventarioNo(item, null, primeiro);
            if (primeiro != null){
                primeiro.setAntes(novoItem);
            }else{
            	Selecionado = novoItem;
                ultimo = novoItem;
            }
            primeiro = novoItem;
            tamanho++;
            return novoItem.getItem();
    }
    
    

    public InventarioNo getSelecionado() {
		return Selecionado;
	}

	public void setSelecionado(InventarioNo selecionado) {
		Selecionado = selecionado;
	}

	public boolean selecionarCima(){
        if (Selecionado == null){
            return false;
        }
        if (Selecionado.getAntes() != null){
            Selecionado = Selecionado.getAntes();
            return true;
        }
        return false;
    }

    public boolean selecionarBaixo(){
        if (Selecionado == null){
            return false;
        }
        if (Selecionado.getDepois() != null){
            Selecionado = Selecionado.getDepois();
            return true;
        }
        return false;
    }
    public void exibir() {
    	InventarioNo aux = primeiro;
    	System.out.println("Seus Itens -------------------------------------------------------------------------" + cor.RESET);
    	if (tamanho > 0) {
    		while(aux != null) {
           		if (Selecionado == aux) {
        			System.out.print( cor.GREEN + "Selecionado --> " + cor.RESET);
        		}
        		System.out.println(aux.getItem().getNome());
        		System.out.println(" Dano : " + cor.CYAN + aux.getItem().getDano() + cor.RESET + " || Defesa : " +  cor.BLUE + aux.getItem().getDefesa() + cor.RESET + " || Vida : " + cor.RED + aux.getItem().getVida() + cor.RESET);
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("------------------------------------------------------------------------------------------");
                aux = aux.getDepois();
            }
    	}else System.out.println(cor.RED + "Você não possui nenhum Item" + cor.RESET);

        System.out.println("=========================================================================================================");

    }

    public void exibirInvertido() {
        InventarioNo aux = ultimo;
        while(aux != null) {
            System.out.println(aux.getItem().getId());
            System.out.println(aux.getItem().getNome());
            System.out.println("--------");
            aux = aux.getAntes();
        }
    }
    
    public Item trocarSelecionado(Item troca) {
    	Item retorno = Selecionado.getItem();
    	if (troca.getTipo() != 'N') {
    		Selecionado.setItem(troca);
    	}else removerSelecionado();
    	
    	
    	return retorno;
    }
    
    public void removerPrimeiro() {
			primeiro = primeiro.getDepois();
			tamanho--;
			if (isEmpty()) {
				ultimo = null;
			} else {
				primeiro.setAntes(null);
			}
	}

    
    public void removerUltimo() {
			ultimo = ultimo.getAntes();
			tamanho--;
			if (isEmpty()) {
				primeiro = null;
			} else {
				ultimo.setDepois(null);
			}
	}
    
    public Item removerSelecionado(){
        Item retorno;
        if (Selecionado.getAntes() == null) {
            retorno = primeiro.getItem();
            removerPrimeiro();
        } else if (Selecionado.getDepois() == null) {
        	retorno = ultimo.getItem();
        	removerUltimo();
        } else {
            InventarioNo atual = getInventarioNo(Selecionado.getItem().getId());
            retorno = atual.getItem();
            InventarioNo anterior = atual.getAntes();
            InventarioNo proximo = atual.getDepois();

            anterior.setDepois(proximo);
            proximo.setAntes(anterior);
            tamanho--;
        }

        if (primeiro != null) {
        	Selecionado = primeiro;
        }
        
            
        return retorno;
    }
}
