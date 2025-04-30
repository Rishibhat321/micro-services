package com.jobApp.first.job.app.review.impl;

import com.jobApp.first.job.app.company.Company;
import com.jobApp.first.job.app.company.CompanyService;
import com.jobApp.first.job.app.review.Review;
import com.jobApp.first.job.app.review.ReviewRepository;
import com.jobApp.first.job.app.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    // declared as final...
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;


    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {

        // get the company object
        Company company = companyService.getCompanyById(companyId);

        if(company != null ) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }

        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {

       List<Review> reviews =  reviewRepository.findByCompanyId(companyId);

       // filter the reviews with the review id

        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }


    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {

        if(companyService.getCompanyById(companyId) != null) {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {

        if(companyService.getCompanyById(companyId) != null &&
        reviewRepository.existsById(reviewId)) {

            // retrieve the review object
            Review review = reviewRepository.findById(reviewId).orElse(null);
            // retrieve the company
            Company company = review.getCompany();
            // removing review from company reference  (bidirectional)
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company ,companyId);
            // deleting the review
            reviewRepository.deleteById(reviewId);
            return true;
        }

        return false;
    }


}
