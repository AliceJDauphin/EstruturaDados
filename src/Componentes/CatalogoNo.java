package Componentes;

public class CatalogoNo {
    private Item item;
    private CatalogoNo antes;
    private CatalogoNo depois;


    public CatalogoNo(Item item, CatalogoNo antes, CatalogoNo depois) {
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

    public CatalogoNo getAntes() {
        return antes;
    }

    public void setAntes(CatalogoNo antes) {
        this.antes = antes;
    }

    public CatalogoNo getDepois() {
        return depois;
    }

    public void setDepois(CatalogoNo depois) {
        this.depois = depois;
    }
}
