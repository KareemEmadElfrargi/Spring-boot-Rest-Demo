package com.kareem.Spring_boot_Rest_Demo.service;

import com.kareem.Spring_boot_Rest_Demo.model.JobPost;
import com.kareem.Spring_boot_Rest_Demo.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {


    @Autowired
    JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.save(jobPost);

    }

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    public void deleteJob(int id) {
        jobRepo.deleteById(id);
    }

    public JobPost getJobById(int id) {
        return jobRepo.findById(id).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.save(jobPost);

    }


    public void load() {
        List<JobPost> jobPostList = new ArrayList<>(Arrays.asList(
                new JobPost(
                        1,
                        "Java Developer",
                        "We are looking for a passionate Java Developer to design and develop high-volume applications.",
                        2,
                        Arrays.asList("Java", "Spring Boot", "Hibernate", "MySQL")
                ),
                new JobPost(
                        2,
                        "Frontend Developer",
                        "Join our team to build modern and interactive user interfaces.",
                        1,
                        Arrays.asList("HTML", "CSS", "JavaScript", "React")
                ),
                new JobPost(
                        3,
                        "Data Scientist",
                        "Analyze large amounts of raw information to find patterns and use them to optimize business operations.",
                        3,
                        Arrays.asList("Python", "TensorFlow", "Pandas", "Machine Learning")
                ),
                new JobPost(
                        4,
                        "DevOps Engineer",
                        "Implement integrations requested by customers and deploy updates automatically without downtime.",
                        4,
                        Arrays.asList("Docker", "Kubernetes", "AWS", "Linux")
                ),
                new JobPost(
                        5,
                        "Mobile App Developer",
                        "Develop high-quality mobile applications for Android and iOS platforms.",
                        2,
                        Arrays.asList("Flutter", "Dart", "Firebase")
                )
        ));
        jobRepo.saveAll(jobPostList);
    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDesc(keyword,keyword);
    }
}
