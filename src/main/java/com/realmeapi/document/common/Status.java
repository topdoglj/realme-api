package com.realmeapi.document.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "status")
public class Status {
    @Id
    private int id;
    private String code;
    private String description;
}
