package com.intive.shopme.offer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class SearchCriteria {
    private final String key;
    private final String operation;
    private final Object value;
}
