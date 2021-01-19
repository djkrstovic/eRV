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
public class VrstaPrimanjaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public VrstaPrimanjaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<VrstaPrimanja> list(){
        String sql = "SELECT * FROM VRSTA_PRIMANJA ORDER BY ID_VRSTA_PRIMANJA";

        List<VrstaPrimanja> listVrstaPrimanja = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(VrstaPrimanja.class));

        return listVrstaPrimanja;
    }

    public void saveVP(VrstaPrimanja vrstaPrimanja){
        SimpleJdbcInsert insertVrstaPrimanja = new SimpleJdbcInsert(jdbcTemplate);
        insertVrstaPrimanja.withTableName("VRSTA_PRIMANJA").usingColumns("ID_VRSTA_PRIMANJA","NAZIV", "CENA_RADA", "ID_KLASIFIKACIJA_CASOVA");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(vrstaPrimanja);
        insertVrstaPrimanja.execute(param);
    }

    public VrstaPrimanja getVP(long ID_VRSTA_PRIMANJA){

        String sql = "SELECT * FROM VRSTA_PRIMANJA WHERE ID_VRSTA_PRIMANJA = ?";
        Object[] args = {ID_VRSTA_PRIMANJA};
        VrstaPrimanja vrstaPrimanja = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(VrstaPrimanja.class));

        return vrstaPrimanja;
    }

    public void updateVP(VrstaPrimanja vrstaPrimanja) {

        String sql = "UPDATE VRSTA_PRIMANJA SET NAZIV=:NAZIV, CENA_RADA=:CENA_RADA, ID_KLASIFIKACIJA_CASOVA=:ID_KLASIFIKACIJA_CASOVA WHERE ID_VRSTA_PRIMANJA =:ID_VRSTA_PRIMANJA";

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(vrstaPrimanja);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }

    public void deleteVP(long ID_VRSTA_PRIMANJA){
        String sql = "DELETE FROM VRSTA_PRIMANJA WHERE ID_VRSTA_PRIMANJA = ?";
        jdbcTemplate.update(sql, ID_VRSTA_PRIMANJA);
    }
}
