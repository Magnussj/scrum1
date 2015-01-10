package com.packt.scrum1.konfig;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.packt.scrum1.repository.BrukerDatabaseJdbcTemplateRepositoryImpl;
import com.packt.scrum1.repository.BrukerRepository;
import com.packt.scrum1.service.BrukerService;
import com.packt.scrum1.service.BrukerServiceImpl;

@Configuration
@EnableWebMvc  // mvc annotation
@ComponentScan(basePackages = {"com.packt.scrum1.controller"}) // pakken der controllerne ligger
public class Konfigurasjon extends WebMvcConfigurationSupport {

    @Override
    @Bean
    public HandlerMapping resourceHandlerMapping() {
        AbstractHandlerMapping handlerMapping = (AbstractHandlerMapping) super.resourceHandlerMapping();
        handlerMapping.setOrder(-1);
        return handlerMapping;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public DataSource dataSource(){
        String url = "jdbc:mysql://team8.cvwydllpfxbi.eu-west-1.rds.amazonaws.com:3306/Team8DB";
        String username = "admin";
        String password = "admin123";
        DriverManagerDataSource dmds = new DriverManagerDataSource(url, username, password);
        dmds.setDriverClassName("com.mysql.jdbc.Driver");
        try{
            Connection con = dmds.getConnection();
            System.out.println(" *********  Konfig " + con );
            //getAllePersoner(con); //brukes for testing av oppkobling
        }catch(Exception e){
            System.out.println(" Konfig.Feil ved henting av conncetion() " + e);
        }
        return dmds;
    }
    
    @Bean 
    public BrukerRepository repository() {
        return new BrukerDatabaseJdbcTemplateRepositoryImpl();
        //return new PersonDatabaseRepositoryImpl();
    } 
    
    @Bean
    public BrukerService brukerService(){
        return new BrukerServiceImpl();
    }
}
