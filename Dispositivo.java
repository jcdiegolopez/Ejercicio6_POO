/**
 * La interfaz Dispositivo define métodos que representan acciones de encendido y apagado,
 * así como un método para obtener el estado del dispositivo.
 */
public interface Dispositivo {

    /**
     * Enciende el dispositivo.
     */
    public abstract void Encender();
     /**
     * Apaga el dispositivo.
     */
    public abstract void Apagar();
    /**
     * Obtiene el estado actual del dispositivo.
     *
     * @return true si el dispositivo está encendido, false si está apagado.
     */
    public abstract boolean getState();
}