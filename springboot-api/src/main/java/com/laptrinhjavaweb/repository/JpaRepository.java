package com.laptrinhjavaweb.repository;

import java.util.List;

public interface JpaRepository<T>  {
Long save(T t);
List<T> findAll();
List<T> findAll(String sql);
T findById(Long Id);
int update(T t);
int delete(Long id);
}
