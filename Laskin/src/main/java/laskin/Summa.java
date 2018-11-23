
package laskin;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Toiminto implements Komento {


    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tulos = tuloskentta;
        this.syote = syotekentta;
        this.sovellus = sovellus;
        this.undo = undo;
        System.out.println("uusi summa");

    }

    public void suorita() {
        undo.disableProperty().set(false);
        hankiEdellinen();
        
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syote.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        tulos.setText("" + sovellus.tulos());
        syote.setText("");
        

    }

    public void peru() {
        if(stack.size()==0)return;
        tulos.setText("" + stack.pop());
        sovellus.miinus(Integer.parseInt(stack.peek()));
        syote.setText(""+ stack.pop());
        undo.disableProperty().set(true);

    }
}
