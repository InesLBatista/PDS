package creational.prototype;

public interface Document extends Cloneable {
    Document clone();
    String getType();
    String getContent();
    void setContent(String content);
    void setMetadata(String metadata);
    String getMetadata();
}
