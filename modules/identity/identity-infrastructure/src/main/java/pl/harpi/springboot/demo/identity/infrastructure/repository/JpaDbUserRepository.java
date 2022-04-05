package pl.harpi.springboot.demo.identity.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.harpi.springboot.demo.identity.domain.User;
import pl.harpi.springboot.demo.identity.domain.repository.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
final class JpaDbUserRepository implements UserRepository {
  private final SpringDataJpaUserRepository jpaUserRepository;
  private final JpaDbUserMapper jpaDbUserMapper;

  @Override
  public Optional<User> find(String id) {
    return jpaUserRepository.findByUid(id).map(jpaDbUserMapper::toUser);
  }

  @Override
  public User create(User user) {
    var u = jpaDbUserMapper.toUserEntity(user);
    UserEntity save = jpaUserRepository.save(u);
    return jpaDbUserMapper.toUser(save);
  }
}
