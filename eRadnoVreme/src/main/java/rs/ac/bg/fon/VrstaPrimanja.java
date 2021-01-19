package rs.ac.bg.fon;

public class VrstaPrimanja {
    private long ID_VRSTA_PRIMANJA;
    private String NAZIV;
    private int CENA_RADA;
    private long ID_KLASIFIKACIJA_CASOVA;

    public long getID_VRSTA_PRIMANJA() {
        return ID_VRSTA_PRIMANJA;
    }

    public void setID_VRSTA_PRIMANJA(long ID_VRSTA_PRIMANJA) {
        this.ID_VRSTA_PRIMANJA = ID_VRSTA_PRIMANJA;
    }

    public String getNAZIV() {
        return NAZIV;
    }

    public void setNAZIV(String NAZIV) {
        this.NAZIV = NAZIV;
    }

    public int getCENA_RADA() {
        return CENA_RADA;
    }

    public void setCENA_RADA(int CENA_RADA) {
        this.CENA_RADA = CENA_RADA;
    }

    public long getID_KLASIFIKACIJA_CASOVA() {
        return ID_KLASIFIKACIJA_CASOVA;
    }

    public void setID_KLASIFIKACIJA_CASOVA(long ID_KLASIFIKACIJA_CASOVA) {
        this.ID_KLASIFIKACIJA_CASOVA = ID_KLASIFIKACIJA_CASOVA;
    }

    public VrstaPrimanja() {
    }

    public VrstaPrimanja(long ID_VRSTA_PRIMANJA, String NAZIV, int CENA_RADA, long ID_KLASIFIKACIJA_CASOVA) {
        this.ID_VRSTA_PRIMANJA = ID_VRSTA_PRIMANJA;
        this.NAZIV = NAZIV;
        this.CENA_RADA = CENA_RADA;
        this.ID_KLASIFIKACIJA_CASOVA = ID_KLASIFIKACIJA_CASOVA;
    }

    @Override
    public String toString() {
        return "VrstaPrimanja{" +
                "ID_VRSTA_PRIMANJA=" + ID_VRSTA_PRIMANJA +
                ", NAZIV='" + NAZIV + '\'' +
                ", CENA_RADA=" + CENA_RADA +
                ", ID_KLASIFIKACIJA_CASOVA=" + ID_KLASIFIKACIJA_CASOVA +
                '}';
    }
}
