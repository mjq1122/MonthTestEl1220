package mvp;

import bean.Result;
import core.DataCall;

/**
 * Created by Lenovo on 2018/12/20.
 */

public class CartPresenter extends BasePresenter {


    public CartPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getData(Object... args) {
        Result result = CartModel.goodsList();//调用网络请求获取数据
        return result;
    }

}