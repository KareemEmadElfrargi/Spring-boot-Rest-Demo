package com.kareem.Spring_boot_Rest_Demo.service;

import com.kareem.Spring_boot_Rest_Demo.model.JobPost;
import com.kareem.Spring_boot_Rest_Demo.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;

    public void addJob(JobPost jobPost){
        jobRepo.addJob(jobPost);

    }
    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }

    public JobPost getPost(int i) {
        return jobRepo.getPost(i);
    }

    public void updatePost(JobPost jobPost) {
        jobRepo.updatePost(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepo.deleteJob(postId);
    }
}
