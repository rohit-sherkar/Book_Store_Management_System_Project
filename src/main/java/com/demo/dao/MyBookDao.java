package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.MyBookList;

@Repository
public interface MyBookDao extends JpaRepository<MyBookList, Integer> {

}
