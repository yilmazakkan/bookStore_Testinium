package com.testinium.bookStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Category Data Transfer Object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {


    private Long id;
    @NotNull(message = "Category Name cannot be empty")
    private String categoryName;
    private List<String> books;

}
