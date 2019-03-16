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
import com.lava.music.data.network.model.Brand;
import com.lava.music.ui.base.BaseViewHolder;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @Inject
    LayoutInflater mInflater;

    private List<Brand> mData;

    public BrandAdapter (List<Brand> list) {
        mData = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        mInflater = LayoutInflater.from(viewGroup.getContext());
        View view = mInflater.inflate(R.layout.brand_item, viewGroup,false);
        return new BrandHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<Brand> list){
        mData.addAll(list);
        notifyDataSetChanged();
    }

    public class BrandHolder extends BaseViewHolder{

        @BindView(R.id.brand_pic)
        ImageView mBrandPic;
        @BindView(R.id.brand_name)
        TextView mBrandName;
        @BindView(R.id.brand_floor_price)
        TextView mBrandPrice;

        @Override
        protected void clear() {
            mBrandPic.setImageBitmap(null);
            mBrandName.setText(null);
            mBrandPrice.setText(null);
        }

        public BrandHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onBind(int position) {
            Brand item = mData.get(position);
            Glide.with(mBrandPic.getContext())
                    .load(item.getNew_pic_url())
                    .asBitmap()
                    //.centerCrop()
                    .into(mBrandPic);
            mBrandName.setText(item.getName());
            CharSequence price = mBrandPrice.getContext().getResources()
                    .getString(R.string.str_floor_price,""+item.getFloor_price());
            mBrandPrice.setText(price);
        }
    }
}
