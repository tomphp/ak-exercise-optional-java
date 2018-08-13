package io.tomoram.blogs.optional_java;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> fetchById(UUID id);

}
