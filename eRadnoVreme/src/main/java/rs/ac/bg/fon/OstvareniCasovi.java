package rs.ac.bg.fon;

public class OstvareniCasovi {
    private int BROJ_SATI_ZA_DAN;
    private String NAZIV;
    private String MESEC;
    private int ID_MESECNA_EVIDENCIJA;
    private int ID_VRSTA_PRIMANJA;
    private int DAN_U_MESECU;
    private int ID_OSTVARENI_CASOVI;

    public OstvareniCasovi() {
    }

    public OstvareniCasovi(int BROJ_SATI_ZA_DAN, String NAZIV, String MESEC, int ID_MESECNA_EVIDENCIJA, int ID_VRSTA_PRIMANJA, int DAN_U_MESECU, int ID_OSTVARENI_CASOVI) {
        this.BROJ_SATI_ZA_DAN = BROJ_SATI_ZA_DAN;
        this.NAZIV = NAZIV;
        this.MESEC = MESEC;
        this.ID_MESECNA_EVIDENCIJA = ID_MESECNA_EVIDENCIJA;
        this.ID_VRSTA_PRIMANJA = ID_VRSTA_PRIMANJA;
        this.DAN_U_MESECU = DAN_U_MESECU;
        this.ID_OSTVARENI_CASOVI = ID_OSTVARENI_CASOVI;
    }

    @Override
    public String toString() {
        return "OstvareniCasovi{" +
                "BROJ_SATI_ZA_DAN=" + BROJ_SATI_ZA_DAN +
                ", NAZIV='" + NAZIV + '\'' +
                ", MESEC='" + MESEC + '\'' +
                ", ID_MESECNA_EVIDENCIJA=" + ID_MESECNA_EVIDENCIJA +
                ", ID_VRSTA_PRIMANJA=" + ID_VRSTA_PRIMANJA +
                ", DAN_U_MESECU=" + DAN_U_MESECU +
                ", ID_OSTVARENI_CASOVI=" + ID_OSTVARENI_CASOVI +
                '}';
    }

    public int getBROJ_SATI_ZA_DAN() {
        return BROJ_SATI_ZA_DAN;
    }

    public void setBROJ_SATI_ZA_DAN(int BROJ_SATI_ZA_DAN) {
        this.BROJ_SATI_ZA_DAN = BROJ_SATI_ZA_DAN;
    }

    public String getNAZIV() {
        return NAZIV;
    }

    public void setNAZIV(String NAZIV) {
        this.NAZIV = NAZIV;
    }

    public String getMESEC() {
        return MESEC;
    }

    public void setMESEC(String MESEC) {
        this.MESEC = MESEC;
    }

    public int getID_MESECNA_EVIDENCIJA() {
        return ID_MESECNA_EVIDENCIJA;
    }

    public void setID_MESECNA_EVIDENCIJA(int ID_MESECNA_EVIDENCIJA) {
        this.ID_MESECNA_EVIDENCIJA = ID_MESECNA_EVIDENCIJA;
    }

    public int getID_VRSTA_PRIMANJA() {
        return ID_VRSTA_PRIMANJA;
    }

    public void setID_VRSTA_PRIMANJA(int ID_VRSTA_PRIMANJA) {
        this.ID_VRSTA_PRIMANJA = ID_VRSTA_PRIMANJA;
    }

    public int getDAN_U_MESECU() {
        return DAN_U_MESECU;
    }

    public void setDAN_U_MESECU(int DAN_U_MESECU) {
        this.DAN_U_MESECU = DAN_U_MESECU;
    }
    public int getID_OSTVARENI_CASOVI() {
        return ID_OSTVARENI_CASOVI;
    }

    public void setID_OSTVARENI_CASOVI(int ID_OSTVARENI_CASOVI) {
        this.ID_OSTVARENI_CASOVI = ID_OSTVARENI_CASOVI;
    }
}
