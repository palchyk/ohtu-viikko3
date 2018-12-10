package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Pelaaja {

    Scanner scanner = new Scanner(System.in);

    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public void suorita(Tekoalyt tekoaly) {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = lue();
        String tokanSiirto;
        if (tekoaly != null) {
            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
        } else {
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = lue();
        }

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            tulosta("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = lue();
            if (tekoaly != null) {
                tokanSiirto = tekoaly.annaSiirto();
                tulosta("Tietokone valitsi: " + tokanSiirto);
                tekoaly.asetaSiirto(ekanSiirto);
            } else {
                tulosta("Toisen pelaajan siirto: ");
                tokanSiirto = lue();
            }

        }

        tulosta("");
        tulosta("Kiitos!");
        tulosta(tuomari);

    }

    public String lue() {
        return scanner.nextLine();
    }
    public void tulosta(Object s){
        System.out.println(s);
    }

}
