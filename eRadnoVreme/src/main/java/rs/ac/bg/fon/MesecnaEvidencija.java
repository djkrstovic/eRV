package rs.ac.bg.fon;

public class MesecnaEvidencija {
    private long ID_MESECNA_EVIDENCIJA;
    private String MESEC;
    private String PREZIME_IME;
    private long ID_RADNIK;
    private float PROCENJENA_ZARADA;

    public MesecnaEvidencija() {
    }

    public MesecnaEvidencija(long ID_MESECNA_EVIDENCIJA, String MESEC, String PREZIME_IME, long ID_RADNIK, float PROCENJENA_ZARADA) {
        this.ID_MESECNA_EVIDENCIJA = ID_MESECNA_EVIDENCIJA;
        this.MESEC = MESEC;
        this.PREZIME_IME = PREZIME_IME;
        this.ID_RADNIK = ID_RADNIK;
        this.PROCENJENA_ZARADA = PROCENJENA_ZARADA;
    }

    public long getID_MESECNA_EVIDENCIJA() {
        return ID_MESECNA_EVIDENCIJA;
    }

    public void setID_MESECNA_EVIDENCIJA(long ID_MESECNA_EVIDENCIJA) {
        this.ID_MESECNA_EVIDENCIJA = ID_MESECNA_EVIDENCIJA;
    }

    public String getMESEC() {
        return MESEC;
    }

    public void setMESEC(String MESEC) {
        this.MESEC = MESEC;
    }

    public String getPREZIME_IME() {
        return PREZIME_IME;
    }

    public void setPREZIME_IME(String PREZIME_IME) {
        this.PREZIME_IME = PREZIME_IME;
    }

    public long getID_RADNIK() {
        return ID_RADNIK;
    }

    public void setID_RADNIK(long ID_RADNIK) {
        this.ID_RADNIK = ID_RADNIK;
    }

    public float getPROCENJENA_ZARADA() {
        return PROCENJENA_ZARADA;
    }

    public void setPROCENJENA_ZARADA(float PROCENJENA_ZARADA) {
        this.PROCENJENA_ZARADA = PROCENJENA_ZARADA;
    }

    @Override
    public String toString() {
        return "MesecnaEvidencija{" +
                "ID_MESECNA_EVIDENCIJA=" + ID_MESECNA_EVIDENCIJA +
                ", MESEC='" + MESEC + '\'' +
                ", PREZIME_IME='" + PREZIME_IME + '\'' +
                ", ID_RADNIK=" + ID_RADNIK +
                ", PROCENJENA_ZARADA=" + PROCENJENA_ZARADA +
                '}';
    }
}
