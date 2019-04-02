package com.hrnchshn.finance.news;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Article{
        private Source source;
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;
        private String content;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Source{
        private String id;
        private String name;
    }
}
