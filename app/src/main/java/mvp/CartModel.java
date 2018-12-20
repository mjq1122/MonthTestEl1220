package mvp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import bean.Result;
import bean.Shop;
import http.HttpUtils;

/**
 * Created by Lenovo on 2018/12/20.
 */

public class CartModel {
    public static Result goodsList() {
        String resultString = HttpUtils.get("http://www.zhaoapi.cn/product/getCarts?uid=71");
        try {
            Gson gson = new Gson();

            Type type = new TypeToken<Result<List<Shop>>>() {
            }.getType();

            Result result = gson.fromJson(resultString, type);
//        Result<List<Goods>> result = new Result<>();
//        result.setCode(0);
//        List<Goods> list = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            Goods goods = new Goods();
//            goods.setImages("");
//            goods.setTitle("手机"+i);
//            list.add(goods);
//        }
//        result.setData(list);

            return result;
        } catch (Exception e) {

        }
        Result result = new Result();
        result.setCode(-1);
        result.setMsg("数据解析异常");
        return result;
    }

}
