package cristinapalmisani.BEU2W2L4.payloads;

import lombok.Getter;

import java.util.UUID;

@Getter

public class BlogPostDTO {
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
    private UUID authorId;

    public String getCover() {
        return cover = "https://picsum.photos/200/300";
    }
}
