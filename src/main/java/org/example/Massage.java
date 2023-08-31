package org.example;

import java.time.Duration;
import java.util.List;

public class Massage {

    private String code;
    private String name;
    private String status;
    private String duration;
    private Price price;
    private List<CancellationPolicy> cancellationPolicies;


    public Massage(String code, String name, String status, Duration duration, Price price, List<CancellationPolicy> cancellationPolicies) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration.toString();
        this.price = price;
        this.cancellationPolicies = cancellationPolicies;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<CancellationPolicy> getCancellationPolicies() {
        return cancellationPolicies;
    }

    public void setCancellationPolicies(List<CancellationPolicy> cancellationPolicies) {
        this.cancellationPolicies = cancellationPolicies;
    }

}
