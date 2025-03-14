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

    @Override
    public Job getJobById(Long theId) {

        for(Job job: jobs) {

            if(job.getId().equals(theId)) {
                return job;
            }
        }

        return null;
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
