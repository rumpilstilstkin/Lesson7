package consultation.rumpilstilstkin.ru.lesson7.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import consultation.rumpilstilstkin.ru.lesson7.data.models.RepsModel;
import consultation.rumpilstilstkin.ru.lesson7.data.rest.NetApiClientInterface;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


@InjectViewState
public class RepsPresenter extends MvpPresenter<RepsView> implements SingleObserver<List<RepsModel>> {
    private NetApiClientInterface client;

    public RepsPresenter(NetApiClientInterface client) {
        this.client = client;
    }

    @Override
    public void attachView(RepsView view) {
        super.attachView(view);
        loadData();
    }

    @Override
    public void onSuccess(List<RepsModel> repsModels) {
        if(repsModels.isEmpty()){
            getViewState().showEmptyState();
        }else {
            getViewState().showRepoList(repsModels);
        }
        getViewState().hideLoading();
    }

    @Override
    public void onSubscribe(Disposable d) {
        //nope
    }

    @Override
    public void onError(Throwable t) {
        getViewState().showError(t);
        getViewState().hideLoading();
    }

    private void loadData() {
        getViewState().showLoading();
        client.getReps().subscribe(this);
    }
}
