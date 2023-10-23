class Prostokat
{
    double dlugosc;
    double szerokosc;
    Punkt wierzcholek;

    Prostokat(double dlugosc,double szerokosc)
    {
        this.dlugosc=dlugosc;
        this.szerokosc=szerokosc;
        this.wierzcholek=new Punkt(0,0);
    }

    Prostokat(double dlugosc,double szerokosc, Punkt wierzcholek)
    {
        this.dlugosc=dlugosc;
        this.szerokosc=szerokosc;
        this.wierzcholek=wierzcholek;
    }

    public String toString()
    {
        return "[dl: "+dlugosc+", sz: "+szerokosc+"]" + wierzcholek.toString();
    }

    double pole() {
        return dlugosc * szerokosc;
    }
    double obwod(){
        return dlugosc*2+szerokosc*2;
    }
    void przesun(double dx, double dy){
        this.wierzcholek.x += dx;
        this.wierzcholek.y += dy;
    }
}