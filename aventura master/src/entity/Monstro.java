package entity;

public class Monstro {

    private int id;
    private String nome;
    private int energia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia=energia;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade=habilidade;
    }

    private int habilidade;
}
