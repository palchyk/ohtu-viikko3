/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Toiminto implements Komento {


    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tulos = tuloskentta;
        this.syote = syotekentta;
        this.sovellus = sovellus;
        this.undo = undo;
    }

    public void suorita() {
        undo.disableProperty().set(false);
        hankiEdellinen();
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syote.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(arvo);
        tulos.setText("" + sovellus.tulos());
        syote.setText("");

    }
     public void peru() {
         if(stack.size()==0)return;
        tulos.setText("" + stack.pop());
        sovellus.plus(Integer.parseInt(stack.peek()));
        syote.setText(""+ stack.pop());
        undo.disableProperty().set(true);

    }
}