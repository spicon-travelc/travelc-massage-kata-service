package org.example;

import java.time.Duration;
import java.util.List;

public record Massage(String code, String name, String status, Duration duration, List<CancellationPolicy> cancellationPolicies) {
}
