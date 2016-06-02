package liittyma;

import java.util.ArrayList;
import logiikka.*;

public class Main {
    public static void main(String[] args) {
        Salkku salkku = new Salkku();
        Laskuri laskuri = new Laskuri(salkku);
        Osake a = new Osake("Talvivaara", 1, 1000);
        Osake b = new Osake("Nokia", 6, 1000);
        Osake c = new Osake("Nordea", 10, 1000);
        salkku = new Salkku();

        ArrayList<Osake> osakkeet = new ArrayList();
        osakkeet.add(a);
        osakkeet.add(b);
        osakkeet.add(c);
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }
        salkku.vaihdaOsaketta(new Osake("Nokia", 5, -500));

        int vastaus = salkku.arvo();

        System.out.println(vastaus);
    }
}
