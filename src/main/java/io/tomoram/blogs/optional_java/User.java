package io.tomoram.blogs.optional_java;

import java.util.Optional;

public class User {
    private String profilePic;

    private User(String profilePic) {
        this.profilePic = profilePic;
    }

    public static User withOutProfilePicture() {
        return new User(null);
    }

    public static User withProfilePicture(String profilePic) {
        return new User(profilePic);
    }

    public Optional<String> getProfilePic() {
        return Optional.ofNullable(profilePic);
    }
}
