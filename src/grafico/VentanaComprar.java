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


/**
 * VentanaComprar: Ventana Principal al momento de ver los objetos disponibles
 * */

public class VentanaComprar extends JPanel {
    private BufferedImage imagenFondo;
    private Clip clipMouseOver;
    private Clip clipClick;
    private Expendedor expendedor;
    private Comprador comprador;
    private Moneda500 aux500;
    private Moneda600 aux600;
    private Moneda700 aux700;
    private Moneda400 aux400;
    private Moneda300 aux300;
    private Moneda200 aux200;
    private Moneda100 aux100;
    private Moneda0 aux0;
    private static Moneda monedaUsada;

    public VentanaComprar(CardLayout cardLayout, JPanel cards, Expendedor expendedor) {
        this.expendedor = expendedor;
        this.comprador = comprador;
        this.monedaUsada=aux200;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        cargarSonidos();
        // Imágenes
        JLabel imagen1 = new JLabel();
        JLabel imagen2 = new JLabel();
        JLabel imagen3 = new JLabel();
        JLabel imagen4 = new JLabel();
        JLabel imagen5 = new JLabel();

        try {
            imagenFondo = ImageIO.read(new File("recursos/VentanaComprar.jpg"));

            BufferedImage img1 = ImageIO.read(new File("recursos/cocacola.png"));
            imagen1.setIcon(new ImageIcon(img1.getScaledInstance(50, 100, Image.SCALE_SMOOTH)));

            BufferedImage img2 = ImageIO.read(new File("recursos/sprite.png"));
            imagen2.setIcon(new ImageIcon(img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

            BufferedImage img3 = ImageIO.read(new File("recursos/fanta.png"));
            imagen3.setIcon(new ImageIcon(img3.getScaledInstance(150, 100, Image.SCALE_SMOOTH)));

            BufferedImage img4 = ImageIO.read(new File("recursos/super8.jpg"));
            imagen4.setIcon(new ImageIcon(img4.getScaledInstance(140, 140, Image.SCALE_SMOOTH)));

            BufferedImage img5 = ImageIO.read(new File("recursos/snicker.png"));
            imagen5.setIcon(new ImageIcon(img5.getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel texto1 = new JLabel("\n");
        JLabel texto2 = new JLabel("\n");
        JLabel texto3 = new JLabel("\n");
        JLabel texto5 = new JLabel("\n");
        JLabel texto6 = new JLabel("\n");
        JLabel texto7 = new JLabel("\n");

        //Botones
        JButton boton1 = new JButton("Coca$1000");
        JLabel texto8 = new JLabel("Stock x " + expendedor.getCoca().obtenerCantidad() + "\n Coca-Cola");
        JButton boton2 = new JButton("Sprite$1200");
        JLabel texto9 = new JLabel("Stock x " + expendedor.getSprite().obtenerCantidad() + "\n Sprite");
        JButton boton3 = new JButton("Fanta$900");
        JLabel texto10 = new JLabel("Stock x " + expendedor.getFanta().obtenerCantidad() + "\n Fanta");
        JButton boton4 = new JButton("Super8$800");
        JLabel texto11 = new JLabel("Stock x " + expendedor.getSuper8().obtenerCantidad() + "\n Super8");
        JButton boton5 = new JButton("Snicker$900");
        JLabel texto12 = new JLabel("Stock x " + expendedor.getSnicker().obtenerCantidad() + "\n Snicker");
        JButton boton6 = new JButton("Introducir Dinero");
        JButton boton7 = new JButton("Obtener Vuelto");
        JButton boton8 = new JButton("Volver");

/**
 * Caracteristicas de los botónes.
 * C/U tiene sonidos al pasar el ratón por encima y al seleccionar.
 * Vinculación con otras ventanas
 **/
        //...................................................................
        boton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                try {
                    comprador = new Comprador(VentanaDinero.getmonedaActual(), EleccionPro.COCA_COLA,expendedor);
                    cardLayout.show(cards, "VentanaComprarCoca");

                } catch (NoHayProductosException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoInsuficienteException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
                texto8.setText("Stock x " + expendedor.getCoca().obtenerCantidad() + "\n Coca-Cola");
                monedaUsada=VentanaDinero.getmonedaActual();
                if (VentanaDinero.getmonedaActual().getValor() - 1000 == 500){
                    VentanaDinero.setmonedaActual(aux500);
                }
                else if (VentanaDinero.getmonedaActual().getValor() - 1000 == 0){
                    VentanaDinero.setmonedaActual(aux0);
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
                try {
                    comprador = new Comprador(VentanaDinero.getmonedaActual(), EleccionPro.SPRITE,expendedor);
                    cardLayout.show(cards, "VentanaComprarSprite");
                } catch (NoHayProductosException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoInsuficienteException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
                texto9.setText("Stock x " + expendedor.getSprite().obtenerCantidad() + "\n Sprite");
                monedaUsada=VentanaDinero.getmonedaActual();
                if (VentanaDinero.getmonedaActual().getValor() - 1200 == 300){
                    VentanaDinero.setmonedaActual(aux300);
                }
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

                try {
                    comprador = new Comprador(VentanaDinero.getmonedaActual(), EleccionPro.FANTA,expendedor);
                    cardLayout.show(cards, "VentanaComprarFanta");
                } catch (NoHayProductosException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoInsuficienteException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
                texto10.setText("Stock x " + expendedor.getFanta().obtenerCantidad() + "\n Fanta");
                monedaUsada=VentanaDinero.getmonedaActual();
                if (VentanaDinero.getmonedaActual().getValor() - 900 == 600){
                    VentanaDinero.setmonedaActual(aux600);
                }
                else if (VentanaDinero.getmonedaActual().getValor() - 900 == 100){
                    VentanaDinero.setmonedaActual(aux100);
                }
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

                try {
                    comprador = new Comprador(VentanaDinero.getmonedaActual(), EleccionPro.SUPER8,expendedor);
                    cardLayout.show(cards, "VentanaComprarSuper8");
                } catch (NoHayProductosException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoInsuficienteException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
                texto11.setText("Stock x " + expendedor.getSuper8().obtenerCantidad() + "\n Super8");
                monedaUsada=VentanaDinero.getmonedaActual();
                if (VentanaDinero.getmonedaActual().getValor() - 900 == 600){
                    VentanaDinero.setmonedaActual(aux600);
                }
                else if (VentanaDinero.getmonedaActual().getValor() - 900 == 100){
                    VentanaDinero.setmonedaActual(aux100);
                }
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

                try {
                    comprador = new Comprador(VentanaDinero.getmonedaActual(), EleccionPro.SNICKER,expendedor);
                    cardLayout.show(cards, "VentanaComprarSnicker");
                } catch (NoHayProductosException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoInsuficienteException ex) {
                    throw new RuntimeException(ex);
                } catch (PagoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
                texto12.setText("Stock x " + expendedor.getSnicker().obtenerCantidad() + "\n Snicker");
                monedaUsada=VentanaDinero.getmonedaActual();
                if (VentanaDinero.getmonedaActual().getValor() - 800 == 700){
                    VentanaDinero.setmonedaActual(aux700);
                }
                else if (VentanaDinero.getmonedaActual().getValor() - 800 == 200){
                    VentanaDinero.setmonedaActual(aux200);
                }
            }
        });

        //...................................................................

        boton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                cardLayout.show(cards, "VentanaDinero");
            }
        });
        boton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                cardLayout.show(cards, "VentanaVuelto");
            }
        });
        boton8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reproducirSonido(clipMouseOver);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirSonido(clipClick);
                cardLayout.show(cards, "VentanaPrincipal");
            }

        });

        /**
         * Textos invisibles para calzar plantilla
         */

        // Texto bajo los botones 1
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto1, gbc);
        // Texto bajo los botones 2
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto2, gbc);

        // Texto bajo los botones 6
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto6, gbc);
        // Texto bajo los botones 7
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto7, gbc);
        //....................................................................................

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(7, 7, 7, 10);

        // Imagen 1 Coca
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen1, gbc);

        // Imagen 2 Sprite
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen2, gbc);

        // Imagen 3 Fanta
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen3, gbc);

        // Imagen 4 Super8
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(imagen4, gbc);

        // Imagen 5 Snicker
        gbc.gridy = 5;
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(imagen5, gbc);

        //....................................................................................

        // Botón 1
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(boton1, gbc);

        // Texto bajo los botones 6
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto8, gbc);

        // Botón 2
        gbc.gridy = 2;
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton2, gbc);

        // Texto bajo los botones 9
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(texto9, gbc);

        // Botón 3
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton3, gbc);

        // Texto bajo los botones 10
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(texto10, gbc);

        // Texto bajo los botones 3
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(texto3, gbc);

        // Botón 4
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(boton4, gbc);

        // Texto bajo los botones 11
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto11, gbc);

        // Botón 5
        gbc.gridy = 7;
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(boton5, gbc);
        // Texto bajo los botones 12
        gbc.gridx = 4;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(texto12, gbc);

        //Botón 6
        gbc.gridx = 10;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(boton6, gbc);

        //Botón 7
        gbc.gridx = 10;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(boton7, gbc);

        //volver

        // Botón 8
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.PAGE_START | GridBagConstraints.LINE_END;
        add(boton8, gbc);

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

    /**
     * Metodos  get 'n set para logica tras Compras
     */
    static public Moneda getmonedaUsada(){
        return monedaUsada;
    }
    public static Moneda setmonedaUsada(Moneda m){
        monedaUsada=m;
        return null;
    }
}
