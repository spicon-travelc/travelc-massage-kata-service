package org.example;

import java.time.Duration;
import java.util.List;

public record Therapist(String code,
                        String name,
                        Price pricePerHour,
                        boolean refundable
) {}
