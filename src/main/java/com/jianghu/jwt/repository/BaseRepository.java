package com.jianghu.jwt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
}
