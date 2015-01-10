package com.packt.scrum1.mapper;

/**
 *
 * @author magnussj
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.packt.scrum1.domene.*;

public class VeilederMapper implements RowMapper<Veileder> {
    
    public Veileder mapRow(ResultSet rs, int i) throws SQLException {
        Veileder veileder = new Veileder();
        veileder.setFornavn(rs.getString("fornavn"));
        veileder.setEtternavn(rs.getString("etternavn"));
        veileder.setEpost(rs.getString("brukernavn"));
        veileder.setBeskrivelse(rs.getString("beskrivelse"));
        veileder.setPassord(rs.getString("passord"));
        return veileder;
    }
}
