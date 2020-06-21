package domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
     private String id;
     private String name;
     private String surName;
     private User playlist;


}
