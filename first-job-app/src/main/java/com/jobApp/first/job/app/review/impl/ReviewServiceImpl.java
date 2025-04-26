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
    public void addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyBydId(companyId);

        if(company != null) {
            review.setCompany(company);
             reviewRepository.save(review);
        }
    }


}
