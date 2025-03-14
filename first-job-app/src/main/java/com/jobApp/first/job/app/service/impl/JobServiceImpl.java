package com.jobApp.first.job.app.service.impl;

import com.jobApp.first.job.app.entity.Job;
import com.jobApp.first.job.app.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    //    System.out.println("Job created successfully");

    }
}
