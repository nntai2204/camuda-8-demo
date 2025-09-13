package com.example.demo.service;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.stereotype.Service;

@Service
public class CamundaService {

    private final ZeebeClient client;

    public CamundaService(ZeebeClient client) {
        this.client = client;
    }

    public void deployProcess() {
        client.newDeployResourceCommand()
                .addResourceFile("src/main/resources/approve-request.bpmn")
                .send()
                .join();
        System.out.println("✅ Process deployed");
    }

    public void startProcess() {
        client.newCreateInstanceCommand()
                .bpmnProcessId("approve_request_process") // nhớ trùng với ID trong BPMN
                .latestVersion()
                .variables("{\"requestId\": 123}")
                .send()
                .join();
        System.out.println("🚀 Process instance started");
    }
}
