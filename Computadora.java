/**
 * La clase Computadora extiende Superdispositivo y representa una computadora con una marca específica.
 */
public class Computadora extends Superdispositivo{
    private String marca;
    /**
     * Constructor de Computadora que inicializa la computadora con una marca dada y la establece como apagada.
     *
     * @param marca La marca de la computadora.
     */
    public Computadora(String marca){
        super();
        this.marca = marca;
    }
    /**
     * Obtiene la marca de la computadora.
     *
     * @return La marca de la computadora.
     */
    public String getMarca(){
        return this.marca;
    }
     /**
     * Devuelve una representación de cadena de la computadora, indicando su marca.
     *
     * @return Una cadena que describe la computadora y su marca.
     */
    @Override
    public String toString(){
        return "Computadora de marca "+marca;
    }
}
