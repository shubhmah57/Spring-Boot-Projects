package com.programming.techie.springredditclone.service;

import com.programming.techie.springredditclone.dto.PostRequest;
import com.programming.techie.springredditclone.dto.PostResponse;
import com.programming.techie.springredditclone.mapper.PostMapper;
import com.programming.techie.springredditclone.model.Post;
import com.programming.techie.springredditclone.model.Subreddit;
import com.programming.techie.springredditclone.model.User;
import com.programming.techie.springredditclone.repository.PostRepository;
import com.programming.techie.springredditclone.repository.SubredditRepository;
import com.programming.techie.springredditclone.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.parameters.P;

import javax.validation.constraints.AssertTrue;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;
    @Mock
    private SubredditRepository subredditRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private AuthService authService;
    @Mock
    private PostMapper postMapper;

    @Captor
    private ArgumentCaptor<Post> postArgumentCaptor;


    private PostService postService;

    @BeforeEach
    private void setUp(){
        postService = new PostService(postRepository, subredditRepository, userRepository, authService,postMapper);
    }

    @Test
    @DisplayName("Should find post by Id")
    void shouldFindPostById() {

        Post post = new Post(123L, "First Post", "http://url.site", "Test", 0, null, Instant.now(), null);
        PostResponse expectedPostResponse = new PostResponse(123L, "First Post", "http://url.site", "Test", "Test User", "Test", 0, 0, "1 hour ago", false, false);
        Mockito.when(postRepository.findById(123L)).thenReturn(Optional.of(post));
        Mockito.when(postMapper.mapToDto(Mockito.any(Post.class))).thenReturn(expectedPostResponse);
        PostResponse actualPostResponse = postService.getPost(123L);
        assertTrue(actualPostResponse.getId().equals(expectedPostResponse.getId()));
        Assertions.assertThat(actualPostResponse.getId()).isEqualTo(expectedPostResponse.getId());
    }

    @Test
    @DisplayName("Should save Posts")
    void  shouldSavePosts(){
        Subreddit subreddit = new Subreddit(123L, "First Subreddit", "Subreddit Description", new ArrayList<>(), Instant.now(), null);
        PostRequest postRequest = new PostRequest(null, "First Subreddit", "First Post", "http://url.site", "Test");
        User currentUser = new User(123L, "test user", "secret", "user@gmail.com", Instant.now(), true);
        Post post = new Post(123L, "First Post", "http://url.site", "Test", 0, null, Instant.now(), null);

        Mockito.when(subredditRepository.findByName("First Subreddit")).thenReturn(Optional.of(subreddit));
        Mockito.when(authService.getCurrentUser()).thenReturn(currentUser);
        Mockito.when(postMapper.map(postRequest, subreddit, currentUser)).thenReturn(post);
        postService.save(postRequest);
        Mockito.verify(postRepository, Mockito.times(1)).save(postArgumentCaptor.capture());
        org.junit.jupiter.api.Assertions.assertTrue(postArgumentCaptor.getValue().getPostId().equals(post.getPostId()));

    }
}
