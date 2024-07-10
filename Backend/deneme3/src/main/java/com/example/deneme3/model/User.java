// User.java

package com.example.deneme3.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Set;

@Data
@Document(collection = "kullanicilar")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private Set<String> roles;
}
