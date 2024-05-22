package com.grupotres.back_personal_disponible.config;

import com.grupotres.back_personal_disponible.batch.steps.ItemProcessorStep;
import com.grupotres.back_personal_disponible.batch.steps.ItemReaderStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
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

    @Bean(name = "stepReader")
    public ItemReaderStep itemReaderStep() {
        return new ItemReaderStep();
    }

    @Bean(name = "stepProcessor")
    public ItemProcessorStep itemProcessorStep() {
        return new ItemProcessorStep();
    }

    @Bean(name = "reader")
    public Step stepReader() {
        return new StepBuilder("stepReader", jobRepository)
                .tasklet(itemReaderStep(), transactionManager)
                .build();
    }

    @Bean(name = "processor")
        public Step stepProcessor() {
        return new StepBuilder("stepProcessor", jobRepository)
                .tasklet(itemProcessorStep(), transactionManager)
                .build();
    }

    @Bean
    public Job job() {
        return new JobBuilder("job", jobRepository)
                .start(stepReader()).
                next(stepProcessor())
                .build();
    }
}
