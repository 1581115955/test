package com.service;

import com.bean.Street;

import java.util.List;

public interface StreetService {
    List<Street> getStreetByDistrictId(int id);

}
