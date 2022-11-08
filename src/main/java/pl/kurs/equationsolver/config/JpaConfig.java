package pl.kurs.equationsolver.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.kurs.equationsolver.model.SolvingEventRepository;

import javax.sql.DataSource;

@Configuration
//@EnableJpaRepositories(basePackages = "pl.kurs.equationsolver.model")
//@EnableTransactionManagement
//@PropertySource("persistence-event.properties")
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
