package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Pelaaja implements Pelimuodot {

    public void pelaa() {
        suorita(new Tekoaly());
    }

}
