package com.trc.massage.binding;

public record Therapist(String code,
                        String name,
                        Price pricePerHour,
                        boolean refundable
) {}
