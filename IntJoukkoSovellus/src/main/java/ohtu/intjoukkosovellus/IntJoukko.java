package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;                     // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;                       // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;                            // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;                       // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukujono = new int[KAPASITEETTI];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti >= 0) {
            lukujono = new int[kapasiteetti];
            for (int i = 0; i < lukujono.length; i++) {
                lukujono[i] = 0;
            }
            alkioidenLkm = 0;
            this.kasvatuskoko = OLETUSKASVATUS;
        }
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti >= 0 && kasvatuskoko >= 0) {
            lukujono = new int[kapasiteetti];
            for (int i = 0; i < lukujono.length; i++) {
                lukujono[i] = 0;
            }
            alkioidenLkm = 0;
            this.kasvatuskoko = kasvatuskoko;
        }
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            lukujono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        lisaaKuuluva(luku);
        return false;
    }

    public boolean lisaaKuuluva(int luku) {
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujono.length == 0) {
                uusiTaulukko();
            }
        }
        return true;
    }

    public void uusiTaulukko() {
        int[] taulukkoOld = lukujono;
        kopioiTaulukko(lukujono, taulukkoOld);
        lukujono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, lukujono);

    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                lukujono[i] = 0;
                refaktoroiTaulukko(i);
                return true;
            }
        }
        return false;
    }

    private void refaktoroiTaulukko(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = lukujono[j];
            lukujono[j] = lukujono[j + 1];
            lukujono[j + 1] = apu;
        }
        alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuloste = "";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuloste += ", " + lukujono[i];
            if (i == 0) {
                tuloste = tuloste.substring(2);
            }
        }
        return "{" + tuloste + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) {
            x.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.toIntArray().length; i++) {
            x.lisaa(b.toIntArray()[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) {
            for (int j = 0; j < b.toIntArray().length; j++) {
                if (a.toIntArray()[i] == b.toIntArray()[j]) {
                    y.lisaa(b.toIntArray()[j]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) {
            z.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.toIntArray().length; i++) {
            z.poista(i);
        }
        return z;
    }

}
