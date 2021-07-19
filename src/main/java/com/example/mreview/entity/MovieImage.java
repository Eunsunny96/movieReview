package com.example.mreview.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString (exclude = "movie")
public class MovieImage extends BaseEntity {//사용할 이미지 정보

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;


    private String uuid;

    private String imgName;

    private String path; //'년/월/일'

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
