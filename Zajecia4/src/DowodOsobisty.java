class DowodOsobisty extends Dokument
{
    DowodOsobisty(Osoba o) {
        super(o);
    }

    public boolean czyPasuje(String wzorzec)
    {
        return false;
    }

    public String toString()
    {
        return "";
    }
}