package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    private String id;

    private String name;
    private String surName;
    @ManyToOne
    private UserEntity playlist;

    @OneToMany(mappedBy = "playlist")
    private Set<UserEntity> autor = new HashSet<>();

    public UserEntity(String id, String name, String surName, UserEntity playlist) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.playlist = playlist;
    }

}
