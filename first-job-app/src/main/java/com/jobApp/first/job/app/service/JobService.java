package com.jobApp.first.job.app.service;

import com.jobApp.first.job.app.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long theId);

    void deleteJobById(Long theId);

}
