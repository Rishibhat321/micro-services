package com.jobApp.first.job.app.controller;

import com.jobApp.first.job.app.entity.Job;
import com.jobApp.first.job.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Job>> findAll() {
     //   return jobService.findAll();
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
    //    return "Job created successfully";

        return new ResponseEntity<>("Job created successfully", HttpStatus.OK);
    }

    @GetMapping("/jobs/{theId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long theId) {
        Job job = jobService.getJobById(theId);

        if(job==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/jobs/{theId}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long theId) {
        boolean deleted = jobService.deleteJobById(theId);

        if(deleted) {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

}
