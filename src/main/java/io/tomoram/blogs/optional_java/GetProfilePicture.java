package io.tomoram.blogs.optional_java;

import java.util.Optional;
import java.util.UUID;

public class GetProfilePicture {
    private final UserRepository userRepository;

    public GetProfilePicture(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String forUser(UUID userId) {
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.fetchById(userId);

        return user.flatMap(User::getProfilePic).orElse(null);
    }
}
