class No {
    int dado;
    No esquerda;
    No direita;
    No (int dado) {
        this.dado = dado;
        esquerda = null;
        direita = null;
    }
    @Override
    public String toString() {
        return "[No:"+dado+ " E->"+( (esquerda != null) ? esquerda.dado : "") + " D->"+( (direita != null) ? direita.dado : "")+"]" ;
    }
}