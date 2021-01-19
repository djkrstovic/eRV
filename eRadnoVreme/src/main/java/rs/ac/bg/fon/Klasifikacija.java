package rs.ac.bg.fon;

public class Klasifikacija {
    private long ID_KLASIFIKACIJA_CASOVA;
    private String NAZIV;

    public Klasifikacija() {
    }

    public Klasifikacija(long ID_KLASIFIKACIJA_CASOVA, String NAZIV) {
        this.ID_KLASIFIKACIJA_CASOVA = ID_KLASIFIKACIJA_CASOVA;
        this.NAZIV = NAZIV;
    }

    public long getID_KLASIFIKACIJA_CASOVA() {
        return ID_KLASIFIKACIJA_CASOVA;
    }

    public void setID_KLASIFIKACIJA_CASOVA(long ID_KLASIFIKACIJA_CASOVA) {
        this.ID_KLASIFIKACIJA_CASOVA = ID_KLASIFIKACIJA_CASOVA;
    }

    public String getNAZIV() {
        return NAZIV;
    }

    public void setNAZIV(String NAZIV) {
        this.NAZIV = NAZIV;
    }

    @Override
    public String toString() {
        return "Klasifikacija{" +
                "ID_KLASIFIKACIJA_CASOVA=" + ID_KLASIFIKACIJA_CASOVA +
                ", NAZIV='" + NAZIV + '\'' +
                '}';
    }
}
