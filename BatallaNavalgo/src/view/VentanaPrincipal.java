package view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


import javax.sound.sampled.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        private JLabel puntos;
        private GameLoop gameLoop;
        static int aumento = 50;
        static int relacionTableroVentanaX = (aumento*Tablero.getMaxColumna());
        static int relacionTableroVentanaY = (aumento*Tablero.getMaxFila());
        private LinkedList<ObservadorMouse> observadoresMouse= new LinkedList<ObservadorMouse>();	
        private LinkedList<ObservadorTeclado> observadoresTeclado= new LinkedList<ObservadorTeclado>();
        private Partida miPartida = new Partida();
        private Clip sonidoDeFondo;
        private Integer puntaje;
        static VentanaGameOver unaVentana;
        
        
        /**
         * Launch the application.
         * @throws UnsupportedAudioFileException 
         * @throws LineUnavailableException 
         * @throws IOException 
         */
        public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        	 File soundFile = new File("./sounds/piratas.wav");
             final AudioInputStream soundIn = AudioSystem.getAudioInputStream(soundFile);
             AudioFormat format = soundIn.getFormat();
             final DataLine.Info info = new DataLine.Info(Clip.class, format);
        	
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        VentanaPrincipal window = new VentanaPrincipal();
                                        window.setSonidoDeFondo((Clip)AudioSystem.getLine(info));
                                        window.getSonidoDeFondo().open(soundIn);
                                        window.getSonidoDeFondo().loop(Clip.LOOP_CONTINUOUSLY);
                                        while(window.getSonidoDeFondo().isRunning()){Thread.yield();}
                                        window.frame.setVisible(true);
                                        unaVentana = new VentanaGameOver();
                                        unaVentana.frame.setVisible(false);
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
                frame.setBounds(100, 100, 800, 700);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);
                frame.setTitle("BATALLA NAVALGO");
                
                JButton btnIniciar = this.addBotonIniciar();
                JButton btnDetener = this.addBotonDetener();
         
               
                JPanel panel = this.addSuperficiePanel();
               
                this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
                              
                this.gameLoop.agregarObservador(this);
                
                this.gameLoop.setFrecuencia(1000);
                
                this.agregarDatos();
                              
                this.inicializarModelo();
               
                this.addMouseListener(panel);
                              
                this.addKeyListener();

                this.setComponentsFocus(btnIniciar, btnDetener);

                
        }
        private void agregarDatos(){
        	 JLabel recuerde = new JLabel("Cada vez que quiera lanzar una bomba, debe antes seleccionar el tipo.");
        	 recuerde.setBounds(600,100,400,300);
             JLabel bombaUno = new JLabel("1. Disparo directo");
             bombaUno.setBounds(600,120,400,300);
             JLabel bombaDos = new JLabel("2. Mina con retardo");
             bombaDos.setBounds(600,140,400,300);
             JLabel bombaTres = new JLabel("3. Mina con doble retardo");
             bombaTres.setBounds(600,160,400,300);
             JLabel bombaCuatro = new JLabel("4. Mina por contacto");
             bombaCuatro.setBounds(600,180,400,300);
             JLabel bombaCinco = new JLabel("5. Mina con triple retardo");
             bombaCinco.setBounds(600,200,100,300);
             JLabel texto = new JLabel("Seleccione bomba a lanzar:");
             
             JLabel nave1 = new JLabel("Lancha");
             nave1.setForeground(new Color(255,0,0));
             nave1.setBounds(600,220,100,300);
             JLabel nave2 = new JLabel("Buque");
             nave2.setForeground(new Color(34,177,76));
             nave2.setBounds(600,240,200,300);
             JLabel nave3 = new JLabel("Destructor");
             nave3.setForeground(new Color(0,162,232));
             nave3.setBounds(600,260,100,300);
             JLabel nave4 = new JLabel("Rompehielo");
             nave4.setForeground(new Color(185,122,87));
             nave4.setBounds(600,280,100,300);
             JLabel nave5 = new JLabel("Portaavion");
             nave5.setForeground(new Color(195,195,195));
             nave5.setBounds(600,300,100,300);
            
             frame.getContentPane().add(recuerde);
             frame.getContentPane().add(texto);
             frame.getContentPane().add(bombaUno);
             frame.getContentPane().add(bombaDos);
             frame.getContentPane().add(bombaTres);
             frame.getContentPane().add(bombaCuatro);
             frame.getContentPane().add(bombaCinco);
             frame.getContentPane().add(nave1);
             frame.getContentPane().add(nave2);
             frame.getContentPane().add(nave3);
             frame.getContentPane().add(nave4);
             frame.getContentPane().add(nave5);
        }
        
        private void inicializarModelo() throws IOException {
        		
                this.gameLoop.agregar(this.getPartida());
                this.agregarObservadorMouse(miPartida);
                this.agregarObservadorTeclado(miPartida);
                puntaje = miPartida.getJugador().getPuntaje();
                puntos = new JLabel((String) puntaje.toString());
                JLabel lblPuntaje = new JLabel("PUNTAJE : ");
                puntos.setBounds(700,5,500,300);
                lblPuntaje.setBounds(600,5,500,300);
                frame.getContentPane().add(puntos);
                frame.getContentPane().add(lblPuntaje);
                
                

                for (Nave nave : miPartida.getNaves()) {
                	nave.setObservadorNave(nave.generarVista()) ;
                	for (VistaElementoDelJuego unaVista : nave.getObservadorNave()){
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
        	puntaje = miPartida.getJugador().getPuntaje();
        	puntos.setText(puntaje.toString());
            
        	if (!(this.getPartida().getEstadoDelJuego())){
        		this.gameLoop.detenerEjecucion();
        		//sacar la ventana del tablero
        		//imprimir un gameOver con el puntaje
        		unaVentana.frame.setVisible(true);
        	} else {
        		this.getPartida().limpiar(this.gameLoop);
        	}
        	 
        }

		public static int relacionTableroVentanaX() {
			return relacionTableroVentanaX;
		}
    
        public static int relacionTableroVentanaY() {
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

		public Clip getSonidoDeFondo() {
			return sonidoDeFondo;
		}

		public void setSonidoDeFondo(Clip sonidoDeFondo) {
			this.sonidoDeFondo = sonidoDeFondo;
		}
}
