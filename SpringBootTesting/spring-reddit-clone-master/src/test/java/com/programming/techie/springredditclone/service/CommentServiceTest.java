package com.programming.techie.springredditclone.service;

import com.programming.techie.springredditclone.exceptions.SpringRedditException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommentServiceTest {

    @Test
    @DisplayName("Test should not fail when there are no Swear words.")
    void shouldNotContainsSwearWords() {
        CommentService commentService = new CommentService(null, null,
                null, null, null, null,
                null);
//        Assertions.assertFalse(commentService.containsSwearWords("clean comment"));
        org.assertj.core.api.Assertions.assertThat(commentService.containsSwearWords("clean comment")).isFalse();
    }

    @Test
    @DisplayName("Test should throw exception when there are Swear Words.")
    void shouldContainsSwearWords(){
        CommentService commentService = new CommentService(null, null,
                null, null, null, null,
                null);
         SpringRedditException springRedditException = Assertions.assertThrows(SpringRedditException.class, ()->{
             commentService.containsSwearWords("this is a shitty comment");
         });

         Assertions.assertTrue(springRedditException
                 .getMessage()
                    .contains("Comments contains unacceptable Language"));

    }
}