package com.rednavis.application.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by Eugene Tsydzik
 * on 4/14/18.
 */
@Data
public class BaselineJobs {
    List<Baseline> queued;
    List<Baseline> running;
}