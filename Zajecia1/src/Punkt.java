class Punkt
{
    double x;
    double y;

    Punkt(double x,double y)
    {
        this.x=x;
        this.y=y;
    }

    public String toString() //Funkcja wbudowana w Java'e. Służy do zwracania tekstowej, czytelnej dla człowieka reprezentacji obiektu.
    {
        return "[x: "+x+", y: "+y+"]";
    }

    void przesun(double x, double y){
        this.x += x;
        this.y += y;
    }
}