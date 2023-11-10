package grafico;
import logico.*;
import javax.swing.*;

/**
 * @author Martín Rubilar.
 * Las excepciones se muestran en el panel inferior
 */

public class Main {
    public static void main(String[] args) throws NoHayProductosException, PagoInsuficienteException, PagoIncorrectoException {
        MusicaFondo.reproducirMusicaFondo("recursos/Fondo.wav");
/**
 * Inicialización del expendedor y comprador.
 */
        Expendedor expendedor = Expendedor.getInstance(2);
        Comprador comprador = (null);
        javax.swing.SwingUtilities.invokeLater(() -> {
            Ventana ventana = new Ventana(expendedor);
            ventana.setTitle("Tarea 3");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.mostrarInterfaz();
        });
    }
}