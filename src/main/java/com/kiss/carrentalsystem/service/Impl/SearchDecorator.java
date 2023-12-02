package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.service.Impl.BaseSearchImpl;

import java.util.List;

public abstract class SearchDecorator extends BaseSearchImpl {

    protected BaseSearchImpl baseSearchService;

    public SearchDecorator(BaseSearchImpl baseSearchService) {
        this.baseSearchService = baseSearchService;
    }

}
