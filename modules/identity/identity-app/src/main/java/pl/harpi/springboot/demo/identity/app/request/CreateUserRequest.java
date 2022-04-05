package pl.harpi.springboot.demo.identity.app.request;

import lombok.Value;

@Value
public class CreateUserRequest {
  String id;
  String firstName;
  String lastName;
}
