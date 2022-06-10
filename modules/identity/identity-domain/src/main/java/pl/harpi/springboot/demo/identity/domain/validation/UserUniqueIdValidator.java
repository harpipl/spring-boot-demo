package pl.harpi.springboot.demo.identity.domain.validation;

import lombok.RequiredArgsConstructor;
import pl.harpi.springboot.demo.identity.domain.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UserUniqueIdValidator implements ConstraintValidator<UserUniqueId, String> {
  private final UserRepository userRepository;

  @Override
  public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
    return userRepository.find(id).isEmpty();
  }
}
