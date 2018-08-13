package io.tomoram.blogs.optional_java;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class GetProfilePictureShould {
    @Mock
    UserRepository userRepository;

    GetProfilePicture getProfilePicture;

    private static final UUID USER_ID = UUID.randomUUID();
    private static final User USER = User.withProfilePicture("profile-pic.jpg");

    @Before
    public void
    setUp() {
        given(userRepository.fetchById(USER_ID)).willReturn(Optional.of(USER));

        getProfilePicture = new GetProfilePicture(userRepository);
    }

    @Test public void
    return_empty_if_user_id_is_null() {
        String result = getProfilePicture.forUser(null);

        assertThat(result).isNull();
    }

    @Test public void
    get_the_user_by_id() {
        getProfilePicture.forUser(USER_ID);

        then(userRepository).should().fetchById(USER_ID);
    }

    @Test public void
    return_the_profile_picture_url() {
        String result = getProfilePicture.forUser(USER_ID);

        assertThat(result).isEqualTo("profile-pic.jpg");
    }

    @Test public void
    return_null_if_user_is_not_found() {
        given(userRepository.fetchById(USER_ID)).willReturn(Optional.empty());

        String result = getProfilePicture.forUser(USER_ID);

        assertThat(result).isNull();
    }

    @Test public void
    return_null_if_profile_picture_is_null() {
        given(userRepository.fetchById(USER_ID)).willReturn(Optional.of(User.withOutProfilePic()));

        String result = getProfilePicture.forUser(USER_ID);

        assertThat(result).isNull();
    }
}