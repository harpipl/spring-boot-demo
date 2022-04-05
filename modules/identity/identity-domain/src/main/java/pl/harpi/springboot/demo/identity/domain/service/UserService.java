package pl.harpi.springboot.demo.identity.domain.service;

import pl.harpi.springboot.demo.identity.domain.User;

import java.util.Optional;

public interface UserService {
  Optional<User> findById(String id);

  User getById(String id);

  User create(User user);
}
