package com.example.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty()
    @JsonIgnore
    private long id;

    @Column(name = "username", nullable = false)
    @ApiModelProperty(value = "Benutzername", example = "retfloww")
    private String username;

    @Column(name = "password", nullable = false)
    @ApiModelProperty(value = "Passwort vom Benutzer", example = "retfloww")
    private String password;

    @Column(name = "is_enabled")
    @ApiModelProperty(value = "Gibt an ob der Benutzer gesperrt ist", example = "false")
    boolean isEnabled;

}
