package text.poc.reetm.com.tvtest2;

import android.content.Context;
import android.support.v17.leanback.widget.BaseCardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TestCardView extends BaseCardView {
    public interface CardClickListener{
        void onClick(View view);
    }

    ImageView ivTileImage;
    TextView tvMainTitle;
    TextView tvSubTitle;
    View parentView;

    public TestCardView(Context context, final CardClickListener cardClickListener) {
        super(context);

        LayoutInflater inflater=LayoutInflater.from(context);
        parentView=inflater.inflate(R.layout.view_test_card,this);

        ivTileImage=(ImageView)parentView.findViewById(R.id.iv_tile_image);
        tvMainTitle=(TextView)parentView.findViewById(R.id.tv_main_title);
        tvSubTitle=(TextView)parentView.findViewById(R.id.tv_sub_title);

        parentView.setFocusable(true);
        parentView.setFocusableInTouchMode(true);
        parentView.setClickable(true);

        parentView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cardClickListener.onClick(view);
            }
        });
    }

    public void setTitle(String title){
        tvMainTitle.setText(title);
    }

    public void setSubTitle(String subTitle){
        tvSubTitle.setText(subTitle);
    }

    public ImageView getTileImageView(){
        return ivTileImage;
    }

    public void bind(Movie movie){
        setTitle(movie.getTitle());
        setSubTitle(movie.getSubTitle());
        Picasso.get()
                .load(movie.getImgUrl())
                .into(ivTileImage);
    }

    public void unbind(){
        Picasso.get().cancelRequest(ivTileImage);
    }

}
