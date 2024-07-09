package com.samarat.airlinesdemoproject.dto.route;

import com.samarat.airlinesdemoproject.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteMaxSalesDto {
    private Route route;
    private double totalSale;
}
