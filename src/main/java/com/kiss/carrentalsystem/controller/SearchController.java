package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping(path = "/searchMakeModel/{toSearch}")
    public List<?> searchByMakeModel(@PathVariable String toSearch) {
        return searchService.searchByMakeModel(toSearch);
    }

    @GetMapping(path = "/searchMilage/{minMilage}/{maxMilage}")
    public List<?> searchByMilage(@PathVariable int minMilage, @PathVariable int maxMilage) {
        return searchService.searchByMilage(minMilage, maxMilage);
    }

    @GetMapping(path = "/searchType/{toSearch}")
    public List<?> searchByType(@PathVariable String toSearch) {
        return searchService.searchByType(toSearch);
    }
}
