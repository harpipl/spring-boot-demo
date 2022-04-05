package pl.harpi.springboot.demo.identity.domain;

import lombok.Value;

@Value
public class User {
  String id;
  String firstName;
  String lastName;
}
