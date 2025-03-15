package com.jobApp.first.job.app.repository;

import com.jobApp.first.job.app.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
