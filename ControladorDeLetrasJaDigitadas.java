public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo

        return this.letrasJaDigitadas.indexOf(letra) != -1;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o m�todo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.

        if (this.isJaDigitada(letra)) {
            throw new Exception("Letra já digitada: " + letra);
        }
        this.letrasJaDigitadas += letra;
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por v�rgula (,).
        return String.join(",", this.letrasJaDigitadas.split(""));
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj s�o iguais
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        ControladorDeLetrasJaDigitadas outro = (ControladorDeLetrasJaDigitadas) obj;
        return this.letrasJaDigitadas.equals(outro.letrasJaDigitadas);
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        return this.letrasJaDigitadas.hashCode();
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de c�pia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
        if (controladorDeLetrasJaDigitadas == null) throw new Exception("Objeto de controle inválido para cópia");
        
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        // criar uma c�pia do this com o construtor de c�pia e retornar
        try {
            return new ControladorDeLetrasJaDigitadas(this);
        } catch (Exception e) {
            return null; 
        }
    }
}
