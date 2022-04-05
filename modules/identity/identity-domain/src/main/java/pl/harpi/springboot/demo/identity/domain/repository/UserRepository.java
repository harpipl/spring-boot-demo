package pl.harpi.springboot.demo.identity.domain.repository;

import pl.harpi.springboot.demo.identity.domain.User;

import java.util.Optional;

public interface UserRepository {
  Optional<User> find(String id);

  User create(User user);
}
