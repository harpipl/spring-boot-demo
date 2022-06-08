package pl.harpi.springboot.demo.identity.app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.harpi.springboot.demo.identity.app.mapper.UserMapper;
import pl.harpi.springboot.demo.identity.app.request.CreateUserRequest;
import pl.harpi.springboot.demo.identity.app.response.CreateUserResponse;
import pl.harpi.springboot.demo.identity.app.response.GetUserResponse;
import pl.harpi.springboot.demo.identity.domain.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/identity/users")
final class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  @PostMapping
  public ResponseEntity<CreateUserResponse> createUser(
      @RequestBody final CreateUserRequest request) {

    final var user = userService.create(userMapper.toUser(request));
    final var uri = UriBuilder.requestUriWithId(user.id());

    return ResponseEntity.created(uri).body(userMapper.toCreateUserResponse(user));
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetUserResponse> getUser(@PathVariable final String id) {
    return ResponseEntity.ok(userMapper.toGetUserResponse(userService.getById(id)));
  }
}
