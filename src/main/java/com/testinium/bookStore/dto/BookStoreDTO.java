package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
@Schema(name = "BookStore Data Transfer Object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookStoreDTO {

    private Long id;
    private String bookStoreName;
    private String city;
    private List<BookAndBookStoreDTO> bookAndBookStores;
    private List<String> bookAndStore;



    public BookStoreDTO(Long id, String bookStoreName, String city, List<BookAndBookStoreDTO> bookAndBookStores) {
        this.id = id;
        this.bookStoreName = bookStoreName;
        this.city = city;
        this.bookAndBookStores = bookAndBookStores;
    }


}
