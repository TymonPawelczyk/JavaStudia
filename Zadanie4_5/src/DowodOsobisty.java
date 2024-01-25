class DowodOsobisty extends Dokument
{
    public DowodOsobisty(Osoba o){
        super(o);
    }
    public String toString()
    {
        return "dowod osobisty "+ o.imie+" "+ o.nazwisko+" "+ o.rokUrodzenia;
    }
}