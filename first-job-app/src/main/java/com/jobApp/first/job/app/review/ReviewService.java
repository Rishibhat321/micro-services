package com.jobApp.first.job.app.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    void addReview(Long companyId, Review review);

}
