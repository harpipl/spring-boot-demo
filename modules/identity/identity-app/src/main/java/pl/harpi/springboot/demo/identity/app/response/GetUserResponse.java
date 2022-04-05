package pl.harpi.springboot.demo.identity.app.response;

import lombok.Value;

@Value
public class GetUserResponse {
  String id;
  String firstName;
  String lastName;
}
