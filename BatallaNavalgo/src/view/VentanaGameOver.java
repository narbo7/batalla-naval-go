package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaGameOver {
	
        
	    JFrame frame;   
	    public VentanaGameOver() {
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
	        frame.setBounds(120, 120, 200, 100);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setTitle("GAME OVER");
	        JLabel juegoTerminado = new JLabel("GAME OVER");
	            
	        
	        juegoTerminado.setForeground(new Color(255,0,0));
	        juegoTerminado.setBounds(200,210,10,30);
	        
	        frame.getContentPane().add(juegoTerminado);
	        
	        frame.setResizable(false);
	      
	   }
	        
	   public JFrame getFrame() {return this.frame;}

	}



