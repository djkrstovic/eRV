package rs.ac.bg.fon;

public class RadnoMesto {
    private long ID_RADNO_MESTO;
    private String NAZIV;
    private int BR_IZVRSILACA;
    private String DATUM_OD;
    private String DATUM_DO;
    private int ID_KOEFICIJENT;

    public RadnoMesto() {
    }

    public RadnoMesto(long ID_RADNO_MESTO, String NAZIV, int BR_IZVRSILACA, String DATUM_OD, String DATUM_DO, int ID_KOEFICIJENT) {
        this.ID_RADNO_MESTO = ID_RADNO_MESTO;
        this.NAZIV = NAZIV;
        this.BR_IZVRSILACA = BR_IZVRSILACA;
        this.DATUM_OD = DATUM_OD;
        this.DATUM_DO = DATUM_DO;
        this.ID_KOEFICIJENT = ID_KOEFICIJENT;
    }

    @Override
    public String toString() {
        return "RadnoMesto{" +
                "ID_RADNO_MESTO=" + ID_RADNO_MESTO +
                ", NAZIV='" + NAZIV + '\'' +
                ", BR_IZVRSILACA=" + BR_IZVRSILACA +
                ", DATUM_OD='" + DATUM_OD + '\'' +
                ", DATUM_DO='" + DATUM_DO + '\'' +
                ", ID_KOEFICIJENT=" + ID_KOEFICIJENT +
                '}';
    }

    public long getID_RADNO_MESTO() {
        return ID_RADNO_MESTO;
    }

    public void setID_RADNO_MESTO(long ID_RADNO_MESTO) {
        this.ID_RADNO_MESTO = ID_RADNO_MESTO;
    }

    public String getNAZIV() {
        return NAZIV;
    }

    public void setNAZIV(String NAZIV) {
        this.NAZIV = NAZIV;
    }

    public int getBR_IZVRSILACA() {
        return BR_IZVRSILACA;
    }

    public void setBR_IZVRSILACA(int BR_IZVRSILACA) {
        this.BR_IZVRSILACA = BR_IZVRSILACA;
    }

    public String getDATUM_OD() {
        return DATUM_OD;
    }

    public void setDATUM_OD(String DATUM_OD) {
        this.DATUM_OD = DATUM_OD;
    }

    public String getDATUM_DO() {
        return DATUM_DO;
    }

    public void setDATUM_DO(String DATUM_DO) {
        this.DATUM_DO = DATUM_DO;
    }

    public int getID_KOEFICIJENT() {
        return ID_KOEFICIJENT;
    }

    public void setID_KOEFICIJENT(int ID_KOEFICIJENT) {
        this.ID_KOEFICIJENT = ID_KOEFICIJENT;
    }
}
