package core;

import bean.Result;

/**
 * Created by Lenovo on 2018/12/20.
 */

public interface DataCall<T> {

    void success(T data);

    void fail(Result result);

}
