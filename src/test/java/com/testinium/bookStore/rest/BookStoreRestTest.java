package com.testinium.bookStore.rest;
import java.util.Arrays;
import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.bookStore.dto.BookStoreDTO;
import com.testinium.bookStore.entity.BookStore;

import com.testinium.bookStore.service.BookStoreService;

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
@WebMvcTest(controllers = BookStoreRest.class)
public class BookStoreRestTest {

    private final static String CONTENT_TYPE = "application/json";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookStoreService bookStoreService;


    @Test
    void whenValidInput_thenReturns200() throws Exception {
        // given
        BookStoreDTO bookStore = BookStoreDTO.builder().bookStoreName("Test-Name").city("Test-city").build();

        // when
        ResultActions actions = mockMvc.perform(post("/bookstore")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(bookStore)));
        // then
        ArgumentCaptor<BookStoreDTO> captor = ArgumentCaptor.forClass(BookStoreDTO.class);
        verify(bookStoreService, times(1)).save(captor.capture());
        assertThat(captor.getValue().getBookStoreName()).isEqualTo("Test-Name");
        actions.andExpect(status().isOk());

    }
}
