public class Fila {
    NoFila inicio;
    NoFila fim;
    
    public boolean vazia() {
        return inicio == null;
    }
    
    public void enfileirar(No valor) {
        NoFila novo = new NoFila(valor);
        if (vazia()) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }
    
    public NoFila desenFileirar() {
        if (vazia()) {
            System.out.println("\nFila vazia!");
            return null;
        }       
        NoFila removido = inicio;
        inicio = inicio.proximo;
        
        if (inicio == null)
            fim = null;
            
        return removido;
    }
    
    public void imprimir() {
        NoFila atual = inicio;
        System.out.println();
        while (atual != null) {
            System.out.print(atual.dado+" -> ");
            atual = atual.proximo;
        }
    }
}