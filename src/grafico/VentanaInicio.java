package grafico;
import logico.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * VentanaInicio: Ventana Inicial de bienvenida
 * */
public class VentanaInicio extends JPanel {
    private JButton botonCambiarVentana;
    private CardLayout cardLayout;
    private JPanel cards;
    private BufferedImage imagenFondo;
    private float alpha = 0.0f;

    public VentanaInicio(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;

        setLayout(new BorderLayout());

        try {
            imagenFondo = ImageIO.read(new File("recursos/Expendedor.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        botonCambiarVentana = new JButton("Iniciar Expendedor");
        botonCambiarVentana.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido("recursos/Sobre.wav");
            }
        });

        botonCambiarVentana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("recursos/Click.wav");
                cambiarVentana();
            }
        });

        add(botonCambiarVentana, BorderLayout.SOUTH);
    }

    private void cambiarVentana() {
        Timer timer = new Timer(1000 / 30, new ActionListener() {
            private long startTime = -1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime < 0) {
                    startTime = System.currentTimeMillis();
                }

                long duration = System.currentTimeMillis() - startTime;
                final int fadeDuration = 4000;
                if (duration >= fadeDuration) {
                    ((Timer) e.getSource()).stop();
                    cardLayout.show(cards, "VentanaPrincipal");
                }

                alpha = (float) duration / fadeDuration;
                repaint();
            }
        });
        timer.start();
    }

    private void reproducirSonido(String filepath) {
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
        int backgroundAlpha = (int) (alpha * 255);
        Color bgColor = new Color(0, 0, 0, backgroundAlpha);
        g.setColor(bgColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}