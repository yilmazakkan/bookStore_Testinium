package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookAndBookStoreDTO {

    private Long id;
    private BookDTO book;
    private Long bookId;
    private BookStoreDTO bookStore;
    private Long bookStoredId;
    private Double bookPrice;

}
