package model;

import java.util.Random;

public class RandomInt {

    public RandomInt() {}
    
    public static int generarRandomEntre(int valorInicial,int valorFinal) {
            
            Random rnd = new Random();
            return (int)((rnd.nextDouble()*valorFinal)+valorInicial);
    }
}
