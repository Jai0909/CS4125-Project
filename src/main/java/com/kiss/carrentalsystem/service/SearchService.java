package com.kiss.carrentalsystem.service;

import java.util.List;
public interface SearchService {

    List<String> searchByMakeModel(String toSearch);

    List<String> searchByMilage(int milage);

    List<String> searchByType (String toSearch);
}
