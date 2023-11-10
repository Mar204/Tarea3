package grafico;
import logico.*;
import logico.Moneda100;
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

/**
 * VentanaDinero: Ventana donde se hace el ingreso de las monedas a la maquina
 * */
public class VentanaDinero extends JPanel {
    private BufferedImage imagenFondo;
    private Clip clipMouseOver;
    private Clip clipClick;
    private Expendedor expendedor;
    private Comprador comprador;
    private Moneda200 aux200;
    private static Moneda monedaActual;

    public VentanaDinero(CardLayout cardLayout, JPanel cards, Expendedor expendedor) {
        this.comprador=comprador;
        this.expendedor=expendedor;
        this.monedaActual=aux200;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        cargarSonidos();
        // Imágenes
        JLabel imagen1 = new JLabel();
        JLabel imagen2 = new JLabel();
        JLabel imagen3 = new JLabel();
        JLabel imagen4 = new JLabel();

        try {
            imagenFondo = ImageIO.read(new File("recursos/VentanaRellenar.jpg"));

            BufferedImage img1 = ImageIO.read(new File("recursos/100.png"));
            imagen1.setIcon(new ImageIcon(img1.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

            BufferedImage img2 = ImageIO.read(new File("recursos/500.png"));
            imagen2.setIcon(new ImageIcon(img2.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

            BufferedImage img3 = ImageIO.read(new File("recursos/1000.png"));
            imagen3.setIcon(new ImageIcon(img3.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

            BufferedImage img4 = ImageIO.read(new File("recursos/1500.png"));
            imagen4.setIcon(new ImageIcon(img4.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel texto1 = new JLabel("\n");
        JLabel texto2 = new JLabel("\n");
        JLabel texto3 = new JLabel("\n");
        JLabel texto4 = new JLabel("\n");
        JLabel texto5 = new JLabel("\n");
        JLabel texto6 = new JLabel("Ultima moneda ingresada: " + null);
        JLabel texto7 = new JLabel("\n");

        //Botones
        JButton boton1 = new JButton("+$100");
        JButton boton2 = new JButton("+$500");
        JButton boton3 = new JButton("+$1000");
        JButton boton4 = new JButton("+$1500");
        JButton boton5 = new JButton("Volver");

        boton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                monedaActual = new Moneda100();
                cardLayout.show(cards, "VentanaComprar");
                texto6.setText("Saldo Actual:$100");
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
                monedaActual = new Moneda500();
                cardLayout.show(cards, "VentanaComprar");
                texto6.setText("Ultima moneda ingresada:$500");
            }
        });
        boton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                monedaActual = new Moneda1000();
                cardLayout.show(cards, "VentanaComprar");
                texto6.setText("Ultima moneda ingresada:$1000");
            }
        });
        boton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                monedaActual = new Moneda1500();
                cardLayout.show(cards, "VentanaComprar");
                texto6.setText("Ultima moneda ingresada:$1500");
            }
        });
        boton5.addMouseListener(new MouseAdapter() {
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
        gbc.gridy = 3;
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
        // Texto bajo los botones 5
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto5, gbc);

        //....................................................................................

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Imagen 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen1, gbc);

        // Imagen 2
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen2, gbc);

        // Imagen 3
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen3, gbc);

        // Imagen 4
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen4, gbc);

        //....................................................................................

        // Botón 1
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(boton1, gbc);

        // Botón 2
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton2, gbc);
        // Botón 3
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton3, gbc);
        // Botón 4
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton4, gbc);

        // Botón 5
        gbc.gridy = 8;
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton5, gbc);
        // 6
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(texto6, gbc);

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
    static public Moneda getmonedaActual(){
        return monedaActual;
    }
    public static Moneda setmonedaActual(Moneda m){
        monedaActual=m;
        return null;
    }
}