package creational.prototype;
import java.util.*;

public class PresentationDocument extends AbstractDocument {
    private List<String> slides;
    private String theme;
    private boolean hasAnimation;

    public PresentationDocument() {
        super("PresentationDocument");
        this.slides=new ArrayList<>();
        this.slides.add("Title Slide");
        this.theme="Default Theme";
        this.hasAnimation=false;
    }

    public PresentationDocument(String content, String metadata, List<String> slides, String theme, boolean hasAnimations) {
        super("PresentationDocument");
        this.content=content;
        this.metadata=metadata;
        this.slides=new ArrayList<>(slides);
        this.theme=theme;
        this.hasAnimation=hasAnimations;
    }

    public List<String> getSlides() {
        return new ArrayList<>(slides);
    }

    public void setSlides(List<String> slides) {
        this.slides=new ArrayList<>(slides);
    }

    public void addSlide(String slide) {
        this.slides.add(slide);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme=theme;
    }

    public Boolean hasAnimations() {
        return hasAnimation;
    }

    public void setHasAnimations(Boolean hasAnimations) {
        this.hasAnimation=hasAnimations;
    }

    @Override
    public Document clone() {
        return new PresentationDocument(this.content, this.metadata, 
                                       new ArrayList<>(this.slides), // Deep copy
                                       this.theme, this.hasAnimation);
    }

    @Override
    public String toString() {
        return "PresentationDocument{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", metadata='" + metadata + '\'' +
                ", slides=" + slides +
                ", theme='" + theme + '\'' +
                ", hasAnimations=" + hasAnimation +
                '}';
        }
}
