package com.jobApp.first.job.app.service.impl;

import com.jobApp.first.job.app.entity.Job;
import com.jobApp.first.job.app.repository.JobRepository;
import com.jobApp.first.job.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

 //   private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepository.save(job);
    //    System.out.println("Job created successfully");

    }

    @Override
    public Job getJobById(Long theId) {
/*
        for(Job job: jobs) {

            if(job.getId().equals(theId)) {
                return job;
            }
        }

        return null;  */

        // findById returns an optional.
       return jobRepository.findById(theId).orElseThrow(() -> new RuntimeException("Job id - " + theId + " not found"));

    }

    @Override
    public boolean deleteJobById(Long theId) {

        /*
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()) {
        Job job = iterator.next();
        if(job.getId().equals(id)) {
        iterator.remove();
        return true;
        }
        }
       */

      // get the job by id
        Job job = getJobById(theId);

        if(job!=null) {
            jobs.remove(job);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateJob(Long theId, Job updatedJob) {

        for(Job job: jobs) {
            if(job.getId().equals(theId)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }

        return false;
    }

}
