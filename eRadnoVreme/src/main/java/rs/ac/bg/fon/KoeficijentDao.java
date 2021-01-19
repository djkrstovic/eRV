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
public class KoeficijentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KoeficijentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Koeficijent> list(){
        String sql = "SELECT * FROM KOEFICIJENT ORDER BY ID_KOEFICIJENT";

        List<Koeficijent> listKoeficijent = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Koeficijent.class));

        return listKoeficijent;
    }

    public void saveKo(Koeficijent koeficijent){
        SimpleJdbcInsert insertKoeficijent = new SimpleJdbcInsert(jdbcTemplate);
        insertKoeficijent.withTableName("KOEFICIJENT").usingColumns("ID_KOEFICIJENT","BROJ", "DATUM_OD", "DATUM_DO");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(koeficijent);
        insertKoeficijent.execute(param);
    }

    public Koeficijent getKo(long ID_KOEFICIJENT){

        String sql = "SELECT * FROM KOEFICIJENT WHERE ID_KOEFICIJENT = ?";
        Object[] args = {ID_KOEFICIJENT};
        Koeficijent koeficijent = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Koeficijent.class));

        return koeficijent;
    }

    public void updateKo(Koeficijent koeficijent) {

        String sql = "UPDATE KOEFICIJENT SET BROJ=:BROJ, DATUM_OD=:DATUM_OD, DATUM_DO=:DATUM_DO WHERE ID_KOEFICIJENT =:ID_KOEFICIJENT";

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(koeficijent);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }

    public void deleteKo(long ID_KOEFICIJENT){
        String sql = "DELETE FROM KOEFICIJENT WHERE ID_KOEFICIJENT = ?";
        jdbcTemplate.update(sql, ID_KOEFICIJENT);
    }
}
