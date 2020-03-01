package com.testinium.bookStore.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.bookStore.dto.CategoryDTO;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.Collections;

import com.testinium.bookStore.entity.Category;
import com.testinium.bookStore.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CategoryRest.class)
public class CategoryRestTest {
    private final static String CONTENT_TYPE = "application/json";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        // given
        CategoryDTO category = CategoryDTO.builder().categoryName("test").build();

        // when
        ResultActions actions = mockMvc.perform(post("/category")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(category)));
        // then
        ArgumentCaptor<CategoryDTO> captor = ArgumentCaptor.forClass(CategoryDTO.class);
        verify(categoryService, times(1)).save(captor.capture());
        assertThat(captor.getValue().getCategoryName()).isEqualTo("test");
        actions.andExpect(status().isOk());

    }


//    void whenValidInput_thenReturns400() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(post("/category")
//                .contentType(CONTENT_TYPE)
//                .content(objectMapper.writeValueAsString("test-value")));
//
//        // then
//        actions.andExpect(status().isNotFound());
//    }
//
//    @Test
//    void whenCallGetAll_thenReturns200() throws Exception {
//        // given
//        CategoryDTO category = CategoryDTO.builder().categoryName("test").build();
//        when(categoryService.getAll()).thenReturn(Arrays.asList(category));
//
//        // when
//        MvcResult mvcResult = mockMvc.perform(get("/category")
//                .accept(CONTENT_TYPE)).andReturn();
//
//
//        // then
//        String responseBody = mvcResult.getResponse().getContentAsString();
//        verify(categoryService, times(1)).getAll();
//        assertThat(objectMapper.writeValueAsString(Arrays.asList(category)))
//                .isEqualToIgnoringWhitespace(responseBody);
//    }
//    @Test
//    void whenCallGetAll_thenReturnsNoData() throws Exception {
//        // given
//        when(categoryService.getAll()).thenReturn(Collections.emptyList());
//
//        // when
//        MvcResult mvcResult = mockMvc.perform(get("/category")
//                .accept(CONTENT_TYPE)).andReturn();
//
//        // then
//        String responseBody = mvcResult.getResponse().getContentAsString();
//        verify(categoryService, times(1)).getAll();
//        assertThat(objectMapper.writeValueAsString(Collections.emptyList()))
//                .isEqualToIgnoringWhitespace(responseBody);
//    }
}
