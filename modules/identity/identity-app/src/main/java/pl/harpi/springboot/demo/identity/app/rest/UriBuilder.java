package pl.harpi.springboot.demo.identity.app.rest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UriBuilder {
  public static URI requestUriWithId(Object id) {
    return ServletUriComponentsBuilder.fromCurrentRequestUri()
        .path("/{id}")
        .buildAndExpand(id)
        .toUri();
  }
}
