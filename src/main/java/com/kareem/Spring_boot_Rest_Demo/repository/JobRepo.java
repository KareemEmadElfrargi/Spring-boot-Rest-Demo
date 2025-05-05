package com.kareem.Spring_boot_Rest_Demo.repository;

import com.kareem.Spring_boot_Rest_Demo.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class JobRepo {

    private final List<JobPost> jobPostList = new ArrayList<>(Arrays.asList(
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

    public void addJob(JobPost jobPost) {
        jobPostList.add(jobPost);
    }

    public List<JobPost> getAllJobs() {
        System.out.println(jobPostList);

        return Collections.unmodifiableList(jobPostList);
    }

    public JobPost getPost(int i) {
        for (JobPost job : jobPostList) {
            if (job.getPostId() == i) {
                return job;
            }
        }
        return null;
    }

    public void updatePost(JobPost jobPost) {
        jobPostList.forEach(storeJobPost -> {
            if (storeJobPost.getPostId() == jobPost.getPostId()) {
                storeJobPost.setPostProfile(jobPost.getPostProfile());
                storeJobPost.setPostDesc(jobPost.getPostDesc());
                storeJobPost.setPostTechStack(jobPost.getPostTechStack());
                storeJobPost.setReqExperience(jobPost.getReqExperience());
                System.out.println("Job Post with id " + jobPost.getPostId() + " Updated");
            }
        });

    }

    public void deleteJob(int postId) {
        jobPostList.forEach(storePost->{
            if (storePost.getPostId() == postId){
                jobPostList.remove(storePost);
            }
        });
    }
}
