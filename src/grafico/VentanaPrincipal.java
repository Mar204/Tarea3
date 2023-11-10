package grafico;
import logico.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

/**
 * VentanaPrincipal: Ventana de acceso a las demás acciones
 * */
public class VentanaPrincipal extends JLayeredPane {

    private BufferedImage imagenFondo;
    private Clip clipMouseOver;
    private Clip clipClick;

    public VentanaPrincipal(CardLayout cardLayout, JPanel cards) {
        try {
            imagenFondo = ImageIO.read(new File("recursos/Expendedor2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        cargarSonidos();

        JLabel tituloLabel = new JLabel("!Feliz Compra!");
        tituloLabel.setFont(cargarFuente("recursos/botw.otf", 40));

        JButton botonComprar = new JButton("Comprar");

        int buttonWidth = 180;
        int buttonHeight = 70;

        botonComprar.setFont(new Font("Arial", Font.PLAIN, 20));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(tituloLabel, gbc);

        gbc.gridy = 1;
        gbc.weightx = 1;
        add(Box.createVerticalStrut(0), gbc);

        gbc.gridy = 2;
        gbc.weightx = 0;

        gbc.gridy = 3;
        add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 4;
        add(botonComprar, gbc);

        gbc.gridy = 5;
        add(Box.createVerticalStrut(10), gbc);

        setPreferredSize(new Dimension(600, 500));


        botonComprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                cardLayout.show(cards, "VentanaComprar");
            }
        });
    }

    private void cargarSonidos() {
        try {
            File audioFileMouseOver = new File("recursos/Sobre.wav");
            AudioInputStream audioStreamMouseOver = AudioSystem.getAudioInputStream(audioFileMouseOver);
            clipMouseOver = AudioSystem.getClip();
            clipMouseOver.open(audioStreamMouseOver);

            File audioFileClick = new File("recursos/Click.wav");
            AudioInputStream audioStreamClick = AudioSystem.getAudioInputStream(audioFileClick);
            clipClick = AudioSystem.getClip();
            clipClick.open(audioStreamClick);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void reproducirSonido(Clip clip) {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }
    private Font cargarFuente(String rutaFuente, int tamanio) {
        Font fuente = null;
        try {
            File file = new File(rutaFuente);
            fuente = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(Font.PLAIN, tamanio);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, file));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return fuente;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}