import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Electrotech es una aplicación para gestionar dispositivos, como teléfonos y computadoras,
 * y realizar diversas operaciones relacionadas con ellos.
 */
public class Electrotech{
    public static void main(String[] args){
        ArrayList<Superdispositivo> stand = null;
        Scanner scanner = new Scanner(System.in);
        try {
            stand = loadData();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if(stand!= null){
            boolean running = true;
            while(running){
                System.out.println("1. Agregar dispositivo");
                System.out.println("2. Desplegar la informacion basica de dispositivo");
                System.out.println("3. Elementos encendidos y apagados");
                System.out.println("4. Revision de cada dispositivo");
                System.out.println("5. Salir");
                System.out.println("Elija lo que desea hacer: ");
                int opt = scanner.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("1. Telefono");
                        System.out.println("2. Computadora");
                        System.out.println("... ");
                        int val =  scanner.nextInt();
                        System.out.println("Ingrese el modelo o marca de su dispositivo");
                        String name = scanner.next();
                        switch (val) {
                            case 1:
                                stand.add(new Telefono(name));
                                System.out.println("Agregado telefono con exito");
                                break;
                            case 2:
                                stand.add(new Computadora(name));
                                System.out.println("Agregada computadora con exito");
                                break;
                        
                            default:
                                System.out.println("No es una opcion valida");
                                break;
                        }
                        break;
                    case 2:
                        for(Superdispositivo disp : stand){
                            System.out.println(disp);
                        }
                        break;
                    case 3:
                        System.out.println("================================================DISPOSITIVOS ENCENDIDOS================================================");
                        for(Superdispositivo disp : stand){
                            if(disp.getState()){
                                System.out.println(disp);
                            }
                        }
                        System.out.println("");
                        System.out.println("================================================DISPOSITIVOS APAGADOS================================================");
                        for(Superdispositivo disp : stand){
                            if(!disp.getState()){
                                System.out.println(disp);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("1. Enceder y 2. Apagar, apacha enter para cambiar");
                        for(Superdispositivo disp : stand){
                            System.out.println(disp);
                            String ingreso = scanner.next();
                            switch (ingreso) {
                                case "1":
                                    disp.Encender();
                                    break;
                                case "2":
                                    disp.Apagar();
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case 5:
                        try{
                            updateData(stand);
                            running = false;
                            System.out.println("Saliendo del programa");
                        }catch (Exception e){
                            System.out.println("Error: " + e.getMessage());
                        }
                        
                        break;
                    default:
                        System.out.println("No es una opcion valida");
                        break;
                }
            }
            
        }
    }

    /**
     * Carga datos desde un archivo CSV y devuelve una lista de Superdispositivos.
     *
     * @return Una lista de Superdispositivos cargados desde el archivo "stand.csv".
     * @throws Exception Si ocurre un error durante la lectura del archivo.
     */
    public static ArrayList<Superdispositivo> loadData() throws Exception{
        ArrayList<Superdispositivo> temp = new ArrayList<Superdispositivo>();  
        Scanner scanner = new Scanner(new File("stand.csv"));
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] valores = linea.split("\\,");
            if(valores[0].equals("Telefono")){
                temp.add(new Telefono(valores[1]));
            }if(valores[0].equals("Computadora")){
                temp.add(new Computadora(valores[1])); 
            }
            
        }
        return temp;
    }
    /**
     * Actualiza los datos en el archivo CSV a partir de la lista de Superdispositivos.
     *
     * @param stand La lista de Superdispositivos que se escribirá en el archivo "stand.csv".
     * @throws Exception Si ocurre un error durante la escritura del archivo.
     */
    public static void updateData(ArrayList<Superdispositivo> stand)throws Exception{
        try(FileWriter escritor = new FileWriter("stand.csv")){
            for (Superdispositivo disp : stand) {
                if(disp instanceof Telefono){
                    Telefono dispositivo = (Telefono)disp;
                    escritor.append("Telefono,"+dispositivo.getModelo());
                    escritor.append("\n");
                }if(disp instanceof Computadora){
                    Computadora dispositivo = (Computadora)disp;
                    escritor.append("Telefono,"+dispositivo.getMarca());
                    escritor.append("\n");
                }
                    
                }
            }
        catch (IOException e){
            throw new Exception(e);
        }
        
              
    }
}