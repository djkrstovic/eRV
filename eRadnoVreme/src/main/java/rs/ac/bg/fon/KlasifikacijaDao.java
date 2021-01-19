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
public class KlasifikacijaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlasifikacijaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klasifikacija> list(){
        String sql = "SELECT * FROM KLASIFIKACIJA_CASOVA ORDER BY ID_KLASIFIKACIJA_CASOVA";

        List<Klasifikacija> listKlasifikacija = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klasifikacija.class));

        return listKlasifikacija;
    }

    public void saveK(Klasifikacija klasifikacija){
        SimpleJdbcInsert insertKlasfikacija = new SimpleJdbcInsert(jdbcTemplate);
        insertKlasfikacija.withTableName("Klasifikacija_casova").usingColumns("ID_KLASIFIKACIJA_CASOVA","NAZIV");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klasifikacija);
        insertKlasfikacija.execute(param);
    }

    public Klasifikacija getK(long ID_KLASIFIKACIJA_CASOVA){

        String sql = "SELECT * FROM KLASIFIKACIJA_CASOVA WHERE ID_KLASIFIKACIJA_CASOVA = ?";
        Object[] args = {ID_KLASIFIKACIJA_CASOVA};
        Klasifikacija klasifikacija = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Klasifikacija.class));

        return klasifikacija;
    }

    public void updateK(Klasifikacija klasifikacija) {

        String sql = "UPDATE KLASIFIKACIJA_CASOVA SET NAZIV=:NAZIV WHERE ID_KLASIFIKACIJA_CASOVA =:ID_KLASIFIKACIJA_CASOVA";

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klasifikacija);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }

    public void deleteK(long ID_KLASIFIKACIJA_CASOVA){
        String sql = "DELETE FROM KLASIFIKACIJA_CASOVA WHERE ID_KLASIFIKACIJA_CASOVA = ?";
        jdbcTemplate.update(sql, ID_KLASIFIKACIJA_CASOVA);
    }
}
