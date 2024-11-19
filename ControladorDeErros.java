public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        // verifica se qtdMax fornecida n�o � positiva, lan�ando
        // uma exce��o.
        // armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax<0) throw new Exception ("Quantidade invalida");

        this.qtdMax=qtdMax;
        
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja � igual a this.qtdMax,
        // lan�ando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if (this.qtdErr==this.qtdMax) throw new Exception ("Errou alem do maximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou ent�o false, caso contrario.
        /*
        if (this.qtdErr==this.qtdMax)
            return true;
        else
            return false;
        */

        return this.qtdErr==this.qtdMax;
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        
        ControladorDeErros outro = (ControladorDeErros) obj;
        return this.qtdMax == outro.qtdMax && this.qtdErr == outro.qtdErr;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int primo = 31;
        int resultado = 1;
        resultado = primo * resultado + this.qtdMax;
        resultado = primo * resultado + this.qtdErr;
        return resultado;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de c�pia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
        if (c == null) throw new Exception("Objeto nulo não pode ser copiado.");
        this.qtdMax = c.qtdMax;
        this.qtdErr = c.qtdErr;
    }

    public Object clone ()
    {
        // returnar uma c�pia de this
        try {
            return new ControladorDeErros(this);
        } catch (Exception e) {
            // Nunca deve acontecer, pois os valores de this já são válidos.
            return null;
        }
    }
}