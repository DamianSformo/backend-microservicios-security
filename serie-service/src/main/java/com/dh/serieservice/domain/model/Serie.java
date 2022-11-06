package com.dh.serieservice.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "series")
public class Serie implements Serializable {

    @Id
    private String id;

    private String name;

    private String genre;

    private List<Season> seasons;

}
