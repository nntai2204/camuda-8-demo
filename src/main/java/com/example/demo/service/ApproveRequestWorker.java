package com.example.demo.service;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;

@Component
public class ApproveRequestWorker {

    @ZeebeWorker(type = "approve_request")
    public void handle(final JobClient client, final ActivatedJob job) {
        System.out.println("Handling First job: " + job);

        client.newCompleteCommand(job.getKey())
                .variables("{\"approve_request\":\"APPROVED\"}")
                .send()
                .join();
        System.out.println("Completed First job!!");

    }

    @ZeebeWorker(type = "step01_approve_request")
    public void handleSecond(final JobClient client, final ActivatedJob job) {
        System.out.println("Handling Second job: " + job);

        client.newCompleteCommand(job.getKey())
                .variables("{\"step01_approve_request\":\"APPROVED\"}")
                .send()
                .join();
        System.out.println("Completed Second job!!");

    }
}
