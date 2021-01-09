package crw.demo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderInfo对象", description="订单表")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private String orderId;

    private String userId;

    private String shoppingId;

    private String payment;

    private String paymentType;

    private String orderPostage;

    private String status;

    private String paymentTime;

    private String orderSendtime;

    private String orderEndtime;

    private String orderClosetime;

    private String paymentCreatetime;

    private String paymentUpdatetime;


}
