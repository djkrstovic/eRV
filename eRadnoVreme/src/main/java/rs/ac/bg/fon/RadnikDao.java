package rs.ac.bg.fon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class RadnikDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RadnikDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Radnik> list(){
        String sql = "SELECT * FROM RADNIK ORDER BY ID_RADNIK";

        List<Radnik> listRadnik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Radnik.class));

        return listRadnik;

    }

    public void save(Radnik radnik){
        SimpleJdbcInsert insertRadnik = new SimpleJdbcInsert(jdbcTemplate);
        insertRadnik.withTableName("Radnik").usingColumns("ID_RADNIK","JMBG", "PREZIME_IME", "DATUM_RODJENJA",
                "ZANIMANJE", "STEPEN_STRUCNE_SPREME", "IDENTIFIKATOR_CASOVA_RADA", "ID_KOEFICIJENT",
                "ID_RADNO_MESTO");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(radnik);
        insertRadnik.execute(param);
    }

    public Radnik get(long ID_RADNIK){

        String sql = "SELECT * FROM RADNIK WHERE ID_RADNIK = ?";
        Object[] args = {ID_RADNIK};
        Radnik radnik = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Radnik.class));

        return radnik;
    }

    public void update(Radnik radnik) {

            String sql = "UPDATE RADNIK SET JMBG=:JMBG, PREZIME_IME=:PREZIME_IME, DATUM_RODJENJA=:DATUM_RODJENJA, ZANIMANJE=:ZANIMANJE, STEPEN_STRUCNE_SPREME=:STEPEN_STRUCNE_SPREME, IDENTIFIKATOR_CASOVA_RADA=:IDENTIFIKATOR_CASOVA_RADA, ID_KOEFICIJENT=:ID_KOEFICIJENT, ID_RADNO_MESTO=:ID_RADNO_MESTO WHERE ID_RADNIK =:ID_RADNIK";

                BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(radnik);
                NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

                template.update(sql, param);

    }

    public void delete(long ID_RADNIK){
        String sql = "DELETE FROM RADNIK WHERE ID_RADNIK = ?";
        jdbcTemplate.update(sql, ID_RADNIK);
    }

}
