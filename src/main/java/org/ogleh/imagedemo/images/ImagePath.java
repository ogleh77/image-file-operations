package org.ogleh.imagedemo.images;

public enum ImagePath {

    CANDIDATE_PATH("/Users/mohamedogleh/Desktop/spring/votera/image-demo/src/main/resources/static/assets/candidate"),
    PARTY_PATH("/Users/mohamedogleh/Desktop/spring/votera/image-demo/src/main/resources/static/assets/party");

    private final String path;


    ImagePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
