package com.izeye.playground.support.naver.service;

import java.util.List;

import com.izeye.playground.support.naver.domain.search.DefaultNaverSearchResponse;
import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarRequest;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarResponse;
import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaResponse;
import com.izeye.playground.support.naver.domain.search.image.NaverSearchImageRequest;
import com.izeye.playground.support.naver.domain.search.image.NaverSearchImageResponse;
import com.izeye.playground.support.naver.domain.search.local.NaverSearchLocalResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieRequest;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;
import com.izeye.playground.support.naver.domain.search.site.NaverSearchSiteResponse;
import com.izeye.playground.support.naver.domain.search.web.NaverSearchWebRequest;

public interface NaverOpenApiService {

	List<NaverSearchRankItem> getSearchRanks(NaverSearchRankType searchRankType);

	List<NaverSearchRankItem> getSearchRanks(NaverSearchRequest request);

	NaverSearchBlogResponse searchBlog(NaverSearchRequest request);

	NaverSearchNewsResponse searchNews(NaverSearchRequest request);

	NaverSearchBookResponse searchBook(NaverSearchRequest request);

	List<String> getSearchRecommendations(NaverSearchRequest request);

	NaverSearchCafeResponse searchCafe(NaverSearchRequest request);

	boolean checkForAdults(NaverSearchRequest request);

	NaverSearchEncyclopediaResponse searchEncyclopedia(
			NaverSearchRequest request);

	NaverSearchMovieResponse searchMovie(NaverSearchMovieRequest request);

	NaverSearchCafeArticleResponse searchCafeArticle(NaverSearchRequest request);

	NaverSearchMovieActorResponse searchMovieActor(NaverSearchRequest request);

	NaverSearchCarResponse searchCar(NaverSearchCarRequest request);

	NaverSearchSiteResponse searchShortcut(NaverSearchRequest request);

	DefaultNaverSearchResponse searchKin(NaverSearchRequest request);

	NaverSearchLocalResponse searchLocal(NaverSearchRequest request);

	DefaultNaverSearchResponse searchWeb(NaverSearchWebRequest request);

	String fixTypo(NaverSearchRequest request);

	NaverSearchImageResponse searchImage(NaverSearchImageRequest request);

}
