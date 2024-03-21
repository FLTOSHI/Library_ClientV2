package edu.fltoshi.library_clientv2.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreEntity {
    private Long id;
    private String title;
    private List<BookEntity> books;
}
