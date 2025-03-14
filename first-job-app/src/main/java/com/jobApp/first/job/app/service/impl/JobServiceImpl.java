package com.jobApp.first.job.app.service.impl;

import com.jobApp.first.job.app.entity.Job;
import com.jobApp.first.job.app.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    //    System.out.println("Job created successfully");

    }
}
