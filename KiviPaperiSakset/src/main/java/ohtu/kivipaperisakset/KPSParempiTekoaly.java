package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Pelaaja implements Pelimuodot {

    public void pelaa() {
        suorita(new TekoalyParannettu(20));

    }

}
