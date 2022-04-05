package pl.harpi.springboot.demo.identity.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.harpi.springboot.demo.identity.domain.DomainException;
import pl.harpi.springboot.demo.identity.domain.User;
import pl.harpi.springboot.demo.identity.domain.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
final class DomainUserService implements UserService {
  private final UserRepository repository;

  @Override
  public Optional<User> findById(final String id) {
    return repository.find(id);
  }

  @Override
  public User getById(final String id) {
    return findById(id)
        .orElseThrow(() -> new DomainException(String.format("User with id '%s' not found", id)));
  }

  @Override
  public User create(User user) {
    return repository.create(user);
  }
}
