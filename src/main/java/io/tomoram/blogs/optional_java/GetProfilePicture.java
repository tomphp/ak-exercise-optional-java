package io.tomoram.blogs.optional_java;

import java.util.Objects;
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

        User user = userRepository.fetchById(userId);

        if (Objects.isNull(user)) {
            return null;
        }

        return user.getProfilePic();
    }
}
