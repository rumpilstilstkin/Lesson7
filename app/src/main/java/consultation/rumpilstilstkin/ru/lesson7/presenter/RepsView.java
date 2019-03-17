package consultation.rumpilstilstkin.ru.lesson7.presenter;


import com.arellomobile.mvp.MvpView;

import java.util.List;

import consultation.rumpilstilstkin.ru.lesson7.data.models.RepsModel;


public interface RepsView extends MvpView {

    void showError(Throwable e);

    void showLoading();

    void hideLoading();

    void showRepoList(List<RepsModel> list);

    void showEmptyState();
}
