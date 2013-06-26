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
import java.util.LinkedList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Bomba;
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
        static int aumento = 50;
        static int relacionTableroVentanaX = (aumento*Tablero.getMaxColumna());
        static int relacionTableroVentanaY = (aumento*Tablero.getMaxFila());
        private LinkedList<ObservadorMouse> observadoresMouse= new LinkedList<ObservadorMouse>();	
        private LinkedList<ObservadorTeclado> observadoresTeclado= new LinkedList<ObservadorTeclado>();
        private Partida miPartida = new Partida();
        
        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        VentanaPrincipal window = new VentanaPrincipal();
                                        window.frame.setVisible(true);
                                        VentanaBombas unaVentana = new VentanaBombas();
                                        unaVentana.frame.setVisible(true);
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
                frame.setForeground(new Color(0,0,0));
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
        		
        	
                //Partida miPartida = new Partida();
                this.gameLoop.agregar(this.getPartida());
                this.agregarObservadorMouse(miPartida);
                this.agregarObservadorTeclado(miPartida);
                

                for (Nave nave : miPartida.getNaves()) {
                	LinkedList<VistaElementoDelJuego> listaVistasNave = new LinkedList<VistaElementoDelJuego>();
                	listaVistasNave = nave.generarVista();
                	for (VistaElementoDelJuego unaVista : listaVistasNave){
                		this.gameLoop.agregar(unaVista);
                	}
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
                                System.out.println(arg0.toString());
                                notificarEventoTeclado(arg0.getKeyChar());
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
                        	notificarEvento(arg0.getX(),arg0.getY());
                                }});
        }

        private JPanel addSuperficiePanel() {
                JPanel panel = new SuperficiePanel();
                panel.setBackground(new Color(0,0,0));
                panel.setBounds(42, 53, relacionTableroVentanaX()+10,relacionTableroVentanaY()+10);
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
        	
        	if (!(this.getPartida().getEstadoDelJuego())){
        		this.gameLoop.detenerEjecucion();
        	} else {
        		for (Bomba unaBomba : this.getPartida().getBombas()) {
        			this.gameLoop.agregar(unaBomba);
        			this.gameLoop.agregar(unaBomba.generarVistaBomba());
        		}
        	}
        }

		public static int relacionTableroVentanaX() {
			return relacionTableroVentanaX;
		}
    
        public static int relacionTableroVentanaY() {
			// TODO Auto-generated method stub
			return relacionTableroVentanaY;
		}
        
        public static int getAumentoVentana() {
        	return aumento;
        }
        
        public Partida getPartida() {return this.miPartida;}
        
        private void agregarObservadorMouse(ObservadorMouse observador){
    		this.observadoresMouse.add(observador);	
    	}
        private void agregarObservadorTeclado(ObservadorTeclado observador){
    		this.observadoresTeclado.add(observador);	
    	}
        public void notificarEvento(int x, int y){
    		for(ObservadorMouse observador : observadoresMouse)
    		observador.notificarEvento(x, y);
    		
    	}
        private void notificarEventoTeclado(char key){
        	for(ObservadorTeclado observador : observadoresTeclado)
        		observador.notificarEvento(key);
        }
}
