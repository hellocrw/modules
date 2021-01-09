package crw.demo.moduleservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import crw.demo.model.entity.OrderInfo;
import crw.demo.moduleservice.mapper.OrderInfoMapper;
import crw.demo.moduleservice.service.IOrderInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-09
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Override
    public  IPage<OrderInfo> findListByPage(Integer page, Integer pageCount){
        IPage<OrderInfo> wherePage = new Page<>(page, pageCount);
        OrderInfo where = new OrderInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(OrderInfo orderInfo){
        return baseMapper.insert(orderInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(OrderInfo orderInfo){
        return baseMapper.updateById(orderInfo);
    }

    @Override
    public OrderInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
