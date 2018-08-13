package io.tomoram.blogs.optional_java;

public class User {
    private String profilePic;

    private User(String profilePic) {
        this.profilePic = profilePic;
    }

    public static User withOutProfilePic() {
        return new User(null);
    }

    public static User withProfilePicture(String profilePic) {
        return new User(profilePic);
    }

    public String getProfilePic() {
        return profilePic;
    }
}
