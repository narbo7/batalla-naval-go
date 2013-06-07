package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Nave;
import model.Partida;
import model.Tablero;


import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaPrincipal implements ObservadorDeGameLoop{

        private JFrame frame;
        private GameLoop gameLoop;
        
        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        VentanaPrincipal window = new VentanaPrincipal();
                                        window.frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        /**
         * Create the application.
         */
        public VentanaPrincipal() {
                try {
                        initialize();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        /**
         * Initialize the contents of the frame.
         * @throws IOException
         */
        private void initialize() throws IOException {
                frame = new JFrame();
                frame.setForeground(new Color(0, 0, 0));
                frame.setBounds(100, 100, 600, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);
                frame.setTitle("BATALLA NAVALGO");
               
                JButton btnIniciar = this.addBotonIniciar();
                JButton btnDetener = this.addBotonDetener();
               
                JPanel panel = this.addSuperficiePanel();
               
                this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
                              
                this.gameLoop.agregarObservador(this);
                              
                this.inicializarModelo();
               
                this.addMouseListener(panel);
                              
                this.addKeyListener();

                this.setComponentsFocus(btnIniciar, btnDetener);

        }

        private void inicializarModelo() throws IOException {
        		
        	
                Partida miPartida = new Partida();
                this.gameLoop.agregar(miPartida);
                
                for (Nave nave : miPartida.getNaves()) {
                	this.gameLoop.agregar(nave);
                	this.gameLoop.agregar(nave.generarVista());
                }
                             
        }

       
        private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
                frame.setFocusable(true);
                btnDetener.setFocusable(false);
                btnIniciar.setFocusable(false);
        }

        private void addKeyListener() {
                frame.addKeyListener(new KeyListener(
                                ) {
                       
                        @Override
                        public void keyTyped(KeyEvent arg0) {
                                System.out.println("Key pressed");
                        }
                       
                        @Override
                        public void keyReleased(KeyEvent arg0) {
                        }
                       
                        @Override
                        public void keyPressed(KeyEvent arg0) {
                                System.out.println("Ping");
                        }  
                               
                });
        }

        private void addMouseListener(JPanel panel) {
                panel.addMouseListener(new MouseAdapter() {                    
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                }});
        }

        private JPanel addSuperficiePanel() {
                JPanel panel = new SuperficiePanel();
                panel.setBackground(new Color(0,0,0));
                panel.setBounds(42, 53, Tablero.getMaxColumna(), Tablero.getMaxFila());
                frame.getContentPane().add(panel);
                return panel;
        }

        private JButton addBotonDetener() {
                JButton btnDetener = new JButton("Detener");
                btnDetener.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                gameLoop.detenerEjecucion();
                        }
                });
                btnDetener.setBounds(425, 16, 92, 25);
                frame.getContentPane().add(btnDetener);
                return btnDetener;
        }

        private JButton addBotonIniciar() {
                JButton btnIniciar = new JButton("Iniciar");
                btnIniciar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                gameLoop.iniciarEjecucion();
                        }
                });
                btnIniciar.setBounds(42, 16, 77, 25);
                frame.getContentPane().add(btnIniciar);
                return btnIniciar;
        }

        @Override
        public void notificarCicloFinalizado() {
               
        }
    
}
