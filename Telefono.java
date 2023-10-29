/**
 * La clase Telefono extiende Superdispositivo y representa un teléfono con un modelo específico.
 */
public class Telefono extends Superdispositivo{
    private String modelo;
    /**
     * Constructor de Telefono que inicializa el teléfono con un modelo dado y lo establece como apagado.
     *
     * @param modelo El modelo del teléfono.
     */
    public Telefono(String modelo){
        super();
        this.modelo = modelo;
    }
    /**
     * Obtiene el modelo del teléfono.
     *
     * @return El modelo del teléfono.
     */
    public String getModelo(){
        return this.modelo;
    }
     /**
     * Devuelve una representación de cadena del teléfono, indicando su modelo.
     *
     * @return Una cadena que describe el teléfono y su modelo.
     */
    @Override
    public String toString(){
        return "Telefono de modelo "+modelo;
    }

    
}
