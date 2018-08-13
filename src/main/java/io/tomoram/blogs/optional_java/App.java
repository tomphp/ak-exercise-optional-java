package io.tomoram.blogs.optional_java;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class App {

    public static void main(String[] args) {
        InMemoryUserRepository userRepository = new InMemoryUserRepository();
        GetProfilePicture getProfilePicture = new GetProfilePicture(userRepository);
        ProfilePictureRenderer renderer = new ProfilePictureRenderer();
        DefaultPictureRenderer defaultPictureRenderer = () -> "default.jpeg";

        UUID userId = UUID.randomUUID();
        User user = User.withProfilePicture("xxx.jpg");
        userRepository.add(userId, user);

        String imgTag = getProfilePicture.forUser(userId)
                .map(renderer::render)
                .orElse(defaultPictureRenderer.defaultImage());

        System.out.println(imgTag);
    }

    private static class InMemoryUserRepository implements UserRepository {
        Map<UUID, User> users = new HashMap<>();

        @Override
        public Optional<User> fetchById(UUID id) {
            return Optional.ofNullable(users.get(id));
        }

        public void add(UUID id, User user) {
            users.put(id, user);
        }
    }


}

@FunctionalInterface
interface DefaultPictureRenderer {
    String defaultImage();
}