package com.hrnchshn.finance.news;

import com.hrnchshn.finance.constants.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.NEWS_PATH)
public class NewsController {

    private final INewsService newsService;

    @GetMapping
    public List<NewsDto> getNews(){
        return newsService.getNews();
    }
}
