package com.jobApp.first.job.app.controller;

import com.jobApp.first.job.app.entity.Job;
import com.jobApp.first.job.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    // constructor injection
    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job created successfully";
    }

    @GetMapping("/jobs/{theId}")
    public Job getJobById(@PathVariable Long theId) {
        Job job = jobService.getJobById(theId);

        if(job==null) {
            return new Job(1L, "TestJob", "TestJob", "2000", "3000", "loc");
        }
        return job;
    }

}
