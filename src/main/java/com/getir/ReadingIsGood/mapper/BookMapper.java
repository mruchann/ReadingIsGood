package com.getir.ReadingIsGood.mapper;

import com.getir.ReadingIsGood.entity.Book;
import com.getir.ReadingIsGood.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    @Mappings({
            @Mapping(source = "name", target = "book.name"),
            @Mapping(source = "author", target = "book.author"),
            @Mapping(source = "price", target = "book.price"),
            @Mapping(source = "stock", target = "book.stock")
    })
    BookResponse toBookResponse(Book book);
}
