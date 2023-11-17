package Componentes;

public class Bestiario {
        private BestiarioNo inicio;
        private BestiarioNo fim;
        private int tamanho;

        public Bestiario() {
            inicio = null;
            fim = null;
            tamanho = 0;
        }

        public void adicionar(Criatura criatura) {
            BestiarioNo novo = new BestiarioNo(criatura, null, null);

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

        public BestiarioNo remover(int index) {
            if (index < 0 || index >= tamanho) {
                return null;
            }

            BestiarioNo atual = inicio;
            int contador = 0;

            while (contador < index) {
                atual = atual.getDepois();
                contador++;
            }

            BestiarioNo anterior = atual.getAntes();
            BestiarioNo proximo = atual.getDepois();

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

        public BestiarioNo getNo(int index) {
            if (index < 0 || index >= tamanho) {
                return null;
            }

            BestiarioNo atual = inicio;
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
            BestiarioNo atual = inicio;

            while (atual != null) {
                System.out.print(atual.getCriatura().getNome().toString() + " ");
                atual = atual.getDepois();
            }

            System.out.println();
        }

        public void imprimirNo(int index) {
            BestiarioNo no = getNo(index);
            if (no != null) {
                System.out.println(no.getCriatura().getNome().toString());
            }
        }

        public void imprimirVoltado() {
            BestiarioNo atual = fim;

            while (atual != null) {
                System.out.print(atual.getCriatura().getNome().toString() + " ");
                atual = atual.getAntes();
            }

            System.out.println();
        }

        public void adicionarNo(Criatura criatura, int index) {
            if (index < 0 || index > tamanho) {
                return;
            }

            if (index == 0) {
                BestiarioNo novo = new BestiarioNo(criatura, null, null);
                novo.setDepois(inicio);
                if (inicio != null) {
                    inicio.setAntes(novo);
                } else {
                    fim = novo;
                }
                inicio = novo;
                tamanho++;
            } else if (index == tamanho) {
                adicionar(criatura);
            } else {
                BestiarioNo atual = getNo(index - 1);
                BestiarioNo proximo = atual.getDepois();

                BestiarioNo novo = new BestiarioNo(criatura, null, null);
                novo.setAntes(atual);
                novo.setDepois(proximo);

                atual.setDepois(novo);
                proximo.setAntes(novo);

                tamanho++;
            }
        }

        public void resetarNo(int index) {
            BestiarioNo no = getNo(index);
            if (no != null) {
                no = null;
            }
        }
    }
