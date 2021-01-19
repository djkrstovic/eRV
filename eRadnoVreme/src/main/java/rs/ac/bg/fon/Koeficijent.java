package rs.ac.bg.fon;

public class Koeficijent {
    private long    ID_KOEFICIJENT;
    private double  BROJ;
    private String  DATUM_OD;
    private String  DATUM_DO;

    public Koeficijent() {

    }

    public Koeficijent(long ID_KOEFICIJENT, double BROJ, String DATUM_OD, String DATUM_DO) {
        this.ID_KOEFICIJENT = ID_KOEFICIJENT;
        this.BROJ = BROJ;
        this.DATUM_OD = DATUM_OD;
        this.DATUM_DO = DATUM_DO;
    }

    public long getID_KOEFICIJENT() {
        return ID_KOEFICIJENT;
    }

    public void setID_KOEFICIJENT(long ID_KOEFICIJENT) {
        this.ID_KOEFICIJENT = ID_KOEFICIJENT;
    }

    public double getBROJ() {
        return BROJ;
    }

    public void setBROJ(double BROJ) {
        this.BROJ = BROJ;
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

    @Override
    public String toString() {
        return "Koeficijent{" +
                "ID_KOEFICIJENT=" + ID_KOEFICIJENT +
                ", BROJ=" + BROJ +
                ", DATUM_OD='" + DATUM_OD + '\'' +
                ", DATUM_DO='" + DATUM_DO + '\'' +
                '}';
    }
}
