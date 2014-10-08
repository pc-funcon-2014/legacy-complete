package com.funcon.domain;

public interface SearchCriteria<T> {

    boolean test(T element);
}
