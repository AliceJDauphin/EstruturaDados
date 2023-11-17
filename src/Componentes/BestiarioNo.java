package Componentes;

public class BestiarioNo {
    private Criatura criatura;
    private BestiarioNo antes;
    private BestiarioNo depois;


    public BestiarioNo(Criatura criatura, BestiarioNo antes, BestiarioNo depois) {
        this.criatura = criatura;
        this.antes = antes;
        this.depois = depois;
    }

    public Criatura getCriatura() {
        return criatura;
    }

    public void setCriatura(Criatura criatura) {
        this.criatura = criatura;
    }

    public BestiarioNo getAntes() {
        return antes;
    }

    public void setAntes(BestiarioNo antes) {
        this.antes = antes;
    }

    public BestiarioNo getDepois() {
        return depois;
    }

    public void setDepois(BestiarioNo depois) {
        this.depois = depois;
    }
}
