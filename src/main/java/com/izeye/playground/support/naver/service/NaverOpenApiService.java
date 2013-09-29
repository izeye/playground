package com.izeye.playground.support.naver.service;

import java.util.List;

import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieRequest;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;

public interface NaverOpenApiService {

	List<NaverSearchRankItem> getSearchRanks(NaverSearchRankType type);

	NaverSearchBlogResponse searchBlog(NaverSearchRequest request);

	NaverSearchNewsResponse searchNews(NaverSearchRequest request);

	NaverSearchBookResponse searchBook(NaverSearchRequest request);

	List<String> getSearchRecommendations(String query);

	NaverSearchCafeResponse searchCafe(NaverSearchRequest request);

	boolean checkForAdults(String query);

	NaverSearchEncyclopediaResponse searchEncyclopedia(
			NaverSearchRequest request);

	NaverSearchMovieResponse searchMovie(NaverSearchMovieRequest request);

	NaverSearchCafeArticleResponse searchCafeArticle(NaverSearchRequest request);

}
