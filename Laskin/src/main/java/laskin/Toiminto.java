/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.util.ArrayDeque;
import java.util.Deque;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author y50u
 */
public class Toiminto {

    TextField tulos;
    TextField syote;
    Sovelluslogiikka sovellus;
    Button undo;
    Deque<String> stack = new ArrayDeque<String>();
    
    public void hankiEdellinen(){
        
        stack.push(syote.getText()+"");
        stack.push(tulos.getText()+"");
    }
    
}
