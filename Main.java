class Main {
	public static void main(String[] args) {
		//No no1 = new No(5);
		//System.out.println("no1 -> "+no1.dado);
		//no1.esquerda = new No(3);
		//no1.direita = new No(7);
		//System.out.println("esquerda no1 -> "+no1.esquerda.dado);
		//System.out.println("direita no1 -> "+no1.direita.dado);

		Arvore goiabeiraMaraviosa = new Arvore();
		//System.out.println("Vazia: " + goiabeiraMaraviosa.vazia());

		goiabeiraMaraviosa.inserir(20);

		goiabeiraMaraviosa.inserir(30);
		goiabeiraMaraviosa.inserir(15);
		goiabeiraMaraviosa.inserir(2);
/*		goiabeiraMaraviosa.inserir(1);
		goiabeiraMaraviosa.inserir(0);
		goiabeiraMaraviosa.inserir(25);
		goiabeiraMaraviosa.inserir(40); 
		goiabeiraMaraviosa.imprimirPreOrdem(goiabeiraMaraviosa.raiz);
		System.out.println();
		goiabeiraMaraviosa.imprimirEmOrdem(goiabeiraMaraviosa.raiz);
		System.out.println();
		goiabeiraMaraviosa.imprimirEmOrdemDesc(goiabeiraMaraviosa.raiz);
		System.out.println();
		goiabeiraMaraviosa.imprimirPosOrdem(goiabeiraMaraviosa.raiz);
		//System.out.println(goiabeiraMaraviosa.raiz);
		//System.out.println(goiabeiraMaraviosa.raiz.esquerda);
		//System.out.println(goiabeiraMaraviosa.raiz.direita);

		int valorBuscado = 15;
		No auxiliar = goiabeiraMaraviosa.buscar(goiabeiraMaraviosa.raiz, valorBuscado);
		System.out.println();
		if (auxiliar == null)
			System.out.println(valorBuscado+ " - NC#o encontrado!");
		else
			System.out.println("Encontrado: "+auxiliar);
		System.out.println("Total de Nos: "+goiabeiraMaraviosa.contar(goiabeiraMaraviosa.raiz));

		System.out.println("Altura: "+goiabeiraMaraviosa.altura(goiabeiraMaraviosa.raiz));
		System.out.println("Total folhas: "+goiabeiraMaraviosa.contarFolhas(goiabeiraMaraviosa.raiz));
		System.out.println("Maior: "+goiabeiraMaraviosa.maior(goiabeiraMaraviosa.raiz));
		System.out.println("Menor: "+goiabeiraMaraviosa.menor(goiabeiraMaraviosa.raiz));

		System.out.println("Pai: "+goiabeiraMaraviosa.buscarPai(goiabeiraMaraviosa.raiz, 2));
*/



		goiabeiraMaraviosa.imprimirPreOrdem(goiabeiraMaraviosa.raiz);
		System.out.println("\nExcluir: "+goiabeiraMaraviosa.excluir(20));
		goiabeiraMaraviosa.imprimirPreOrdem(goiabeiraMaraviosa.raiz);
	}
}


