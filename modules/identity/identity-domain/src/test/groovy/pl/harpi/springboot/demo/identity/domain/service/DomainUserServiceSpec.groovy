package pl.harpi.springboot.demo.identity.domain.service

import pl.harpi.springboot.demo.identity.domain.User
import pl.harpi.springboot.demo.identity.domain.repository.UserRepository
import spock.lang.Specification

class DomainUserServiceSpec extends Specification {
    DomainUserService userService
    UserRepository userRepository

    def setup() {
        userRepository = Mock(UserRepository.class)
        userService = new DomainUserService(userRepository)
    }

    def "should_exists_after_user_create"() {
        given:
        String RANDOM_ID = UUID.randomUUID()
        userRepository.find(RANDOM_ID) >> Optional.of(new User(RANDOM_ID, "John", "Smith"))
        User user = new User(RANDOM_ID, "John", "Smith")
        userService.create(user)

        when:
        def findById = userService.findById(RANDOM_ID)

        then:
        findById.isPresent()

    }
}
