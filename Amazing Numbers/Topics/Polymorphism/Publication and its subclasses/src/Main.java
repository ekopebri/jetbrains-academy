class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        return this.getType() + ": " + this.getDetails();
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return this.title;
    }

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    // write your code here

    @Override
    public String getType() {
        return String.format("Newspaper (source - %s)", this.source);
    }
}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    // write your code here

    @Override
    public String getType() {
        return String.format("Article (author - %s)", this.author);
    }

}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    // write your code here

    @Override
    public String getType() {
        return String.format("Announcement (days to expire - %d)", this.daysToExpire);
    }
}