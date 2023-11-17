package Componentes;

public class InventarioNo {
    private Item item;
    private InventarioNo antes;
    private InventarioNo depois;


    public InventarioNo(Item item, InventarioNo antes, InventarioNo depois) {
        this.item = item;
        this.antes = antes;
        this.depois = depois;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public InventarioNo getAntes() {
        return antes;
    }

    public void setAntes(InventarioNo antes) {
        this.antes = antes;
    }

    public InventarioNo getDepois() {
        return depois;
    }

    public void setDepois(InventarioNo depois) {
        this.depois = depois;
    }
}
