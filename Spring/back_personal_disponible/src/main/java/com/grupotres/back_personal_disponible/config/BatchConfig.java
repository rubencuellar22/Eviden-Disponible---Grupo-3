package com.grupotres.back_personal_disponible.config;

import com.grupotres.back_personal_disponible.batch.steps.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean(name = "stepDelete")
    public DeleteAllEmpleadosStep itemDeleteStep() {
        return new DeleteAllEmpleadosStep();
    }

    @Bean(name = "delete")
    public Step stepDelete() {
        return new StepBuilder("stepDelete", jobRepository)
                .tasklet(itemDeleteStep(), transactionManager)
                .build();
    }

    @Bean(name = "stepAllInOne")
    public AllInOneTasklet allInOneStep() {
        return new AllInOneTasklet();
    }

    @Bean(name = "AIO")
    public Step stepAIO() {
        return new StepBuilder("stepAllInOne", jobRepository)
                .tasklet(allInOneStep(), transactionManager)
                .build();
    }






    @Bean
    public Job job() {
        return new JobBuilder("job", jobRepository)
                .start(stepDelete())
                .next(stepAIO())
                .build();
    }
}
