package text.poc.reetm.com.tvtest2;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class TestPresenter extends Presenter {
    public static class TestViewHolder extends Presenter.ViewHolder{
        private TestCardView testCardView;
        public TestViewHolder(Context context, TestCardView view) {
            super(view);
            this.testCardView=view;
        }

        public void bind(Movie movie){
            testCardView.bind(movie);
        }

        public void unbind(){
            testCardView.unbind();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        final Context context=viewGroup.getContext();
        final TestCardView testCardView=new TestCardView(context, new TestCardView.CardClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Movie",Toast.LENGTH_LONG).show();
            }
        });
        return new TestViewHolder(context,testCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object o) {
        if(viewHolder instanceof TestViewHolder
                && o instanceof Movie){
            ((TestViewHolder)viewHolder).bind((Movie)o);
        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        if(viewHolder instanceof TestViewHolder){
            ((TestViewHolder)viewHolder).unbind();
        }
    }
}
