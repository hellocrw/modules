package crw.demo.moduleapi.controller.test;

import crw.demo.moduleservice.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/hello/{id}")
    public String hello(@PathVariable(value = "id") String id){
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id);
            System.out.println("从缓存获取的数据"+ object);
            str = object.toString();
        }else{
            //从数据库中获取信息
            System.out.println("从数据库中获取数据");
            str = "测试【数据库数据】";
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id,str,10L, TimeUnit.MINUTES);
            System.out.println("数据插入缓存" + str);
        }
        return str;
    }
}
