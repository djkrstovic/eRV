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
public class OstvareniCasoviDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OstvareniCasoviDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OstvareniCasovi> list(){
        String sql = "SELECT * FROM OSTVARENI_CASOVI ORDER BY ID_MESECNA_EVIDENCIJA";

        List<OstvareniCasovi> listOstvareniCasovi = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OstvareniCasovi.class));

        return listOstvareniCasovi;
    }

    public void saveOC(OstvareniCasovi ostvareniCasovi){
        SimpleJdbcInsert insertOstvareniCasovi = new SimpleJdbcInsert(jdbcTemplate);
        insertOstvareniCasovi.withTableName("OSTVARENI_CASOVI").usingColumns("BROJ_SATI_ZA_DAN","ID_MESECNA_EVIDENCIJA", "ID_VRSTA_PRIMANJA", "DAN_U_MESECU", "ID_OSTVARENI_CASOVI");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ostvareniCasovi);
        insertOstvareniCasovi.execute(param);
    }

    public OstvareniCasovi getOC(long ID_OSTVARENI_CASOVI){

        String sql = "SELECT * FROM OSTVARENI_CASOVI WHERE ID_OSTVARENI_CASOVI = ?";
        Object[] args = {ID_OSTVARENI_CASOVI};
        OstvareniCasovi ostvareniCasovi = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(OstvareniCasovi.class));

        return ostvareniCasovi;
    }

    public void updateOC(OstvareniCasovi ostvareniCasovi) {

        String sql = "UPDATE OSTVARENI_CASOVI SET BROJ_SATI_ZA_DAN=:BROJ_SATI_ZA_DAN, ID_MESECNA_EVIDENCIJA=:ID_MESECNA_EVIDENCIJA, NAZIV=:NAZIV, MESEC=:MESEC, ID_VRSTA_PRIMANJA=:ID_VRSTA_PRIMANJA, DAN_U_MESECU=:DAN_U_MESECU WHERE ID_OSTVARENI_CASOVI =:ID_OSTVARENI_CASOVI";

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ostvareniCasovi);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }

    public void deleteOC(long ID_OSTVARENI_CASOVI){
        String sql = "DELETE FROM OSTVARENI_CASOVI WHERE ID_OSTVARENI_CASOVI = ?";
        jdbcTemplate.update(sql, ID_OSTVARENI_CASOVI);
    }
}
