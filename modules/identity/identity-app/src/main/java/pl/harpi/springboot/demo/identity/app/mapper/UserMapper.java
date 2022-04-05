package pl.harpi.springboot.demo.identity.app.mapper;

import org.mapstruct.Mapper;
import pl.harpi.springboot.demo.identity.app.request.CreateUserRequest;
import pl.harpi.springboot.demo.identity.app.response.CreateUserResponse;
import pl.harpi.springboot.demo.identity.app.response.GetUserResponse;
import pl.harpi.springboot.demo.identity.domain.User;

@Mapper
public interface UserMapper {
  GetUserResponse toGetUserResponse(User user);

  User toUser(CreateUserRequest request);

  CreateUserResponse toCreateUserResponse(User user);
}
