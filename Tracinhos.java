public class Tracinhos implements Cloneable {
    private char[] texto;

    public Tracinhos(int qtd) throws Exception {
        if (qtd <= 0)
            throw new Exception("Quantidade de tracinhos inválida");

        this.texto = new char[qtd];

        for (int i = 0; i < qtd; i++) {
            this.texto[i] = '_';
        }
    }

    public void revele(int posicao, char letra) throws Exception {
        if (posicao < 0 || posicao >= this.texto.length)
            throw new Exception("Posição inválida");

        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos() {
        for (char c : this.texto) {
            if (c == '_') {
                return true; 
            }
        }
        return false; 
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.texto.length; i++) {
            sb.append(this.texto[i]);
            if (i < this.texto.length - 1) {
                sb.append(" "); 
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tracinhos)) return false;
        Tracinhos outro = (Tracinhos) obj;

        if (this.texto.length != outro.texto.length) return false;
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] != outro.texto[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        for (char c : this.texto) {
            hash = 31 * hash + c; 
        }
        return hash;
    }

    public Tracinhos(Tracinhos t) throws Exception {
        if (t == null)
            throw new Exception("Objeto nulo");

        this.texto = new char[t.texto.length];

        for (int i = 0; i < t.texto.length; i++) {
            this.texto[i] = t.texto[i];
        }
    }

    public Object clone() {
        try {
            return new Tracinhos(this); 
        } catch (Exception e) {
            return null; 
        }
    }
}
