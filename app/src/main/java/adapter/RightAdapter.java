package adapter;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.monthtestel1220.R;

import java.util.ArrayList;
import java.util.List;

import app.MyApplication;
import bean.Goods;
import myClass.AddSubLayout;

/**
 * Created by Lenovo on 2018/12/20.
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ChildHolder> {

    private List<Goods> mList = new ArrayList<>();

    public void addAll(List<Goods> list) {
        mList.addAll(list);
    }

    @NonNull
    @Override
    public ChildHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = View.inflate(viewGroup.getContext(), R.layout.right_layout, null);
        ChildHolder myHolder = new ChildHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildHolder childHolder, int position) {

        final Goods goods = mList.get(position);
        childHolder.text.setText(goods.getTitle());
        childHolder.price.setText("单价：" + goods.getPrice());//单价
        String imageurl = "https" + goods.getImages().split("https")[1];
        Log.i("dt", "imageUrl: " + imageurl);
        imageurl = imageurl.substring(0, imageurl.lastIndexOf(".jpg") + ".jpg".length());
        Glide.with(MyApplication.getInstance()).load(imageurl).into(childHolder.image);//加载图片

        childHolder.addSub.setCount(goods.getNum());//设置商品数量
        childHolder.addSub.setAddSubListener(new AddSubLayout.AddSubListener() {
            @Override
            public void addSub(int count) {
                goods.setNum(count);
                onNumListener.onNum();//计算价格
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void clearList() {
        mList.clear();
    }


    class ChildHolder extends RecyclerView.ViewHolder {

        TextView text;
        TextView price;
        ImageView image;
        AddSubLayout addSub;

        public ChildHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.text_price);
            image = itemView.findViewById(R.id.image);
            addSub = itemView.findViewById(R.id.add_sub_layout);
        }
    }

    private OnNumListener onNumListener;

    public void setOnNumListener(OnNumListener onNumListener) {
        this.onNumListener = onNumListener;
    }

    public interface OnNumListener{
        void onNum();
    }
}