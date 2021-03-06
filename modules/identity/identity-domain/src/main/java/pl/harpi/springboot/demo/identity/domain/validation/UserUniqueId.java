package pl.harpi.springboot.demo.identity.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserUniqueIdValidator.class)
public @interface UserUniqueId {
  String message() default "Given user identifier is not unique";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
