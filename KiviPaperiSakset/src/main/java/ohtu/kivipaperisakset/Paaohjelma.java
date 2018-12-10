package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loop:
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            Pelimuodot peli;
            switch (vastaus) {
                case "a":
                    System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                    peli = new KPSPelaajaVsPelaaja();
                    peli.pelaa();
                    break;
                case "b":
                    System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                    peli = new KPSTekoaly();
                    peli.pelaa();
                    break;
                case "c":
                    System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                    peli = new KPSParempiTekoaly();
                    peli.pelaa();
                    break;
                default:
                     break loop;
                    

            }

        }

    }
}
