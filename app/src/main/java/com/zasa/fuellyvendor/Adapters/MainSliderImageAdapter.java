package com.zasa.fuellyvendor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Response.App_Detail_Respone_Model;
import com.zasa.fuellyvendor.RoundedCornersTransformation;

import java.util.ArrayList;

public class MainSliderImageAdapter extends SliderViewAdapter<MainSliderImageAdapter.SliderAdapterVH> {

    Context context;
    View view;
    int radius = 20;
    int margin = 0;
    private ArrayList<App_Detail_Respone_Model.SliderApiModel> mData;

    public MainSliderImageAdapter(Context context, ArrayList<App_Detail_Respone_Model.SliderApiModel> data) {
        this.mData = data;
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        this.context = parent.getContext();
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_slider_layout_item, parent, false);
        return new SliderAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        App_Detail_Respone_Model.SliderApiModel LatestNewsResult = mData.get(position);
//        viewHolder.tv_title.setText(LatestNewsResult.getSlider_Title());
        String image = LatestNewsResult.getSlider_Image_Url();
        Picasso.get().load(image)
                .fit()
                .into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;


        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;
        }

    }
}
