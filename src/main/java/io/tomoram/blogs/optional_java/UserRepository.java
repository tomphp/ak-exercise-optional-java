package io.tomoram.blogs.optional_java;

import java.util.UUID;

public interface UserRepository {
    User fetchById(UUID id);

}
