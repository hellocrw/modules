package crw.demo.moduleapi.controller.order;

import com.baomidou.mybatisplus.core.metadata.IPage;
import crw.demo.model.entity.OrderInfo;
import crw.demo.moduleservice.service.IOrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-09
 */
@Api(tags = {"订单表"})
@RestController
@RequestMapping("//order-info")
public class OrderInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOrderInfoService orderInfoService;


    @ApiOperation(value = "新增订单表")
    @PostMapping()
    public int add(@RequestBody OrderInfo orderInfo){
        return orderInfoService.add(orderInfo);
    }

    @ApiOperation(value = "删除订单表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return orderInfoService.delete(id);
    }

    @ApiOperation(value = "更新订单表")
    @PutMapping()
    public int update(@RequestBody OrderInfo orderInfo){
        return orderInfoService.updateData(orderInfo);
    }

    @ApiOperation(value = "查询订单表分页数据")
    @GetMapping()
    public IPage<OrderInfo> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return orderInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询订单表")
    @GetMapping("{id}")
    public OrderInfo findById(@PathVariable Long id){
        return orderInfoService.findById(id);
    }

}
