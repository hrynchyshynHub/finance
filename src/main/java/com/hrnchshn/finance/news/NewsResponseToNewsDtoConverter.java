package com.hrnchshn.finance.news;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ivan.hrynchyshyn
 */
public class NewsResponseToNewsDtoConverter {

    public static List<NewsDto> toNewsDto(NewsResponse response){
        return response.getArticles().stream().map(article -> {
            return NewsDto.builder()
                    .author(article.getAuthor())
                    .content(article.getContent())
                    .description(article.getDescription())
                    .title(article.getTitle())
                    .publishedAt(article.getPublishedAt())
                    .urlToImage(article.getUrlToImage())
                    .build();
        }).collect(Collectors.toList());
    }
}
