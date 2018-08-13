package io.tomoram.blogs.optional_java;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfilePictureRendererShould {

    private ProfilePictureRenderer renderer;

    @Before public void
    setUp() {
        renderer = new ProfilePictureRenderer();
    }

    @Test public void
    return_an_html_img_tag() {
        assertThat(renderer.render(Optional.of("picture1.jpg"))).isEqualTo("<img src=\"picture1.jpg\">");
        assertThat(renderer.render(Optional.of("picture2.jpg"))).isEqualTo("<img src=\"picture2.jpg\">");
    }

    @Test public void
    return_a_default_picture_if_image_not_provided() {
        String result = renderer.render(Optional.empty());

        assertThat(result).isEqualTo("<img src=\"default.jpg\">");
    }

    @Test(expected = IllegalArgumentException.class) public void
    throw_illegal_argument_exeception_if_parameter_is_null() {
        renderer.render(null);
    }
}