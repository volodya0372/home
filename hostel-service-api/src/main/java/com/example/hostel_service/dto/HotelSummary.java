package com.example.hostel_service.dto;

public record HotelSummary(
        Long id,
        String name,
        String description,
        String address,
        String phone
) {}
