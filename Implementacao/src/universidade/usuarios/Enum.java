package universidade.usuarios;

public enum Enum{
    Usuario("U"), Aluno("A"), Professor("P"), Secretaria("S");
    private String tipo;

    Enum(String tipo){
        this.tipo=tipo;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean equal(Enum e){
        return this.tipo.equals(e.getTipo());
    }
}