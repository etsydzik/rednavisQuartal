package com.rednavis.application.services;

import com.rednavis.application.dto.BaselineJobs;
import com.rednavis.application.dto.SimulationJobs;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

/**
 * Created by Eugene Tsydzik
 * on 4/14/18.
 */
@Service
public class JobManagerClientService {

    private BaselineJobs baselineJobs;

    private SimulationJobs simulationJobs;

    @Inject
    private PropertyService propertyService;

    @Scheduled(fixedRate = 1000)
    public void pollForUpdate() {

        simulationJobs = listAllSimulatedJobs();
        System.out.println(simulationJobs);

        baselineJobs = listAllBaselinesJobs();
        System.out.println(baselineJobs);
    }

    private SimulationJobs listAllSimulatedJobs() {
        System.out.println("ListAllSimulatedJobs API-----------");

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(propertyService.getConnectUrl() + "/simulation/allSimulations/", SimulationJobs.class);
    }

    private BaselineJobs listAllBaselinesJobs() {
        System.out.println("ListAllBaselinesJobs API-----------");

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(propertyService.getConnectUrl() + "/baseline/allBaselines", BaselineJobs.class);

    }
}