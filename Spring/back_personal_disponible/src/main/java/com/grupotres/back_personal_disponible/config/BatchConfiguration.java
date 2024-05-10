package com.grupotres.back_personal_disponible.config;

import com.grupotres.back_personal_disponible.model.EmpleadoProvisional;
import org.springframework.batch.core.Job;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {
    @Value("${file.input}")
    private String input;

    @Bean
    public FlatFileItemReader reader() {
        return new FlatFileItemReaderBuilder<EmpleadoProvisional>().name("empItemReader")
            .resource(new ClassPathResource(input))
            .delimited()
            .names(new String[] {"nombre", "status", "bench"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<EmpleadoProvisional>() {{
                setTargetType(EmpleadoProvisional.class);
            }})
            .build();
    }

    @Bean
    public JdbcBatchItemWriter writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<EmpleadoProvisional>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO empleado_provisional (nombre, status, bench) VALUES (:nombre, :status, :bench)")
            .dataSource(dataSource)
            .build();
    }


}
