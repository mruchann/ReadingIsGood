package com.getir.ReadingIsGood.repository;

import com.getir.ReadingIsGood.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
