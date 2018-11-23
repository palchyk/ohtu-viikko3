package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Toiminto implements Komento {


    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        
        this.tulos = tuloskentta;
        this.syote = syotekentta;
        this.sovellus = sovellus;
        this.undo = undo;
        nollaa.disableProperty().set(false);
    }

    public void suorita() {
        undo.disableProperty().set(false);
        hankiEdellinen();
        sovellus.nollaa();
        tulos.setText("" + sovellus.tulos());
        syote.setText("");
        

    }
    public void peru(){
        if(stack.size()==0)return;
        tulos.setText("" + stack.pop());
        syote.setText(""+ stack.pop());
        undo.disableProperty().set(true);
    }
}