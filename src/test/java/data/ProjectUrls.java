package data;

public enum ProjectUrls {
    IT_PLATFORM_WEBSITE("https://it-platforma.website/"),
    MENU_SIGN_IN("https://it-platforma.website/login/");

    private final String url;

    ProjectUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


}
