package consultation.rumpilstilstkin.ru.lesson7;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import consultation.rumpilstilstkin.ru.lesson7.data.models.RepsModel;
import consultation.rumpilstilstkin.ru.lesson7.data.rest.NetApiClient;
import consultation.rumpilstilstkin.ru.lesson7.presenter.RepsPresenter;
import consultation.rumpilstilstkin.ru.lesson7.presenter.RepsView;


public class MainActivity extends MvpAppCompatActivity
        implements RepsView {

    ProgressBar progress;
    View content;
    View empty;

    @InjectPresenter(type = PresenterType.LOCAL)
    RepsPresenter repsPresenter;

    @ProvidePresenter(type = PresenterType.LOCAL)
    RepsPresenter providePresenter() {
        return new RepsPresenter(NetApiClient.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = findViewById(R.id.contentView);
        progress = findViewById(R.id.loadingView);
        empty = findViewById(R.id.emptyView);
    }

    @Override
    public void showLoading() {
        empty.setVisibility(View.INVISIBLE);
        content.setVisibility(View.INVISIBLE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showRepoList(List<RepsModel> list) {
        empty.setVisibility(View.INVISIBLE);
        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyState() {
        empty.setVisibility(View.VISIBLE);
        content.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
