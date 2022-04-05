package pl.harpi.springboot.demo.identity.infrastructure.repository;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.harpi.springboot.demo.identity.domain.User;

@Mapper
interface JpaDbUserMapper {
  @InheritInverseConfiguration
  User toUser(UserEntity fromUserEntity);

  @Mapping(target = "id", ignore = true)
  @Mapping(source = "id", target = "uid")
  UserEntity toUserEntity(User user);
}
