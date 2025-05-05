package com.kareem.Spring_boot_Rest_Demo.controller;

import com.kareem.Spring_boot_Rest_Demo.model.JobPost;
import com.kareem.Spring_boot_Rest_Demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping(path = "jobPosts", produces = {"application/json", "application/xml"})
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return jobService.getPost(postId);
    }

    @PostMapping(path = "jobPost", consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getPost(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updatePost(jobPost);
        return jobService.getPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        jobService.deleteJob(postId);
        return jobService.getPost(postId).getPostProfile() + "Deleted ...";
    }

}
