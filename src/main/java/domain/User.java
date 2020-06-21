package domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class User {
    private String id;
    private String name;
    private String surName;
    private User playlist;


}