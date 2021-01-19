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
public class MesecnaEvidencijaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MesecnaEvidencijaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MesecnaEvidencija> list(){
        String sql = "SELECT * FROM MESECNA_EVIDENCIJA ORDER BY ID_MESECNA_EVIDENCIJA";

        List<MesecnaEvidencija> listMesecnaEvidencija = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(MesecnaEvidencija.class));

        return listMesecnaEvidencija;
    }

    public void saveME(MesecnaEvidencija mesecnaEvidencija){
        SimpleJdbcInsert insertMesecnaEvidencija = new SimpleJdbcInsert(jdbcTemplate);
        insertMesecnaEvidencija.withTableName("MESECNA_EVIDENCIJA").usingColumns("ID_MESECNA_EVIDENCIJA","MESEC", "ID_RADNIK", "PROCENJENA_ZARADA");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(mesecnaEvidencija);
        insertMesecnaEvidencija.execute(param);
    }

    public MesecnaEvidencija getME(long ID_MESECNA_EVIDENCIJA){

        String sql = "SELECT * FROM MESECNA_EVIDENCIJA WHERE ID_MESECNA_EVIDENCIJA = ?";
        Object[] args = {ID_MESECNA_EVIDENCIJA};
        MesecnaEvidencija mesecnaEvidencija = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(MesecnaEvidencija.class));

        return mesecnaEvidencija;
    }

    public void updateME(MesecnaEvidencija mesecnaEvidencija) {

        String sql = "UPDATE MESECNA_EVIDENCIJA SET MESEC=:MESEC, PREZIME_IME=:PREZIME_IME, ID_RADNIK=:ID_RADNIK WHERE ID_MESECNA_EVIDENCIJA =:ID_MESECNA_EVIDENCIJA";

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(mesecnaEvidencija);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }

    public void deleteME(long ID_MESECNA_EVIDENCIJA){
        String sql = "DELETE FROM MESECNA_EVIDENCIJA WHERE ID_MESECNA_EVIDENCIJA = ?";
        jdbcTemplate.update(sql, ID_MESECNA_EVIDENCIJA);
    }
}
