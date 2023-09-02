package org.example;

import java.util.List;

public record MassageResponse(List<Massage> massages, String error) {

    public MassageResponse(List<Massage> massages) {
        this(massages, null);
    }

    public MassageResponse(String error) {
        this(null, error);
    }
}
