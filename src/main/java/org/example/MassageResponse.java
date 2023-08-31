package org.example;

import java.util.List;

public class MassageResponse {

    private List<Massage> massages;

    private String error;

    public MassageResponse(List<Massage> massages) {
        this.massages = massages;
    }

    public MassageResponse(String error) {
        this.error = error;
    }

    public List<Massage> getMassages() {
        return massages;
    }

    public void setMassages(List<Massage> massages) {
        this.massages = massages;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
