package text.poc.reetm.com.tvtest2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

public class MainFragment extends BrowseFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setBrandColor(ContextCompat.getColor(getActivity(),android.R.color.transparent));
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBadgeDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.boss));

        createDataRows();
    }

    private void createDataRows() {
        ArrayObjectAdapter rowsAdapter=new ArrayObjectAdapter(new ListRowPresenter());

        ArrayList<Movie> movies=new ArrayList<Movie>();
        movies.add(new Movie("Iron Man","IMDB","https://pre00.deviantart.net/e869/th/pre/i/2015/122/0/8/iron_man_pop_art_tile_by_headsupstudios-d2gxpf8.jpg"));
        movies.add(new Movie("Iron Man 2","Rotten Tomatoes","https://pre00.deviantart.net/e869/th/pre/i/2015/122/0/8/iron_man_pop_art_tile_by_headsupstudios-d2gxpf8.jpg"));
        movies.add(new Movie("Iron Man 3","Wikipedia","https://pre00.deviantart.net/e869/th/pre/i/2015/122/0/8/iron_man_pop_art_tile_by_headsupstudios-d2gxpf8.jpg"));
        movies.add(new Movie("Iron Man 4","Imagination","https://pre00.deviantart.net/e869/th/pre/i/2015/122/0/8/iron_man_pop_art_tile_by_headsupstudios-d2gxpf8.jpg"));

        //for(Movie movie:movies){
            ArrayObjectAdapter tilesAdapter=new ArrayObjectAdapter(new TestPresenter());
            for(Movie movie:movies){
                tilesAdapter.add(movie);
            }

            HeaderItem headerItem=new HeaderItem(0,"Movies");
            ListRow listRow=new ListRow(headerItem,tilesAdapter);
            rowsAdapter.add(listRow);

            HeaderItem headerItem1=new HeaderItem(1,"TV Shows");
            ListRow listRow1=new ListRow(headerItem1,new ArrayObjectAdapter(new TestPresenter()));
            rowsAdapter.add(listRow1);
        //}

        setAdapter(rowsAdapter);
    }
}
