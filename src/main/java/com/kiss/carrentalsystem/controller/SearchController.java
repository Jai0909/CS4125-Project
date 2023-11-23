package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class SearchController {

    @Autowired
    private SearchService searchService;
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String toSearch) {
        DefaultResponse searchResponse = (DefaultResponse) searchService.search(toSearch);
        return ResponseEntity.ok(searchResponse);
    }

}
