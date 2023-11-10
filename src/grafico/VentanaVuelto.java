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

public class VentanaVuelto extends JPanel {
    private BufferedImage imagenFondo;
    private Clip clipMouseOver;
    private Clip clipClick;
    private Expendedor expendedor;
    private Moneda100 moneda100;
    private int a;
    private String b;
    private int c;
    private Moneda900 aux900;
    private Moneda800 aux800;
    private Moneda500 aux500;
    private Moneda600 aux600;
    private Moneda700 aux700;
    private Moneda400 aux400;
    private Moneda300 aux300;
    private Moneda200 aux200;
    private Moneda100 aux100;
    private Moneda1100 aux1100;
    private Moneda1000 aux1000;
    private Moneda1200 aux1200;
    private Moneda1300 aux1300;
    private Moneda1400 aux1400;
    private Moneda0 aux0;

    /**
     * Ventana Vuelto entrega Vuelto con Num.Serie en valores de 100
     */

    public VentanaVuelto(CardLayout cardLayout, JPanel cards) {

        this.expendedor = expendedor;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        cargarSonidos();
        // Imágenes
        JLabel imagen1 = new JLabel();

        try {
            imagenFondo = ImageIO.read(new File("recursos/VentanaRellenar.jpg"));

            BufferedImage img1 = ImageIO.read(new File("recursos/100.png"));
            imagen1.setIcon(new ImageIcon(img1.getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel texto1 = new JLabel("\n");
        JLabel texto2 = new JLabel("\n");
        JLabel texto3 = new JLabel("\n");
        JLabel texto4 = new JLabel("\n");
        JLabel texto5 = new JLabel("\n");
        JLabel texto6 = new JLabel("\n");
        JLabel texto7 = new JLabel("\n");

        //Botones
        JButton boton1 = new JButton("Retirar $100");
        JLabel texto8 = new JLabel("Serie:null" );

        if (VentanaComprar.getmonedaUsada()!=null){
            if (VentanaComprar.getmonedaUsada().getValor()==0){
            b="No Disponible";
            } else {
            b="disponible";
            }
        }else {
            b="No Disponible";
        }
        JLabel texto9 = new JLabel("Vuelto:" + b);
        JButton boton2 = new JButton("Volver");

        boton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                Moneda monedaUsada = VentanaComprar.getmonedaUsada();

                if (monedaUsada != null) {
                    c=VentanaComprar.getmonedaUsada().getValor();
                if (c==1500){
                    VentanaComprar.setmonedaUsada(aux1400);
                    a= a+792;
                    c=c-100;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (c==1400){
                    VentanaComprar.setmonedaUsada(aux1300);
                    a= a+212;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (c==1300){
                    VentanaComprar.setmonedaUsada(aux1200);
                    a= Math.abs(a-122);
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (c==1200){
                    VentanaComprar.setmonedaUsada(aux1100);
                    a= Math.abs(a-8);
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (c==1100){
                    VentanaComprar.setmonedaUsada(aux1000);
                    a= a+83;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==1000){
                    VentanaComprar.setmonedaUsada(aux900);
                    a= a+823;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==900){
                    VentanaComprar.setmonedaUsada(aux800);
                    a= a+92;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==800){
                    VentanaComprar.setmonedaUsada(aux700);
                    a= a+92;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==700){
                    VentanaComprar.setmonedaUsada(aux600);
                    a= a+232;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==600){
                    VentanaComprar.setmonedaUsada(aux500);
                    a= a+22;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==500){
                    VentanaComprar.setmonedaUsada(aux400);
                    a= Math.abs(a-2);
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==400){
                    VentanaComprar.setmonedaUsada(aux300);
                    a= a+292;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==300){
                    VentanaComprar.setmonedaUsada(aux200);
                    a= Math.abs(a-822);
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==200){
                    VentanaComprar.setmonedaUsada(aux100);
                    a= a+92;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==100){
                    VentanaComprar.setmonedaUsada(aux0);
                    a= a+434;
                    texto8.setText("Serie:" + a);
                    texto9.setText("Vuelto: Disponible");
                }
                else if (VentanaComprar.getmonedaUsada().getValor()==0){
                    texto8.setText("Serie:null");
                    texto9.setText("Vuelto: No disponible");
                }
                }
            }
        });

        boton2.addMouseListener(new MouseAdapter() {
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
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto1, gbc);
        // Texto bajo los botones 2
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto2, gbc);

        // Texto bajo los botones 3
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto3, gbc);

        // Texto bajo los botones 4
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto4, gbc);
        //....................................................................................

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Imagen 1
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen1, gbc);

        //....................................................................................

        // Botón 1
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(boton1, gbc);
        // Texto 8
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto8, gbc);
        // Texto 9
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto9, gbc);

        // Botón 2
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton2, gbc);

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