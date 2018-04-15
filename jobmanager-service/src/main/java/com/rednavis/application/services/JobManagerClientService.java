package com.rednavis.application.services;

import com.rednavis.application.dto.BaselineJobs;
import com.rednavis.application.dto.SimulationJobs;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Eugene Tsydzik
 * on 4/14/18.
 */
@Log4j2
@Service
@Data
public class JobManagerClientService {

    private BaselineJobs baselineJobs;

    private SimulationJobs simulationJobs;

    @Inject
    private PropertyService propertyService;

    private ScheduledExecutorService executorService;

    @PostConstruct
    public void init() {
        executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate((this::pollForUpdate), 0, 1, TimeUnit.SECONDS);
    }

    private void pollForUpdate() {

        simulationJobs = listAllSimulatedJobs();
        System.out.println(simulationJobs);

        baselineJobs = listAllBaselinesJobs();
        System.out.println(baselineJobs);
    }

    private SimulationJobs listAllSimulatedJobs() {
        System.out.println("List all Simulated Jobs API-----------");

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(propertyService.getConnectUrl() + "/simulation/allSimulations/", SimulationJobs.class);
    }

    private BaselineJobs listAllBaselinesJobs() {
        System.out.println("List all Baselines Jobs API-----------");

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(propertyService.getConnectUrl() + "/baseline/allBaselines", BaselineJobs.class);

    }
}