package com.packt.scrum1.repository;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import com.packt.scrum1.domene.*;
import com.packt.scrum1.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BrukerDatabaseJdbcTemplateRepositoryImpl implements BrukerRepository {
    private Connection connection;
    private final String sqlLeggTilStudent = "insert into bruker values(?,?,?,?,?)";
    private final String sqlHentStudent = "Select * from bruker where brukernavn = ?";
    private final String sqlLeggTilVeileder = "insert into veileder values(?,?,?,?,?)";
    private final String sqlHentVeileder = "select * from veileder where brukernavn = ?";
    private final String sqlHentAdmin = "select * from super where brukernavn = ?";
    private final String sqlHentHighscoreNavn = "select brukernavn from historikk order by poeng desc limit 10";
    private final String sqlHentHighscore = "select poeng from historikk order by poeng desc limit 10";
    private final String sqlHentHistorikk = "select poeng from historikk where brukernavn = ?";
    private final String sqlHentGodkjenning = "select max(poeng) from historikk where brukernavn = ?";
    private final String sqlAntallStudenter = "select count(*) from bruker";
    private final String sqlAntallSpill = "select count(*) from historikk where brukernavn = ?";
    private final String sqlEndrePassord = "update student set passord = ? where brukernavn = ?";
    private final String sqlFinnBruker = "select * from bruker where brukernavn = ? and passord = ?";
    private final String sqlFinnVeileder = "select * from veileder where brukernavn = ? and passord = ?";
    
    private DataSource dataSource;
    JdbcTemplate jdbcTemplate;
    
    public BrukerDatabaseJdbcTemplateRepositoryImpl() {}
    
    @Autowired
    public void setDataSource(DataSource dataSource){
        System.out.println(" Database.setDataSource " + dataSource);
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public boolean sqlLeggTilStudent(Student student){
        String passord = Mail.generer();
        int i = jdbcTemplate.update(sqlLeggTilStudent, new Object[]{student.getFornavn(),student.getEtternavn(), student.getEpost(), passord, student.getBeskrivelse()});
        if(i>0){
            Mail.sendEmail(student.getEpost(), student.getFornavn(), student.getEtternavn(), passord);
            return true;
        } else {
            return false;
        }
    }
    
    public Student sqlHentStudent(String navn){
        return jdbcTemplate.queryForObject(sqlHentStudent, new Object[]{navn}, new StudentMapper());
    }
    
    public boolean sqlLeggTilVeileder(Veileder veileder){
        String passord =Mail.generer();
        int i = jdbcTemplate.update(sqlLeggTilVeileder, new Object[]{veileder.getFornavn(), veileder.getEtternavn(), veileder.getEpost(), passord, veileder.getBeskrivelse()});
        if(i>0){
            Mail.sendEmail(veileder.getEpost(), veileder.getFornavn(), veileder.getEtternavn(), passord);
            return true;
        } else {
            return false;
        }
    }
    
    public Veileder sqlHentVeileder(String navn){
        return jdbcTemplate.queryForObject(sqlHentVeileder, new Object[]{navn}, new VeilederMapper());
    }
    
    public Admin sqlHentAdmin(String navn){
        return jdbcTemplate.queryForObject(sqlHentAdmin, new Object[]{navn}, new AdminMapper());
    }
    public Bruker loggInn(String brukernavn, String passord){
        Student i = jdbcTemplate.queryForObject(sqlFinnBruker, new Object[]{brukernavn, passord}, new StudentMapper());
        if(i.getFornavn() != null){
            return sqlHentStudent(brukernavn);
        }else{
            Veileder j = jdbcTemplate.queryForObject(sqlFinnVeileder, new Object[]{brukernavn, passord}, new VeilederMapper());
            if(j.getFornavn() != null){
                return sqlHentVeileder(brukernavn);
                }else{
            Admin k = jdbcTemplate.queryForObject(sqlFinnVeileder, new Object[]{brukernavn, passord}, new AdminMapper());
            if(k.getFornavn() != null){
                return sqlHentAdmin(brukernavn);
                }else{
                    return null;
                }
            }
        }
    }
    
    public Poengsum[] sqlHentPoengsum(){
        List<String> liste = jdbcTemplate.queryForList(sqlHentHighscoreNavn, String.class);
        List<Integer> listeInt = jdbcTemplate.queryForList(sqlHentHighscore, Integer.class);
        Student[] studliste = new Student[liste.size()];
        int i = 0;
        for(String b : liste){
            studliste[i] = sqlHentStudent(b);
            i++;
        }
        Poengsum[] poeng = new Poengsum[liste.size()];
        for(i = 0; i<poeng.length; i++){
            poeng[i] = new Poengsum(studliste[i], listeInt.get(i));
        }
        return poeng;
    }
    public List<Integer> sqlHentHistorikk(String navn){
        return jdbcTemplate.queryForList(sqlHentHistorikk, new Object[]{navn}, Integer.class);
    }
    public boolean sqlGodkjenning(String navn){
        List<Integer> liste = jdbcTemplate.queryForList(sqlHentGodkjenning,new Object[]{navn}, Integer.class);
        return liste.get(0)>= 50;
    }
    
    public int sqlAntallStudenter(){
        return jdbcTemplate.queryForInt(sqlAntallStudenter);
    }
    
    public int sqlAntallSpill(){
        return jdbcTemplate.queryForInt(sqlAntallSpill);
    }
    
    public boolean sqlEndrePassord(String passord, String navn){
        int i = jdbcTemplate.update(sqlEndrePassord, new Object[]{passord, navn});
        return i != 0;
    }
    
}
