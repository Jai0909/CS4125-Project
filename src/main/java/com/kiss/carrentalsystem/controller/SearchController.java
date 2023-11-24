package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping(
            path = "/search/{toSearch}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> search(@PathVariable String toSearch) {
        DefaultResponse searchResponse;
        if (!searchService.search(toSearch).isEmpty()) {
            searchResponse = new DefaultResponse("A result was found", true);
        } else {
            searchResponse = new DefaultResponse("No results", false); //todo change response type to include an array to return array
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(searchResponse);
    }
}
