package com.dh.serieservice.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Season{

    @Id
    private String id;

    private Integer seasonNumber;

    private List<Chapter> chapters;
}
