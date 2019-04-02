package com.hrnchshn.finance.news;

import com.google.gson.Gson;
import com.hrnchshn.finance.utils.WebCall;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ivan.hrynchyshyn
 */
@Service
public class NewsService implements INewsService{

    @Value("${news.apiKey}")
    public String key;

    private final String NEWS_API = "https://newsapi.org/v2/everything";

    @Override
    public List<NewsDto> getNews() {
        String newsLinkTemplate = NEWS_API + "?sources=%s";
        String country = "cnn";
        WebCall webCall = new WebCall(WebCall.HttpVerb.GET, String.format(newsLinkTemplate, country));
        webCall.setHeader("X-Api-Key", key);
        return NewsResponseToNewsDtoConverter.toNewsDto(new Gson().fromJson(webCall.execute().getHttpResponseBody(), NewsResponse.class));
    }
}
