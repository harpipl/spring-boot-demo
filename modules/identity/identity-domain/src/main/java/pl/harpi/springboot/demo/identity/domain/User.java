package pl.harpi.springboot.demo.identity.domain;

import pl.harpi.springboot.demo.identity.domain.validation.UserUniqueId;

public record User(@UserUniqueId String id, String firstName, String lastName) {
}
