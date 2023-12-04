package com.kiss.carrentalsystem.service.impl;

public abstract class SearchDecorator extends BaseSearchImpl {

    protected BaseSearchImpl baseSearchService;

    public SearchDecorator(BaseSearchImpl baseSearchService) {
        this.baseSearchService = baseSearchService;
    }

}
