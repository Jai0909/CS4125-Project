package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.service.Impl.BaseSearchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user")
public class SearchController {

    private final BaseSearchImpl searchService;

    @Autowired
    public SearchController(BaseSearchImpl searchService) {
        this.searchService = searchService;
    }

    @GetMapping(path = "/searchMakeModel/{toSearch}")
    public List<String> searchByMakeModel(@PathVariable String toSearch) {
        return searchService.searchByMakeModel(toSearch);
    }

    @GetMapping(path = "/searchType/{toSearch}")
    public List<String> searchByType(@PathVariable String toSearch) {
        return searchService.searchByType(toSearch);
    }

    @GetMapping(path = "/searchMilage/{milage}")
    public List<String> searchByMilage(@PathVariable int milage) {
        return searchService.searchByMilage(milage);
    }
}
