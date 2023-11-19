class Paszport extends Dokument
{
    public Paszport(Osoba o){
        super(o);
    }
    public String toString()
    {
        return "paszport "+ o.imie+" "+ o.nazwisko+" "+ o.rokUrodzenia;
    }
}