package prs.fltoshi.library_clientv2.entity;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {
    private Long id;
    private String title;
    private List<PublisherEntity> publisher;
}
