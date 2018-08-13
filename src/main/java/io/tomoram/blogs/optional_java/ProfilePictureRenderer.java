package io.tomoram.blogs.optional_java;

import java.util.Objects;

public class ProfilePictureRenderer {

    private static final String DEFAULT_IMAGE = "default.jpg";
    private static final String HTML_TAG_TEMPLATE = "<img src=\"%s\">";

    public String render(String path) {
        return createHtmlTag(getPath(path));
    }

    private String createHtmlTag(String path) {
        return String.format(HTML_TAG_TEMPLATE, path);
    }

    private String getPath(String path) {
        return Objects.isNull(path) ? DEFAULT_IMAGE : path;
    }
}
