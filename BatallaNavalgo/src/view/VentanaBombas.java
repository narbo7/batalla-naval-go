package view;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaBombas {  
        
    JFrame frame;   
    public VentanaBombas() {
    	try{
    		initialize();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
        
    private void initialize() throws IOException {
    	frame = new JFrame();
    	frame.setLayout(new FlowLayout());
		frame.setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 400, 280);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BOMBAS Y NAVES");
        JLabel recuerde = new JLabel("Cada vez que quiera lanzar una bomba, debe antes seleccionar el tipo.");
        JLabel bombaUno = new JLabel("1. Disparo directo");
        bombaUno.setBounds(10,20,10,30);
        JLabel bombaDos = new JLabel("2. Mina con retardo");
        bombaDos.setBounds(10,60,100,30);
        JLabel bombaTres = new JLabel("3. Mina con doble retardo");
        bombaTres.setBounds(10,100,100,30);
        JLabel bombaCuatro = new JLabel("4. Mina por contacto");
        bombaCuatro.setBounds(10,140,100,30);
        JLabel bombaCinco = new JLabel("5. Mina con triple retardo");
        bombaCinco.setBounds(10,180,100,30);
        JLabel texto = new JLabel("Seleccione bomba a lanzar:");
        
        JLabel nave1 = new JLabel("Lancha");
        nave1.setForeground(new Color(255,0,0));
        nave1.setBounds(10,210,100,30);
        JLabel nave2 = new JLabel("Buque");
        nave2.setForeground(new Color(34,177,76));
        nave2.setBounds(10,300,200,220);
        JLabel nave3 = new JLabel("Destructor");
        nave3.setForeground(new Color(0,162,232));
        nave3.setBounds(10,310,100,700);
        JLabel nave4 = new JLabel("Rompehielo");
        nave4.setForeground(new Color(185,122,87));
        nave4.setBounds(10,350,100,80);
        JLabel nave5 = new JLabel("Portaavion");
        nave5.setForeground(new Color(195,195,195));
        nave5.setBounds(10,390,100,90);
       
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
        
        frame.setResizable(false);
      
   }
        
   public JFrame getFrame() {return this.frame;}

}
