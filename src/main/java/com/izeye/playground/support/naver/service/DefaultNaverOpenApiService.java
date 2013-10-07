package com.izeye.playground.support.naver.service;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.HttpUtils;
import com.izeye.playground.common.util.JDOMUtils;
import com.izeye.playground.common.util.UrlUtils;
import com.izeye.playground.support.naver.domain.NaverOpenApiFailException;
import com.izeye.playground.support.naver.domain.search.DefaultNaverSearchResponse;
import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchResponseCallback;
import com.izeye.playground.support.naver.domain.search.NaverSearchSortType;
import com.izeye.playground.support.naver.domain.search.blog.NaverSearchBlogResponse;
import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeArticleResponse;
import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeResponse;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarRequest;
import com.izeye.playground.support.naver.domain.search.car.NaverSearchCarResponse;
import com.izeye.playground.support.naver.domain.search.encyclopedia.NaverSearchEncyclopediaResponse;
import com.izeye.playground.support.naver.domain.search.local.NaverSearchLocalResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorResponse;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieRequest;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieResponse;
import com.izeye.playground.support.naver.domain.search.news.NaverSearchNewsResponse;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankItem;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankStatus;
import com.izeye.playground.support.naver.domain.search.rank.NaverSearchRankType;
import com.izeye.playground.support.naver.domain.search.site.NaverSearchSiteResponse;
import com.izeye.playground.support.naver.domain.search.web.NaverSearchWebRequest;
import com.izeye.playground.support.naver.service.search.DefaultNaverSearchResponseParser;
import com.izeye.playground.support.naver.service.search.blog.NaverSearchBlogResponseParser;
import com.izeye.playground.support.naver.service.search.book.NaverSearchBookResponseParser;
import com.izeye.playground.support.naver.service.search.cafe.NaverSearchCafeArticleResponseParser;
import com.izeye.playground.support.naver.service.search.cafe.NaverSearchCafeResponseParser;
import com.izeye.playground.support.naver.service.search.car.NaverSearchCarResponseParser;
import com.izeye.playground.support.naver.service.search.encyclopedia.NaverSearchEncyclopediaResponseParser;
import com.izeye.playground.support.naver.service.search.local.NaverSearchLocalResponseParser;
import com.izeye.playground.support.naver.service.search.movie.NaverSearchMovieActorResponseParser;
import com.izeye.playground.support.naver.service.search.movie.NaverSearchMovieResponseParser;
import com.izeye.playground.support.naver.service.search.news.NaverSearchNewsResponseParser;

@Service("naverOpenApiService")
public class DefaultNaverOpenApiService implements NaverOpenApiService {

	private static final String NAVER_SEARCH_API_URL_PREFIX = "http://openapi.naver.com/search?";

	private static final String PARAM_KEY = "key";
	private static final String PARAM_TARGET = "target";
	private static final String PARAM_QUERY = "query";

	private static final String PARAM_DISPLAY = "display";
	private static final String PARAM_START = "start";
	private static final String PARAM_SORT = "sort";

	@Value("${naver.search.api.key}")
	private String searchApiKey;

	@Resource
	private NaverSearchBlogResponseParser blogResponseParser;

	@Resource
	private NaverSearchNewsResponseParser newsResponseParser;

	@Resource
	private NaverSearchBookResponseParser bookResponseParser;

	@Resource
	private NaverSearchCafeResponseParser cafeResponseParser;

	@Resource
	private NaverSearchEncyclopediaResponseParser encyclopediaResponseParser;

	@Resource
	private NaverSearchMovieResponseParser movieResponseParser;

	@Resource
	private NaverSearchCafeArticleResponseParser cafeArticleResponseParser;

	@Resource
	private NaverSearchMovieActorResponseParser movieActorResponseParser;

	@Resource
	private NaverSearchCarResponseParser carResponseParser;

	@Resource
	private DefaultNaverSearchResponseParser defaultResponseParser;

	@Resource
	private NaverSearchLocalResponseParser localResponseParser;

	private final Logger log = LoggerFactory.getLogger(getClass());

	// FIXME:
	// How can I remove these warnings?
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<NaverSearchRankItem> getSearchRanks(NaverSearchRequest request) {
		return search(request, new NaverSearchResponseCallback<List>() {
			@Override
			public List<NaverSearchRankItem> callback(Element root) {
				List<NaverSearchRankItem> ranks = new ArrayList<NaverSearchRankItem>();

				Element item = root.getChild(ELEMENT_ITEM);
				List<Element> children = item.getChildren();
				for (int i = 0; i < children.size(); i++) {
					Element child = children.get(i);
					String keyword = child.getChildText(ELEMENT_K);
					String status = child.getChildText(ELEMENT_S);
					String variance = child.getChildText(ELEMENT_V);
					NaverSearchRankItem rank = new NaverSearchRankItem(i + 1,
							keyword, NaverSearchRankStatus
									.getStatusByValue(status), Integer
									.parseInt(variance));
					ranks.add(rank);
				}
				return ranks;
			}
		}, List.class);
	}

	@Override
	public List<NaverSearchRankItem> getSearchRanks(
			NaverSearchRankType searchRankType) {
		NaverSearchRequest request = new NaverSearchRequest(
				searchRankType.getSearchType(), searchRankType.getQuery());
		return getSearchRanks(request);
	}

	@Override
	public NaverSearchBlogResponse searchBlog(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchBlogResponse>() {
					@Override
					public NaverSearchBlogResponse callback(Element root) {
						NaverSearchBlogResponse response = new NaverSearchBlogResponse();
						blogResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchBlogResponse.class);
	}

	@Override
	public NaverSearchNewsResponse searchNews(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchNewsResponse>() {
					@Override
					public NaverSearchNewsResponse callback(Element root) {
						NaverSearchNewsResponse response = new NaverSearchNewsResponse();
						newsResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchNewsResponse.class);
	}

	@Override
	public NaverSearchBookResponse searchBook(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchBookResponse>() {
					@Override
					public NaverSearchBookResponse callback(Element root) {
						NaverSearchBookResponse response = new NaverSearchBookResponse();
						bookResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchBookResponse.class);
	}

	// FIXME:
	// How can I remove these warnings?
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<String> getSearchRecommendations(NaverSearchRequest request) {
		return search(request, new NaverSearchResponseCallback<List>() {
			@Override
			public List<String> callback(Element root) {
				List<String> searchRecommendations = new ArrayList<String>();

				List<Element> itemElements = root.getChildren(ELEMENT_ITEM);
				for (Element itemElement : itemElements) {
					searchRecommendations.add(itemElement.getText());
				}
				return searchRecommendations;
			}
		}, List.class);
	}

	@Override
	public NaverSearchCafeResponse searchCafe(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchCafeResponse>() {
					@Override
					public NaverSearchCafeResponse callback(Element root) {
						NaverSearchCafeResponse response = new NaverSearchCafeResponse();
						cafeResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchCafeResponse.class);
	}

	@Override
	public boolean checkForAdults(NaverSearchRequest request) {
		return search(request, new NaverSearchResponseCallback<Boolean>() {
			@Override
			public Boolean callback(Element root) {
				Element itemElement = root.getChild(ELEMENT_ITEM);
				return Integer.parseInt(itemElement.getChildText(ELEMENT_ADULT)) == TRUE_AS_INT;
			}
		}, Boolean.class);
	}

	@Override
	public NaverSearchEncyclopediaResponse searchEncyclopedia(
			NaverSearchRequest request) {
		return search(
				request,
				new NaverSearchResponseCallback<NaverSearchEncyclopediaResponse>() {
					@Override
					public NaverSearchEncyclopediaResponse callback(Element root) {
						NaverSearchEncyclopediaResponse response = new NaverSearchEncyclopediaResponse();
						encyclopediaResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchEncyclopediaResponse.class);
	}

	@Override
	public NaverSearchMovieResponse searchMovie(NaverSearchMovieRequest request) {
		// FIXME:
		// Doesn't handle the movie-specific parameters.
		return search(request,
				new NaverSearchResponseCallback<NaverSearchMovieResponse>() {
					@Override
					public NaverSearchMovieResponse callback(Element root) {
						NaverSearchMovieResponse response = new NaverSearchMovieResponse();
						movieResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchMovieResponse.class);
	}

	@Override
	public NaverSearchCafeArticleResponse searchCafeArticle(
			NaverSearchRequest request) {
		return search(
				request,
				new NaverSearchResponseCallback<NaverSearchCafeArticleResponse>() {
					@Override
					public NaverSearchCafeArticleResponse callback(Element root) {
						NaverSearchCafeArticleResponse response = new NaverSearchCafeArticleResponse();
						cafeArticleResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchCafeArticleResponse.class);
	}

	@Override
	public NaverSearchMovieActorResponse searchMovieActor(
			NaverSearchRequest request) {
		return search(
				request,
				new NaverSearchResponseCallback<NaverSearchMovieActorResponse>() {
					@Override
					public NaverSearchMovieActorResponse callback(Element root) {
						NaverSearchMovieActorResponse response = new NaverSearchMovieActorResponse();
						movieActorResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchMovieActorResponse.class);
	}

	@Override
	public NaverSearchCarResponse searchCar(NaverSearchCarRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchCarResponse>() {
					@Override
					public NaverSearchCarResponse callback(Element root) {
						NaverSearchCarResponse response = new NaverSearchCarResponse();
						carResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchCarResponse.class);
	}

	@Override
	public NaverSearchSiteResponse searchShortcut(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchSiteResponse>() {
					@Override
					public NaverSearchSiteResponse callback(Element root) {
						Element itemElement = root.getChild(ELEMENT_ITEM);
						Element shortcutElement = itemElement
								.getChild(ELEMENT_SHORTCUT);
						String label = shortcutElement
								.getChildText(ELEMENT_LABEL);
						String url = shortcutElement.getChildText(ELEMENT_URL);
						return new NaverSearchSiteResponse(label, url);
					}
				}, NaverSearchSiteResponse.class);
	}

	@Override
	public DefaultNaverSearchResponse searchKin(NaverSearchRequest request) {
		return search(request, DEFAULT_NAVER_SEARCH_RESPONSE_CALLBACK,
				DefaultNaverSearchResponse.class);
	}

	@Override
	public NaverSearchLocalResponse searchLocal(NaverSearchRequest request) {
		return search(request,
				new NaverSearchResponseCallback<NaverSearchLocalResponse>() {
					@Override
					public NaverSearchLocalResponse callback(Element root) {
						NaverSearchLocalResponse response = new NaverSearchLocalResponse();
						localResponseParser.parse(root, response);
						return response;
					}
				}, NaverSearchLocalResponse.class);
	}

	@Override
	public DefaultNaverSearchResponse searchWeb(NaverSearchWebRequest request) {
		return search(request, DEFAULT_NAVER_SEARCH_RESPONSE_CALLBACK,
				DefaultNaverSearchResponse.class);
	}

	@Override
	public String fixTypo(NaverSearchRequest request) {
		return search(request, new NaverSearchResponseCallback<String>() {
			@Override
			public String callback(Element root) {
				Element itemElement = root.getChild(ELEMENT_ITEM);
				return itemElement.getChildText(ELEMENT_ERRATA);
			}
		}, String.class);
	}

	private <T> T search(NaverSearchRequest request,
			NaverSearchResponseCallback<T> callback, Class<T> returnType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_KEY, searchApiKey);
		params.put(PARAM_TARGET, request.getSearchType().getTarget());
		params.put(PARAM_QUERY, request.getQuery());

		Integer display = request.getDisplay();
		if (display != null) {
			params.put(PARAM_DISPLAY, display);
		}

		Integer start = request.getStart();
		if (start != null) {
			params.put(PARAM_START, start);
		}

		NaverSearchSortType sortType = request.getSortType();
		if (sortType != NaverSearchSortType.NOT_AVAILABLE) {
			params.put(PARAM_SORT, sortType.getValue());
		}

		String apiUrl = UrlUtils.createUrl(NAVER_SEARCH_API_URL_PREFIX, params);
		log.debug(apiUrl);

		return search(apiUrl, callback, returnType);
	}

	private <T> T search(String apiUrl,
			NaverSearchResponseCallback<T> callback, Class<T> returnType) {
		InputStream is = null;
		try {
			is = HttpUtils.urlToInputStream(apiUrl);
			Element root = JDOMUtils.inputStreamToRootElement(is);
			return returnType.cast(callback.callback(root));
		} catch (IOException e) {
			e.printStackTrace();
			throw new NaverOpenApiFailException(e);
		} catch (JDOMException e) {
			e.printStackTrace();
			throw new NaverOpenApiFailException(e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private final NaverSearchResponseCallback<DefaultNaverSearchResponse> DEFAULT_NAVER_SEARCH_RESPONSE_CALLBACK = new NaverSearchResponseCallback<DefaultNaverSearchResponse>() {
		@Override
		public DefaultNaverSearchResponse callback(Element root) {
			DefaultNaverSearchResponse response = new DefaultNaverSearchResponse();
			defaultResponseParser.parse(root, response);
			return response;
		}
	};

}
