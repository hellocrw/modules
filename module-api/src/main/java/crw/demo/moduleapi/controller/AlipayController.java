package crw.demo.moduleapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import crw.demo.model.entity.ResultBO;
import crw.demo.model.utils.ResultTool;
import crw.demo.moduleservice.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝
 * @author lcc
 * @data :2018年6月4日 上午10:55:46
 */
@RestController
public class AlipayController {

    @Autowired
    @Qualifier("alipayService")
    private AlipayService alipayService;

    /**
     * web 订单支付
     */
    @GetMapping("getPagePay")
    public Map<Object, Object> getPagePay() throws Exception{
        /** 模仿数据库，从后台调数据*/
        String outTradeNo = "19960310621211";
        Integer totalAmount = 1;
        String subject = "苹果28";

        String pay = alipayService.webPagePay(outTradeNo, totalAmount, subject);
        System.out.println(pay);

        Map<Object, Object> pays = new HashMap<>();
        pays.put("pay", pay);

        return pays;
    }

    /**
     * app 订单支付
     */
    @GetMapping("getAppPagePay")
    public ResultBO<?> getAppPagePay() throws Exception{
        /** 模仿数据库，从后台调数据*/
        String outTradeNo = "131233";
        Integer totalAmount = 1000;
        String subject = "天猫超市012";

        String pay = alipayService.appPagePay(outTradeNo, totalAmount, subject);

        Object json = JSONObject.toJSON(pay);

        System.out.println(json);

        return ResultTool.success(json);
    }

    /**
     * 交易查询
     */
    @PostMapping("aipayQuery")
    public ResultBO<?> alipayQuery() throws Exception{
        /**调取支付订单号*/
        String outTradeNo = "13123";

        String query = alipayService.query(outTradeNo);

        Object json = JSONObject.toJSON(query);

        /*JSONObject jObject = new JSONObject();
        jObject.get(query);*/
        return ResultTool.success(json);
    }

    /**
     * 退款
     * @throws AlipayApiException
     */
    @GetMapping("alipayRefund")
    public ResultBO<?> alipayRefund(
            @RequestParam("outTradeNo")String outTradeNo,
            @RequestParam(value = "outRequestNo", required = false)String outRequestNo,
            @RequestParam(value = "refundAmount", required = false)Integer refundAmount
    ) throws AlipayApiException {

        /** 调取数据*/
        //String outTradeNo = "15382028806591197";
        String refundReason = "用户不想购买";
        //refundAmount = 1;
        //outRequestNo = "22";

        String refund = alipayService.refund(outTradeNo, refundReason, refundAmount, outRequestNo);

        System.out.println(refund);

        return ResultTool.success(refund);
    }

    /**
     * 退款查询
     * @throws AlipayApiException
     */
    @PostMapping("refundQuery")
    public ResultBO<?> refundQuery() throws AlipayApiException{

        /** 调取数据*/
        String outTradeNo = "13123";
        String outRequestNo = "2";

        String refund = alipayService.refundQuery(outTradeNo, outRequestNo);

        return ResultTool.success(refund);

    }

    /**
     * 交易关闭
     * @throws AlipayApiException
     */
    @PostMapping("alipayclose")
    public ResultBO<?> alipaycolse() throws AlipayApiException{

        /** 调取数据*/
        String outTradeNo = "13123";

        String close = alipayService.close(outTradeNo);

        return ResultTool.success(close);
    }

}


