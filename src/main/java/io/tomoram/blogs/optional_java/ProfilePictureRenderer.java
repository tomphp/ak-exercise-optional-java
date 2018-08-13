package io.tomoram.blogs.optional_java;

import java.util.Objects;
import java.util.Optional;

public class ProfilePictureRenderer {

    private static final String DEFAULT_IMAGE = "default.jpg";
    private static final String HTML_TAG_TEMPLATE = "<img src=\"%s\">";

    public String render(Optional<String> path) {
        if (Objects.isNull(path)) {
            throw new IllegalArgumentException("Must not be null.");
        }

        return createHtmlTag(getPath(path));
    }

    private String createHtmlTag(String path) {
        return String.format(HTML_TAG_TEMPLATE, path);
    }

    private String getPath(Optional<String> path) {
        return path.orElse(DEFAULT_IMAGE);
    }
}
