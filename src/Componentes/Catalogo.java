package Componentes;

public class Catalogo {
        private CatalogoNo inicio;
        private CatalogoNo fim;
        private int tamanho;

        public Catalogo() {
            inicio = null;
            fim = null;
            tamanho = 0;
        }

        public void adicionar(Item item) {
            CatalogoNo novo = new CatalogoNo(item, null, null);

            if (inicio == null) {
                inicio = novo;
                fim = novo;
            } else {
                novo.setAntes(fim);
                fim.setDepois(novo);
                fim = novo;
            }

            tamanho++;
        }

        public CatalogoNo remover(int index) {
            if (index < 0 || index >= tamanho) {
                return null;
            }

            CatalogoNo atual = inicio;
            int contador = 0;

            while (contador < index) {
                atual = atual.getDepois();
                contador++;
            }

            CatalogoNo anterior = atual.getAntes();
            CatalogoNo proximo = atual.getDepois();

            if (anterior != null) {
                anterior.setDepois(proximo);
            } else {
                inicio = proximo;
            }

            if (proximo != null) {
                proximo.setAntes(anterior);
            } else {
                fim = anterior;
            }

            atual.setAntes(null);
            atual.setDepois(null);
            tamanho--;

            return atual;
        }

        public CatalogoNo getNo(int index) {
            if (index < 0 || index >= tamanho) {
                return null;
            }

            CatalogoNo atual = inicio;
            int contador = 0;

            while (contador != index) {
                atual = atual.getDepois();
                contador++;
            }

            return atual;
        }

        public int getSize() {
            return tamanho;
        }

        public boolean isEmpty() {
            return tamanho == 0;
        }

        public void exibir() {
            CatalogoNo atual = inicio;

            while (atual != null) {
                System.out.print(atual.getItem().getNome().toString() + " ");
                atual = atual.getDepois();
            }

            System.out.println();
        }

        public void imprimirNo(int index) {
            CatalogoNo no = getNo(index);
            if (no != null) {
                System.out.println(no.getItem().getNome().toString());
            }
        }

        public void imprimirVoltado() {
            CatalogoNo atual = fim;

            while (atual != null) {
                System.out.print(atual.getItem().getNome().toString() + " ");
                atual = atual.getAntes();
            }

            System.out.println();
        }

        public void adicionarNo(Item item, int index) {
            if (index < 0 || index > tamanho) {
                return;
            }

            if (index == 0) {
                CatalogoNo novo = new CatalogoNo(item, null, null);
                novo.setDepois(inicio);
                if (inicio != null) {
                    inicio.setAntes(novo);
                } else {
                    fim = novo;
                }
                inicio = novo;
                tamanho++;
            } else if (index == tamanho) {
                adicionar(item);
            } else {
                CatalogoNo atual = getNo(index - 1);
                CatalogoNo proximo = atual.getDepois();

                CatalogoNo novo = new CatalogoNo(item, null, null);
                novo.setAntes(atual);
                novo.setDepois(proximo);

                atual.setDepois(novo);
                proximo.setAntes(novo);

                tamanho++;
            }
        }

        public void resetarNo(int index) {
            CatalogoNo no = getNo(index);
            if (no != null) {
                no = null;
            }
        }
    }
