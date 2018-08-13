package io.tomoram.blogs.optional_java;

import java.util.Objects;

public class ProfilePictureRenderer {

    private static final String HTML_TAG_TEMPLATE = "<img src=\"%s\">";

    public String render(String path) {
        if (Objects.isNull(path)) {
            throw new IllegalArgumentException("Must not be null.");
        }

        return createHtmlTag(path);
    }

    private String createHtmlTag(String path) {
        return String.format(HTML_TAG_TEMPLATE, path);
    }

}
