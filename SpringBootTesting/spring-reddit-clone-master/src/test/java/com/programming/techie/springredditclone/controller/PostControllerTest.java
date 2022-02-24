package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.dto.PostRequest;
import com.programming.techie.springredditclone.dto.PostResponse;
import com.programming.techie.springredditclone.security.JwtProvider;
import com.programming.techie.springredditclone.service.PostService;
import com.programming.techie.springredditclone.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = PostController.class)
class PostControllerTest {

    @MockBean
    PostService postService;

    @MockBean
    UserDetailsServiceImpl userDetails;

    @MockBean
    JwtProvider jwtProvider;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("This is for controller which returns data for all the posts")
    public void getAllPosts() throws Exception {
        PostResponse expectedPostResponse1 = new PostResponse(123L, "First Post", "http://url.site", "Test", "Test User", "Test", 0, 0, "1 hour ago", false, false);

        PostResponse expectedPostResponse2 = new PostResponse(1234L, "First Post", "http://url.site", "Test", "Test User", "Test", 0, 0, "1 hour ago", false, false);

        Mockito.when(postService.getAllPosts()).thenReturn(Arrays.asList(expectedPostResponse1, expectedPostResponse2));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts/"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                ;
    }


}