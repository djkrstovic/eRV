package rs.ac.bg.fon;


public class Radnik {
    
    private long ID_RADNIK;
    private String JMBG;
    private String PREZIME_IME;
    private String DATUM_RODJENJA;
    private String ZANIMANJE;
    private String STEPEN_STRUCNE_SPREME;
    private long IDENTIFIKATOR_CASOVA_RADA;
    private long ID_KOEFICIJENT;
    private long ID_RADNO_MESTO;

    public Radnik() {

    }

    public Radnik(long ID_RADNIK, String JMBG, String PREZIME_IME, String DATUM_RODJENJA, String ZANIMANJE, String STEPEN_STRUCNE_SPREME, long IDENTIFIKATOR_CASOVA_RADA, long ID_KOEFICIJENT, long ID_RADNO_MESTO) {
        this.ID_RADNIK = ID_RADNIK;
        this.JMBG = JMBG;
        this.PREZIME_IME = PREZIME_IME;
        this.DATUM_RODJENJA = DATUM_RODJENJA;
        this.ZANIMANJE = ZANIMANJE;
        this.STEPEN_STRUCNE_SPREME = STEPEN_STRUCNE_SPREME;
        this.IDENTIFIKATOR_CASOVA_RADA = IDENTIFIKATOR_CASOVA_RADA;
        this.ID_KOEFICIJENT = ID_KOEFICIJENT;
        this.ID_RADNO_MESTO = ID_RADNO_MESTO;
    }

    public long getID_RADNIK() {
        return ID_RADNIK;
    }

    public void setID_RADNIK(long ID_RADNIK) {
        this.ID_RADNIK = ID_RADNIK;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getPREZIME_IME() {
        return PREZIME_IME;
    }

    public void setPREZIME_IME(String PREZIME_IME) {
        this.PREZIME_IME = PREZIME_IME;
    }

    public String getDATUM_RODJENJA() {
        return DATUM_RODJENJA;
    }

    public void setDATUM_RODJENJA(String DATUM_RODJENJA) {
        this.DATUM_RODJENJA = DATUM_RODJENJA;
    }

    public String getZANIMANJE() {
        return ZANIMANJE;
    }

    public void setZANIMANJE(String ZANIMANJE) {
        this.ZANIMANJE = ZANIMANJE;
    }

    public String getSTEPEN_STRUCNE_SPREME() {
        return STEPEN_STRUCNE_SPREME;
    }

    public void setSTEPEN_STRUCNE_SPREME(String STEPEN_STRUCNE_SPREME) {
        this.STEPEN_STRUCNE_SPREME = STEPEN_STRUCNE_SPREME;
    }

    public long getIDENTIFIKATOR_CASOVA_RADA() {
        return IDENTIFIKATOR_CASOVA_RADA;
    }

    public void setIDENTIFIKATOR_CASOVA_RADA(long IDENTIFIKATOR_CASOVA_RADA) {
        this.IDENTIFIKATOR_CASOVA_RADA = IDENTIFIKATOR_CASOVA_RADA;
    }

    public long getID_KOEFICIJENT() {
        return ID_KOEFICIJENT;
    }

    public void setID_KOEFICIJENT(long ID_KOEFICIJENT) {
        this.ID_KOEFICIJENT = ID_KOEFICIJENT;
    }

    public long getID_RADNO_MESTO() {
        return ID_RADNO_MESTO;
    }

    public void setID_RADNO_MESTO(long ID_RADNO_MESTO) {
        this.ID_RADNO_MESTO = ID_RADNO_MESTO;
    }

    @Override
    public String toString() {
        return "Radnik{" +
                "ID_RADNIK=" + ID_RADNIK +
                ", JMBG=" + JMBG +
                ", PREZIME_IME='" + PREZIME_IME + '\'' +
                ", DATUM_RODJENJA='" + DATUM_RODJENJA + '\'' +
                ", ZANIMANJE='" + ZANIMANJE + '\'' +
                ", STEPEN_STRUCNE_SPREME='" + STEPEN_STRUCNE_SPREME + '\'' +
                ", IDENTIFIKATOR_CASOVA_RADA=" + IDENTIFIKATOR_CASOVA_RADA +
                ", ID_KOEFICIJENT=" + ID_KOEFICIJENT +
                ", ID_RADNO_MESTO=" + ID_RADNO_MESTO +
                '}';
    }
}
