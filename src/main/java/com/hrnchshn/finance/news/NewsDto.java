package com.hrnchshn.finance.news;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ivan.hrynchyshyn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
