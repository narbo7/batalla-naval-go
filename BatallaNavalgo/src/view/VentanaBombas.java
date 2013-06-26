package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;
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
        frame.setBounds(100, 100, 250, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BOMBAS");
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
        JLabel texto = new JLabel("Ingrese el numero de la bomba a lanzar:");
        
        frame.getContentPane().add(texto);
        frame.getContentPane().add(bombaUno);
        frame.getContentPane().add(bombaDos);
        frame.getContentPane().add(bombaTres);
        frame.getContentPane().add(bombaCuatro);
        frame.getContentPane().add(bombaCinco);
        
        frame.setResizable(false);
      
   }
        
   public JFrame getFrame() {return this.frame;}

}
