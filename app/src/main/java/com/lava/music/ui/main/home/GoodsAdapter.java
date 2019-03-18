package com.lava.music.ui.main.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lava.music.R;
import com.lava.music.data.network.model.Banner;
import com.lava.music.ui.base.BaseViewHolder;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener{

    private List<Banner.NewGoods> mData;

    public HomePageMvpView getView() {
        return view;
    }

    public void setView(HomePageMvpView view) {
        this.view = view;
    }

    private HomePageMvpView view;

    public GoodsAdapter(List<Banner.NewGoods> goods){
        mData = goods;
    }

    public void setData(List<Banner.NewGoods> good){
        mData.addAll(good);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.goods_item, viewGroup, false);
        view.setOnClickListener(this);
        return new GoodsHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        assert v != null;
        String id = (String) v.getTag();
        getView().viewGoods(id);
    }

    public class GoodsHolder extends BaseViewHolder{

        @BindView(R.id.goods_pic)
        ImageView pic;

        @BindView(R.id.goods_des)
        TextView txt_des;

        @BindView(R.id.goods_price)
        TextView price;



        @Override
        protected void clear() {
            price.setText(null);
            txt_des.setText(null);
            pic.setImageBitmap(null);
        }

        public GoodsHolder(View item){
            super(item);
            ButterKnife.bind(this, item);
        }

        @Override
        public void onBind(int position) {
            Banner.NewGoods goods = mData.get(position);
            price.setText(""+goods.getRetailPrice());
            txt_des.setText(goods.getName());
            Glide.with(pic.getContext())
                    .load(goods.getPicUrl())
                    .asBitmap()
                    .fitCenter()
                    .into(pic);
            itemView.setTag(goods.getID()+"");
        }
    }
}
