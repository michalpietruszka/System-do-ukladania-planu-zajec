package Case;

public class Przedmioty {
    private String nazwa;
    private String prowadzacy;
    private int liczbaEcts;
    private String dzienTygodnia;
    private int godzina;
    private String sala;

    public Przedmioty(String nazwa, String prowadzacy, int liczbaEcts, String dzienTygodnia, int godzina, String sala) {
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
        this.liczbaEcts = liczbaEcts;
        this.dzienTygodnia = dzienTygodnia;
        this.godzina = godzina;
        this.sala = sala;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public int getLiczbaEcts() {
        return liczbaEcts;
    }

    public void setLiczbaEcts(int liczbaEcts) {
        this.liczbaEcts = liczbaEcts;
    }

    public String getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(String dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    public int getGodzina() {
        return godzina;
    }

    public void setGodzina(int godzina) {
        this.godzina = godzina;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Przedmiot-> " +
                "nazwa: '" + nazwa + '\'' +
                ", prowadzacy: '" + prowadzacy + '\'' +
                ", liczbaEcts: " + liczbaEcts +
                ", dzienTygodnia: '" + dzienTygodnia + '\'' +
                ", godzina: " + godzina +
                ", sala: '" + sala + '\'';
    }

    public String toStringFormal() {
        return  nazwa + ", " + prowadzacy + ", " + liczbaEcts +
                " ECTS, " +
                ", godz. " + godzina +
                ":00, " + sala + '\n'+System.getProperty( "line.separator" );
    }
}
