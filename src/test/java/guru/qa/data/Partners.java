package guru.qa.data;

public enum Languages {
    RU("ru", "Новости"),
    EN("en", "News"),
    CN("cn", "新闻");

    public final String hrefSuffix;
    public final String newsTitle;

    Languages(String hrefSuffix, String newsTitle) {
        this.hrefSuffix = hrefSuffix;
        this.newsTitle = newsTitle;
    }
}