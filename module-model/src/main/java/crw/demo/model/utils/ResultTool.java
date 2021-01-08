package crw.demo.model.utils;

import crw.demo.model.entity.ResultBO;

public class ResultTool {

    public static ResultBO<?> success(Object refund) {
        return new ResultBO<>(refund);
    }

}
