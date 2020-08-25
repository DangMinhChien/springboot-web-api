package com.laptrinhjavaweb.repository;

import java.util.List;

public interface JpaRepository<T>  {
Long save(T t);
List<T> findAll();
T findById(Long Id);
}
