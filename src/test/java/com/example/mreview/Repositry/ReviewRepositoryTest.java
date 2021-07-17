package com.example.mreview.Repositry;

import com.example.mreview.entity.Member;
import com.example.mreview.entity.Movie;
import com.example.mreview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest { //movie 테이블과 m_member 평점과 리뷰ㅠ  등록

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void inserMovieReviews(){
        IntStream.rangeClosed(1,200).forEach(i->{
            //영화 번호
            Long mno = (long)(Math.random()*100)+1;

            //리뷰어 번호
            Long mid = ((long)(Math.random()*100)+1);
            Member member = Member.builder().mid(mid).build();

            Review moviereview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("이 영화에 대한 느낌.."+i)
                    .build();

            reviewRepository.save(moviereview);


        });
    }

    @Test
    void testGetMovieReviews(){
        Movie movie = Movie.builder()
                .mno(92L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview ->{

            System.out.println(movieReview.getReviewnum());
            System.out.println("\t"+movieReview.getGrade());
            System.out.println("\t"+movieReview.getText());
            System.out.println("\t"+movieReview.getMember().getEmail());
            System.out.println("------------------------");

        });
    }

}