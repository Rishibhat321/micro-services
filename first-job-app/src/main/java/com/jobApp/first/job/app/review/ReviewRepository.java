package com.jobApp.first.job.app.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCompanyId(Long companyId);

    // no need of implementation only declaration ...

}
