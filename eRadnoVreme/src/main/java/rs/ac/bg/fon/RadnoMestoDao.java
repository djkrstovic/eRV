package rs.ac.bg.fon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RadnoMestoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RadnoMestoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RadnoMesto> list(){
        String sql = "SELECT * FROM RADNO_MESTO ORDER BY ID_RADNO_MESTO";

        List<RadnoMesto> listRadnoMesto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(RadnoMesto.class));

        return listRadnoMesto;
    }

    public void saveRM(RadnoMesto radnoMesto){
        SimpleJdbcInsert insertRadnoMesto = new SimpleJdbcInsert(jdbcTemplate);
        insertRadnoMesto.withTableName("RADNO_MESTO").usingColumns("ID_RADNO_MESTO","NAZIV", "BR_IZVRSILACA", "DATUM_OD", "DATUM_DO", "ID_KOEFICIJENT");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(radnoMesto);
        insertRadnoMesto.execute(param);
    }

    public RadnoMesto getRM(long ID_RADNO_MESTO){

        String sql = "SELECT * FROM RADNO_MESTO WHERE ID_RADNO_MESTO = ?";
        Object[] args = {ID_RADNO_MESTO};
        RadnoMesto radnoMesto = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(RadnoMesto.class));

        return radnoMesto;
    }

    public void updateRM(RadnoMesto radnoMesto) {

        String sql = "UPDATE RADNO_MESTO SET NAZIV=:NAZIV, BR_IZVRSILACA=:BR_IZVRSILACA, DATUM_OD=:DATUM_OD, DATUM_DO=:DATUM_DO, ID_KOEFICIJENT=:ID_KOEFICIJENT WHERE ID_RADNO_MESTO =:ID_RADNO_MESTO";

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(radnoMesto);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }

    public void deleteRM(long ID_RADNO_MESTO){
        String sql = "DELETE FROM RADNO_MESTO WHERE ID_RADNO_MESTO = ?";
        jdbcTemplate.update(sql, ID_RADNO_MESTO);
    }
}
