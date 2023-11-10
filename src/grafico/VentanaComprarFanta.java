package grafico;
import logico.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.Random;
/**
 * VentanaComprarFanta: Ventana que se muestra al momento de comprar una Fanta
 * */

public class VentanaComprarFanta extends JPanel {
    private BufferedImage imagenFondo;
    private Clip clipMouseOver;
    private Clip clipClick;
    public VentanaComprarFanta(CardLayout cardLayout, JPanel cards) {
        Random random = new Random();
        int numSerie = random.nextInt(1000) + 1;
        Fanta fanta = new Fanta(numSerie);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        cargarSonidos();
        // Imágenes
        JLabel imagen1 = new JLabel();


        try {
            imagenFondo = ImageIO.read(new File("recursos/VentanaRellenar.jpg"));

            BufferedImage img1 = ImageIO.read(new File("recursos/fanta.png"));
            imagen1.setIcon(new ImageIcon(img1.getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel texto1 = new JLabel("\n");
        JLabel texto2 = new JLabel("\n");
        JLabel texto3 = new JLabel("\n");
        JLabel texto4 = new JLabel("\n");


        //Botones
        JButton boton1 = new JButton("Volver");
        JLabel texto8 = new JLabel("Obtuviste:Fanta: \n Sabor 'naranja'");
        JLabel texto9 = new JLabel(" Num. Serie:+ numSerie");

        boton1.addMouseListener(new MouseAdapter() {
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
        // Texto bajo los botones 1
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto1, gbc);
        // Texto bajo los botones 2
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto2, gbc);

        // Texto bajo los botones 3
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto3, gbc);

        // Texto bajo los botones 4
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto4, gbc);

//.................................................................

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Imagen 1
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(imagen1, gbc);
        //TEXTO 1
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(texto8, gbc);
        //TEXTO 2
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(texto9, gbc);

        //BOTÓN 1

        // Botón 1
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton1, gbc);

        //....................................................................................

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
    private void cargarSonidos() {
        try {
            File audioFileMouseOver = new File("recursos/Sobre.wav");
            AudioInputStream audioStreamMouseOver = AudioSystem.getAudioInputStream(audioFileMouseOver);
            clipMouseOver = AudioSystem.getClip();
            clipMouseOver.open(audioStreamMouseOver);

            File audioFileClick = new File("recursos/ClickExpendedor.wav");
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
}