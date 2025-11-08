
class Arvore {
	No raiz;
	Arvore() {
		raiz = null;
	}
	public boolean vazia() {
		return raiz == null;
	}


	public No buscarPai(No atual, int valor) {
		if (valor == raiz.dado)
			return null;
		No pai = atual;
		while (atual != null) {
			if (valor == atual.dado) {
				break;
			}
			pai = atual;
			if (valor > atual.dado)
				atual = atual.direita;
			else
				atual = atual.esquerda;
		}
		return pai;
	}

	public No maior(No atual) {
		No maior = atual;
		while (atual != null) {
			maior = atual;
			atual = atual.direita;
		}
		return maior;
	}

	public No menor(No atual) {
		No menor = atual;
		while (atual != null) {
			menor = atual;
			atual = atual.esquerda;
		}
		return menor;
	}

	public int contarFolhas(No atual) {
		if (atual == null)
			return 0;
		if (atual.direita == null && atual.esquerda == null)
			return 1;
		else
			return contarFolhas(atual.direita) + contarFolhas(atual.esquerda);
	}

	public int altura(No atual) {
		if (atual == null)
			return -1;
		return 1 + Math.max(altura(atual.direita), altura(atual.esquerda));
		/*
		int alturaDireita = 1 + altura(atual.direita);
		int alturaEsquerda = 1 + altura(atual.esquerda);
		if (alturaDireita > alturaEsquerda)
		    return alturaDireita;
		else
		    return alturaEsquerda;*/
	}

	public int contar(No atual) {
		if (atual == null)
			return 0;
		return 1 + contar(atual.esquerda) + contar(atual.direita);
	}

	public No buscar(No atual, int valor) {
		if (atual == null)
			return null;
		if (valor == atual.dado)
			return atual;
		if (valor > atual.dado)
			return buscar(atual.direita, valor);
		else
			return buscar(atual.esquerda, valor);
	}

	public void imprimirPosOrdem(No atual) {
		if (atual == null)
			return;
		imprimirPosOrdem(atual.esquerda);
		imprimirPosOrdem(atual.direita);
		System.out.print(atual+" ");
	}
	public void imprimirPreOrdem(No atual) {
		if (atual == null)
			return;
		System.out.print(atual+" ");
		imprimirPreOrdem(atual.esquerda);
		imprimirPreOrdem(atual.direita);
	}
	public void imprimirEmOrdem(No atual) {
		if (atual == null)
			return;
		imprimirEmOrdem(atual.esquerda);
		System.out.print(atual+" ");
		imprimirEmOrdem(atual.direita);
	}
	public void imprimirEmOrdemDesc(No atual) {
		if (atual == null)
			return;
		imprimirEmOrdemDesc(atual.direita);
		System.out.print(atual+" ");
		imprimirEmOrdemDesc(atual.esquerda);
	}
	public void inserir(int valor) {
		No novo = new No(valor);
		if (vazia()) {
			raiz = novo;
			return;
		}
		No atual = raiz;
		No anterior = raiz;
		while (atual != null) {
			anterior = atual;
			if (valor > atual.dado)
				atual = atual.direita;
			else
				atual = atual.esquerda;
		}
		if (valor > anterior.dado)
			anterior.direita = novo;
		else
			anterior.esquerda = novo;
	}

	// excluir hibrida
	public No excluir(int valor) {
		if (vazia())
			return null;

		// Caso 1: a Arvore possui apenas a raiz
		if (valor == raiz.dado && raiz.esquerda == null && raiz.direita == null) {
			raiz = null;
			return null;
		}

		// Busca o No a ser excluido
		No excluido = buscar(raiz, valor);
		if (excluido == null) {
			System.out.println("NC3 inexistente!!!");
			return null;
		}

		// Busca o pai do No a ser excluido
		No pai = buscarPai(raiz, valor);

		// Caso 2: no sem filhos (folha)
		if (excluido.esquerda == null && excluido.direita == null) {
			if (pai.esquerda == excluido)
				pai.esquerda = null;
			else
				pai.direita = null;
			return excluido;
		}

		// Caso 3: No com apenas 1 filho
		if (excluido.esquerda == null || excluido.direita == null) {
			// identifica o filho existente (esquerda ou direita)
			No filho = (excluido.esquerda != null) ? excluido.esquerda : excluido.direita;

			if (pai == null) {
				// Se o pai eh nulo, estamos excluindo a raiz
				raiz = filho;
			} else {
				// Se nao for a raiz, liga o pai diretamente ao filho
				if (pai.esquerda == excluido)
					pai.esquerda = filho;
				else
					pai.direita = filho;
			}

			return excluido;
		}

		// Caso 4: no com 2 filhos
		// encontra o sucessor (menor No da subarvore direita)
		No sucessor = menor(excluido.direita);
		int valorSucessor = sucessor.dado;

		// exclui o sucessor (ele tera no maximo um filho)
		excluir(valorSucessor);

		// substitui o valor do No excluido pelo do sucessor
		excluido.dado = valorSucessor;

		return excluido;
	}


	// excluir recursiva
	public No excluirRec(No atual, int valor) {
		if (atual == null)
			return null;

		// navega ate encontrar o valor
		if (valor < atual.dado)
			atual.esquerda = excluirRec(atual.esquerda, valor);
		else if (valor > atual.dado)
			atual.direita = excluirRec(atual.direita, valor);
		else {
			// caso 1: sem filhos
			if (atual.esquerda == null && atual.direita == null)
				return null;

			// caso 2: um filho
			else if (atual.esquerda == null)
				return atual.direita;
			else if (atual.direita == null)
				return atual.esquerda;

			// caso 3: dois filhos
			else {
				// pega o menor valor da subC!rvore direita (sucessor)
				No sucessor = menor(atual.direita);
				atual.dado = sucessor.dado;
				atual.direita = excluirRec(atual.direita, sucessor.dado);
			}
		}

		return atual;
	}


	public void excluirIterativo(int valor) {
		No pai = null;
		No atual = raiz;

		// busca o No
		while (atual != null && atual.dado != valor) {
			pai = atual;
			if (valor < atual.dado)
				atual = atual.esquerda;
			else
				atual = atual.direita;
		}

		if (atual == null) {
			System.out.println("NC3 nC#o encontrado!");
			return;
		}

		// Caso 1: sem filhos
		if (atual.esquerda == null && atual.direita == null) {
			if (pai == null) raiz = null; // era a raiz
			else if (pai.esquerda == atual) pai.esquerda = null;
			else pai.direita = null;
		}

		// Caso 2: um filho
		else if (atual.esquerda == null || atual.direita == null) {
			No filho = (atual.esquerda != null) ? atual.esquerda : atual.direita;
			if (pai == null) raiz = filho;
			else if (pai.esquerda == atual) pai.esquerda = filho;
			else pai.direita = filho;
		}

		// Caso 3: dois filhos
		else {
			No paiSucessor = atual;
			No sucessor = atual.direita;

			while (sucessor.esquerda != null) {
				paiSucessor = sucessor;
				sucessor = sucessor.esquerda;
			}

			atual.dado = sucessor.dado;

			// remove o sucessor
			if (paiSucessor.esquerda == sucessor)
				paiSucessor.esquerda = sucessor.direita;
			else
				paiSucessor.direita = sucessor.direita;
		}
	}

}