package com.packt.scrum1.mapper;

/**
 *
 * @author magnussj
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.packt.scrum1.domene.*;

public class PoengsumMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student = new Student();
        String tmp = rs.getString("brukernavn");
        student.setFornavn(rs.getString("fornavn"));
        student.setEtternavn(rs.getString("etternavn"));
        student.setEpost(rs.getString("brukernavn"));
        student.setBeskrivelse(rs.getString("beskrivelse"));
        return student;
    }
}