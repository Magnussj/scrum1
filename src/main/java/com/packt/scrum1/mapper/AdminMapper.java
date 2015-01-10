package com.packt.scrum1.mapper;

/**
 *
 * @author magnussj
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.packt.scrum1.domene.*;

public class AdminMapper implements RowMapper<Admin> {

    public Admin mapRow(ResultSet rs, int i) throws SQLException {
        Admin admin = new Admin();
        admin.setFornavn(rs.getString("fornavn"));
        admin.setEtternavn(rs.getString("etternavn"));
        admin.setEpost(rs.getString("brukernavn"));
        admin.setBeskrivelse(rs.getString("beskrivelse"));
        admin.setPassord(rs.getString("passord"));
        return admin;
    }
}