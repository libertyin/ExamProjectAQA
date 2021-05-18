package data;

public enum ProjectUrls {
    IT_PLATFORM_WEBSITE("https://it-platforma.website/"),
    MENU_YOUR_OBJECTIVE("https://5element.ua/"),
    MENU_ACHIEVE_YOUR_GOAL("https://5element.ua/about/special_offer/"),
    MENU_CHOOSE_YOUR_PACK("https://5element.ua/shedule/"),
    MENU_PRICING("https://5element.ua/klubnye-karty/"),
    MENU_SIGN_IN("https://it-platforma.website/login/");

    private final String url;

    ProjectUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


}
