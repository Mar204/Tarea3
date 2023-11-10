package grafico;
import logico.*;

import javax.swing.*;
import java.awt.CardLayout;
/**
 * Ventana: Organizador de las ventanas del programa
 * */
public class Ventana extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;

    public Ventana(Expendedor expendedor) {
        setTitle("Expendedor");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        VentanaInicio ventana1 = new VentanaInicio(cardLayout, cards);
        VentanaPrincipal ventana2 = new VentanaPrincipal(cardLayout, cards);
        VentanaComprar ventana3 = new VentanaComprar(cardLayout, cards, expendedor);
        VentanaComprarCoca ventana7 = new VentanaComprarCoca(cardLayout, cards);
        VentanaComprarFanta ventana8 = new VentanaComprarFanta(cardLayout, cards);
        VentanaComprarSprite ventana9 = new VentanaComprarSprite(cardLayout, cards);
        VentanaComprarSuper8 ventana10 = new VentanaComprarSuper8(cardLayout, cards);
        VentanaComprarSnicker ventana11 = new VentanaComprarSnicker(cardLayout, cards);
        VentanaDinero ventana12 = new VentanaDinero(cardLayout, cards, expendedor);
        VentanaVuelto ventana13 = new VentanaVuelto(cardLayout, cards);

        cards.add(ventana1, "VentanaInicio");
        cards.add(ventana2, "VentanaPrincipal");
        cards.add(ventana3, "VentanaComprar");
        cards.add(ventana7, "VentanaComprarCoca");
        cards.add(ventana8, "VentanaComprarFanta");
        cards.add(ventana9, "VentanaComprarSprite");
        cards.add(ventana10, "VentanaComprarSuper8");
        cards.add(ventana11, "VentanaComprarSnicker");
        cards.add(ventana12, "VentanaDinero");
        cards.add(ventana13, "VentanaVuelto");

        add(cards);
    }

    public void mostrarInterfaz() {
        setVisible(true);
    }
}