package com.rest_api.fs14backend.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "user")
@Table(name = "customer")
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column(unique = true)
  private String username;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  public User(String username, String password){
    this.username = username;
    this.password = password;
  }
}
