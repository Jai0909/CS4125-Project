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

    @GetMapping(path = "/search/{toSearch}")
    public List<?> search(@PathVariable String toSearch) {
        return searchService.search(toSearch);
    }
}
