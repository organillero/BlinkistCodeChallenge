package io.ferreyra.blinkist_code_challege.library.dagger;

import android.app.Activity;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.blinkist_code_challege.library.mvp.LibraryAdapter;
import io.ferreyra.blinkist_code_challege.library.mvp.LibraryModel;
import io.ferreyra.blinkist_code_challege.library.mvp.LibraryPresenter;
import io.ferreyra.blinkist_code_challege.library.mvp.LibraryView;
import io.ferreyra.blinkist_code_challege.network.BlkApi;

/**
 * Created by carlos on 10/19/17.
 */

@Module
public class LibraryModule {

    private final Activity activity;

    public LibraryModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @LibraryScope
    public LibraryAdapter providesMainAdapter (Picasso picasso){
        return new LibraryAdapter(picasso);
    }

    @Provides
    @LibraryScope
    public LibraryView providesMainView (LibraryAdapter adapter){
            return new LibraryView(activity, adapter);
    }

    @Provides
    @LibraryScope
    public LibraryModel providesMainModel (BlkApi seatGeekNetwork){
        return new LibraryModel(seatGeekNetwork);
    }

    @Provides
    @LibraryScope
    public LibraryPresenter providesMainPresenter (LibraryView view, LibraryModel model){
        return new LibraryPresenter(view, model);
    }

}
