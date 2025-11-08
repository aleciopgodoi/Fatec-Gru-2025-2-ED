class MainArvoreFila {
	public static void main(String[] args) {

		Arvore arvore = new Arvore();
		//System.out.println("Vazia: " + goiabeiraMaraviosa.vazia());

		arvore.inserir(20);
		arvore.inserir(30);
		arvore.inserir(15);
		arvore.inserir(19);
		arvore.inserir(2);
		arvore.inserir(25);
		arvore.inserir(40);
		
		arvore.imprimirPreOrdem(arvore.raiz);
		
		arvore.imprimirNiveis();
		

	}
}