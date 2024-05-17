package com.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.steps.ItemDescompresStep;
import com.batch.steps.ItemProcessorStep;
import com.batch.steps.ItemReaderStep;
import com.batch.steps.ItemWriterStep;

import lombok.AllArgsConstructor;

@Configuration
//@AllArgsConstructor
@EnableBatchProcessing
public class BatchConfig {

	    private final JobRepository jobRepository;
	    private final PlatformTransactionManager transactionManager;

	    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
	        this.jobRepository = jobRepository;
	        this.transactionManager = transactionManager;
	    }

	    @Bean
	    public ItemDescompresStep itemDescompresStep() {
	        return new ItemDescompresStep();
	    }

	    @Bean(name = "step1Reader")
	    public ItemReaderStep itemReaderStep() {
	        return new ItemReaderStep();
	    }

	    @Bean(name = "step2Processor")
	    public ItemProcessorStep itemProcessor() {
	        return new ItemProcessorStep();
	    }

	    @Bean(name = "step3Writer")
	    public ItemWriterStep itemWriterStep() {
	        return new ItemWriterStep();
	    }

	    @Bean(name = "reader")
	    public Step step1Reader() {
	        return new StepBuilder("step1Reader", jobRepository)
	                .tasklet(itemReaderStep(), transactionManager)
	                .build();
	    }

	    @Bean(name = "processor")
	    public Step step2Processor() {
	        return new StepBuilder("step2Processor", jobRepository)
	                .tasklet(itemProcessor(), transactionManager)
	                .build();
	    }

	    @Bean(name = "writer")
	    public Step step3Writer() {
	        return new StepBuilder("step3Writer", jobRepository)
	                .tasklet(itemWriterStep(), transactionManager)
	                .build();
	    }

	    @Bean
	    public Job job() {
	        return new JobBuilder("myJob", jobRepository)
	                .start(step1Reader())
	                .next(step2Processor())
	                .next(step3Writer())
	                .build();
	    }
	}

	
	
	
	

