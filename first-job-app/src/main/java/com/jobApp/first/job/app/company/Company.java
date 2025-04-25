package com.jobApp.first.job.app.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobApp.first.job.app.entity.Job;
import com.jobApp.first.job.app.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // one company has many jobs
    @OneToMany(mappedBy = "company")
    @JsonIgnore  // to remove recursive callbacks
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
     private List<Review> reviews;

    public Company() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
