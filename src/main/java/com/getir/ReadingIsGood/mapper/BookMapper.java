package com.getir.ReadingIsGood.mapper;

import com.getir.ReadingIsGood.entity.Book;
import com.getir.ReadingIsGood.response.BookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse toBookResponse(Book book);
}
