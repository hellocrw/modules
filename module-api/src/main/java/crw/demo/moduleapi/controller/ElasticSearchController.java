package crw.demo.moduleapi.controller;

import crw.demo.moduleservice.service.ElasticSearchServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    private ElasticSearchServcie elasticSearchServcie;

    @Autowired
    public ElasticSearchController(ElasticSearchServcie elasticSearchServcie){
        this.elasticSearchServcie = elasticSearchServcie;
    }

    @GetMapping("/esQuery")
    public String esQuery(@RequestParam("keyword") String keyword){
        return elasticSearchServcie.esQuery(keyword);
    }
}
