package com.samarat.airlinesdemoproject.dto.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteMaxSalesDto {
    private String name;
    private String description;
    private double totalSale;
}
