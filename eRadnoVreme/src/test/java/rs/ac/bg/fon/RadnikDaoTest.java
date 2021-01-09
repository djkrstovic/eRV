package rs.ac.bg.fon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RadnikDaoTest {

    private RadnikDao dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSource.setUsername("c##krstovic");
        dataSource.setPassword("1312");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new RadnikDao(new JdbcTemplate(dataSource));

    }

    @Test
    void list() {
        List<Radnik> listRadnik = dao.list();

        assertFalse(listRadnik.isEmpty());
    }

    @Test
    void save() {
        Radnik radnik = new Radnik(24 ,"0201997999555", "Perislava Peric", "02.01.1997", "Dipl. inzenjer", "7.1", 1,3,3);
        dao.save(radnik);
    }

    @Test
    void get() {
        int ID_RADNIK = 13;
        Radnik radnik = dao.get(ID_RADNIK);

        assertNotNull(radnik);
    }

    @Test
    void update() {
        Radnik radnik = new Radnik();
        radnik.setID_RADNIK(23);
        radnik.setJMBG("1234567888999");
        radnik.setPREZIME_IME("Milan Markovic");
        radnik.setDATUM_RODJENJA("12-JAN-67");
        radnik.setZANIMANJE("Perac prozora");
        radnik.setSTEPEN_STRUCNE_SPREME("7.3");
        radnik.setIDENTIFIKATOR_CASOVA_RADA(5);
        radnik.setID_KOEFICIJENT(3);
        radnik.setID_RADNO_MESTO(7);

        dao.update(radnik);
    }

    @Test
    void delete() {
    }
}