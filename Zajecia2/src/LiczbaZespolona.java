class LiczbaZespolona {
    double rzeczywista;
    double urojona;

    LiczbaZespolona(double rzeczywista, double urojona) {
        this.rzeczywista = rzeczywista;
        this.urojona = urojona;
    }

     double getRzeczywista() {
        return rzeczywista;
    }

     double getUrojona() {
        return urojona;
    }

    // Metoda do dodawania dwóch liczb zespolonych
     LiczbaZespolona dodaj(LiczbaZespolona innaLiczba) {
        double nowaRzeczywista = this.rzeczywista + innaLiczba.getRzeczywista();
        double nowaUrojona = this.urojona + innaLiczba.getUrojona();
        return new LiczbaZespolona(nowaRzeczywista, nowaUrojona);
    }

    // Metoda do odejmowania dwóch liczb zespolonych
     LiczbaZespolona odejmij(LiczbaZespolona innaLiczba) {
        double nowaRzeczywista = this.rzeczywista - innaLiczba.getRzeczywista();
        double nowaUrojona = this.urojona - innaLiczba.getUrojona();
        return new LiczbaZespolona(nowaRzeczywista, nowaUrojona);
    }

    // Metoda do mnożenia dwóch liczb zespolonych
     LiczbaZespolona pomnoz(LiczbaZespolona innaLiczba) {
        double nowaRzeczywista = this.rzeczywista * innaLiczba.getRzeczywista() - this.urojona * innaLiczba.getUrojona();
        double nowaUrojona = this.rzeczywista * innaLiczba.getUrojona() + this.urojona * innaLiczba.getRzeczywista();
        return new LiczbaZespolona(nowaRzeczywista, nowaUrojona);
    }

    // Metoda do dzielenia dwóch liczb zespolonych
     LiczbaZespolona podziel(LiczbaZespolona innaLiczba) {
        double dzielnik = innaLiczba.getRzeczywista() * innaLiczba.getRzeczywista() + innaLiczba.getUrojona() * innaLiczba.getUrojona();
        double nowaRzeczywista = (this.rzeczywista * innaLiczba.getRzeczywista() + this.urojona * innaLiczba.getUrojona()) / dzielnik;
        double nowaUrojona = (this.urojona * innaLiczba.getRzeczywista() - this.rzeczywista * innaLiczba.getUrojona()) / dzielnik;
        return new LiczbaZespolona(nowaRzeczywista, nowaUrojona);
    }

    // Metoda do reprezentacji liczby zespolonej jako napisu
    @Override
     public String toString() {
        if (urojona >= 0) {
            return rzeczywista + " + " + urojona + "i";
        } else {
            return rzeczywista + " - " + (-urojona) + "i";
        }
    }
}