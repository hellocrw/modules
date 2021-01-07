package crw.demo.moduleservice.service.impl;

import crw.demo.moduleservice.service.ElasticSearchServcie;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

@Service("elasticSearchServcie")
public class ElasticSearchServiceImpl implements ElasticSearchServcie {
    @Override
    public String esQuery(String keyword) {
        TermQueryBuilder queryBuilders = QueryBuilders.termQuery("teamName", keyword);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilder query = searchSourceBuilder.query(queryBuilders);
        System.out.println(query);
        return "success";
    }
}
