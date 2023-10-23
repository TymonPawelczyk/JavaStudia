class Ulamek {
    int a;
    int b;

    Ulamek(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return a + "/" + b;
    }

    double rozwDziesietne() {
        double x = (double) b;
        return a / x;
    }

    // Metoda dodawania ułamków
    public Ulamek plus(Ulamek innyUlamek) {
        int nowyLicznik = this.a * innyUlamek.b + this.b * innyUlamek.a;
        int nowyMianownik = this.b * innyUlamek.b;
        return skrocUlamek(new Ulamek(nowyLicznik, nowyMianownik));
    }

    // Metoda odejmowania ułamków
    public Ulamek minus(Ulamek innyUlamek) {
        int nowyLicznik = this.a * innyUlamek.b - this.b * innyUlamek.a;
        int nowyMianownik = this.b * innyUlamek.b;
        return skrocUlamek(new Ulamek(nowyLicznik, nowyMianownik));
    }

    // Metoda mnożenia ułamków
    public Ulamek razy(Ulamek innyUlamek) {
        int nowyLicznik = this.a * innyUlamek.a;
        int nowyMianownik = this.b * innyUlamek.b;
        return skrocUlamek(new Ulamek(nowyLicznik, nowyMianownik));
    }

    // Metoda do skracania ułamka
    private Ulamek skrocUlamek(Ulamek ulamek) {
        int gcd = greatestCommonDivisor(ulamek.a, ulamek.b);
        return new Ulamek(ulamek.a / gcd, ulamek.b / gcd);
    }

    // Metoda do obliczania największego wspólnego dzielnika (NWD)
    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }
}
