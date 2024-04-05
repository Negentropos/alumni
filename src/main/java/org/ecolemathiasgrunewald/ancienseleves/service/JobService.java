package org.ecolemathiasgrunewald.ancienseleves.service;

import org.ecolemathiasgrunewald.ancienseleves.model.Job;
import org.ecolemathiasgrunewald.ancienseleves.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) {
        Job savedJob;

        savedJob = jobRepository.save(job);
        return savedJob;
    }

}
