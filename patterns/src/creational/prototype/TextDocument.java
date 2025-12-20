package creational.prototype;

public class TextDocument extends AbstractDocument {
    private String formatting;
    private String author;

    public TextDocument() {
        super("TextDocument");
        this.formatting="Default formating";
        this.author="Unknown";
    }

    public TextDocument(String content, String metadata, String formatting, String author) {
        super("TextDocument");
        this.content=content;
        this.metadata=metadata;
        this.formatting=formatting;
        this.author=author;
    }

    public String getFormatting() {
        return formatting;
    }

    public void setFormatting(String formatting) {
        this.formatting=formatting;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }

    @Override
    public Document clone() {
        return new TextDocument(this.content, this.metadata, this.formatting, this.author);
    }

    @Override
    public String toString() {
        return "TextDocument{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", metadata='" + metadata + '\'' +
                ", formatting='" + formatting + '\'' +
                ", author='" + author + '\'' +
                '}';
        }
}
