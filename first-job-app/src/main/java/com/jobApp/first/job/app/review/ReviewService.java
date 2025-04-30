package com.jobApp.first.job.app.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long companyId, Long reviewId);

    void updateReview(Long companyId, Long reviewId, Review review);

}
