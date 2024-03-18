package prs.fltoshi.library_clientv2.entity;

import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    private Long id;
    private AuthorEntity author;
    private PublisherEntity publisher;
    private GenreEntity genre;
    private String year;
}
