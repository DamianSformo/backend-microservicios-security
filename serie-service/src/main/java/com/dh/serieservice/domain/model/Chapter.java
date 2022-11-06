package com.dh.serieservice.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Chapter {

    @Id
    private String id;

    private String name;

    private Integer number;

    private String urlStream;
}
