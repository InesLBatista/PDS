import java.util.List;
import java.util.Collections;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    private Movie(Builder builder) {
        this.title = builder.title;
        this.year = builder.year;
        this.director = builder.director;
        this.writer = builder.writer;
        this.series = builder.series;
        this.cast = builder.cast;
        this.locations = builder.locations;
        this.languages = builder.languages;
        this.genres = builder.genres;
        this.isTelevision = builder.isTelevision;
        this.isNetflix = builder.isNetflix;
        this.isIndependent = builder.isIndependent;
    }

    public static Builder builder(String title, int year) {
        return new Builder(title, year);
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public Person getDirector() { return director; }
    public Person getWriter() { return writer; }
    public String getSeries() { return series; }
    public List<Person> getCast() { return Collections.unmodifiableList(cast); }
    public List<Place> getLocations() { return Collections.unmodifiableList(locations); }
    public List<String> getLanguages() { return Collections.unmodifiableList(languages); }
    public List<String> getGenres() { return Collections.unmodifiableList(genres); }
    public boolean isTelevision() { return isTelevision; }
    public boolean isNetflix() { return isNetflix; }
    public boolean isIndependent() { return isIndependent; }


    public static class Builder {
        private final String title;
        private final int year;
        private Person director = null;
        private Person writer = null;
        private String series = null;
        private List<Person> cast = Collections.emptyList();
        private List<Place> locations = Collections.emptyList();
        private List<String> languages = Collections.emptyList();
        private List<String> genres = Collections.emptyList();
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;
        public Builder(String title, int year) {
            this.title = title;
            this.year = year;
        }
        public Builder director(Person director) { this.director = director; return this; }
        public Builder writer(Person writer) { this.writer = writer; return this; }
        public Builder series(String series) { this.series = series; return this; }
        public Builder cast(List<Person> cast) { this.cast = cast != null ? List.copyOf(cast) : Collections.emptyList(); return this; }
        public Builder locations(List<Place> locations) { this.locations = locations != null ? List.copyOf(locations) : Collections.emptyList(); return this; }
        public Builder languages(List<String> languages) { this.languages = languages != null ? List.copyOf(languages) : Collections.emptyList(); return this; }
        public Builder genres(List<String> genres) { this.genres = genres != null ? List.copyOf(genres) : Collections.emptyList(); return this; }
        public Builder isTelevision(boolean isTelevision) { this.isTelevision = isTelevision; return this; }
        public Builder isNetflix(boolean isNetflix) { this.isNetflix = isNetflix; return this; }
        public Builder isIndependent(boolean isIndependent) { this.isIndependent = isIndependent; return this; }
        
        public Movie build() {
            return new Movie(this);
        }
    }
}