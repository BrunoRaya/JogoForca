public class Palavra implements Comparable<Palavra> {
    private String texto;

    public Palavra(String texto) throws Exception {
        if (texto == null || texto.isEmpty()) {
            throw new Exception("O texto não pode ser nulo ou vazio.");
        }
        this.texto = texto;
    }

    public int getQuantidade(char letra) {
        int count = 0;
        for (char c : this.texto.toCharArray()) {
            if (c == letra) {
                count++;
            }
        }
        return count;
    }

    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception {
        int ocorrencia = -1;
        int contador = 0;

        for (int pos = 0; pos < this.texto.length(); pos++) {
            if (this.texto.charAt(pos) == letra) {
                if (contador == i) {
                    ocorrencia = pos;
                    break;
                }
                contador++;
            }
        }

        if (ocorrencia == -1) {
            throw new Exception("A letra '" + letra + "' não possui " + (i + 1) + " ocorrências em " + this.texto);
        }

        return ocorrencia;
    }

    public int getTamanho() {
        return this.texto.length();
    }

    public String toString() {
        return this.texto;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Palavra palavra = (Palavra) obj;
        return this.texto.equals(palavra.texto);
    }

    public int hashCode() {
        return this.texto.hashCode();
    }

    public int compareTo(Palavra palavra) {
        return this.texto.compareTo(palavra.texto);
    }
}
