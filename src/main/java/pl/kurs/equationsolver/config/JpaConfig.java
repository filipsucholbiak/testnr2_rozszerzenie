package pl.kurs.equationsolver.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Profile({"prod", "dev"})
    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter, DataSource ds) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setJpaVendorAdapter(adapter);
        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("pl.kurs.equationsolver.model");
        emf.setDataSource(ds);
        return emf;
    }

    @Profile("prod")
    @Bean
    public JpaVendorAdapter createVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Profile("prod")
    @Bean
    public static DataSource getDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl("jdbc:mysql://localhost:3306/equation_solver?useSSL=false&serverTimezone=UTC");
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setMinIdle(5);
        bds.setMaxIdle(20);
        return bds;
    }


    @Profile("dev")
    @Bean
    public JpaVendorAdapter createVendorAdapterDev() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Profile("dev")
    @Bean
    public static DataSource getDataSourceDev() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl("jdbc:h2:mem:testdb");
        bds.setUsername("sa");
        bds.setPassword("");
        bds.setMinIdle(5);
        bds.setMaxIdle(20);
        return bds;
    }
}
