package io.tomoram.blogs.optional_java;

import java.util.Optional;
import java.util.UUID;

public class GetProfilePicture {
    private final UserRepository userRepository;

    public GetProfilePicture(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String forUser(UUID userId) {
        return Optional.ofNullable(userId)
                .flatMap(userRepository::fetchById)
                .flatMap(User::getProfilePic)
                .orElse(null);
    }
}
