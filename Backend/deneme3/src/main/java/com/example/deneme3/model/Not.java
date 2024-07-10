package com.example.deneme3.model;

import org.springframework.data.annotation.Id;//mongo için.
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;//lombok kütüphanesi.standart işlemler için.

@Data//standart işlemler için annotasyon.(getter setter vs)
@Document(collection = "Notlar")//mongo daki Notlar kısmında depolansın.
public class Not {
    @Id
    private String id;
    private String title;
    private String content;
}
