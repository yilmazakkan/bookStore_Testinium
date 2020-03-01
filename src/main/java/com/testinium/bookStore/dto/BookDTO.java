package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Schema(name = "Book Data Transfer Object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    private Long id;
    private String bookName;
    @NotNull(message = "Book price Cannot be Empty ")
    private Double price;
    @NotNull(message = "Book Code Cannot be Empty ")
    private String bookCode;
    @NotNull(message = "category Cannot be Empty ")
    private CategoryDTO category;
    private List<BookAndBookStoreDTO> bookAndBookStores;

    public BookDTO(Long id, String bookName, @NotNull(message = "Book price Cannot be Empty ") Double price, @NotNull(message = "Book Code Cannot be Empty ") String bookCode) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.bookCode = bookCode;
    }
}
