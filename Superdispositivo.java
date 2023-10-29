/**
 * La clase Superdispositivo implementa la interfaz Dispositivo y representa un dispositivo con capacidad
 * de encendido y apagado, y un estado que indica si está encendido o apagado.
 */
public class Superdispositivo implements Dispositivo{
    protected boolean state;
     /**
     * Constructor de Superdispositivo que inicializa el estado como apagado (false).
     */
    public Superdispositivo(){
        this.state = false;
    }
    /**
     * Devuelve una representación de cadena del estado del dispositivo.
     *
     * @return Una cadena que indica si el dispositivo está encendido (ON) o apagado (OFF).
     */
    @Override
    public String toString() {
        if(this.state){
            return "El estado del dispositivo es ON";
        }else{
            return "El estado del dispositivo es OF";
        }
        
    }
    /**
     * Obtiene el estado actual del dispositivo.
     *
     * @return true si el dispositivo está encendido, false si está apagado.
     */
    public boolean getState(){
        return this.state;
    }
    /**
     * Enciende el dispositivo, estableciendo su estado a ON.
     */
    public void Encender(){
        this.state = true;
    }
    /**
     * Apaga el dispositivo, estableciendo su estado a OFF.
     */
    public void Apagar(){
        this.state = false;
    }
}
