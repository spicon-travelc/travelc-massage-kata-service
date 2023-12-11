package com.trc.massage.binding;

import java.time.Duration;
import java.util.List;

public record Massage(String code, String name, String status, Price price, Duration duration, List<CancellationPolicy> cancellationPolicies) {
}
