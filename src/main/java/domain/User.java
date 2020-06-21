package domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class User {
     private  String name;
     private String password;
     private String MyPlayList;
}