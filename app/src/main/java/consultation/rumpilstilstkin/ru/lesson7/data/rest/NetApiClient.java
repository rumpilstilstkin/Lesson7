package consultation.rumpilstilstkin.ru.lesson7.data.rest;


import java.util.List;

import consultation.rumpilstilstkin.ru.lesson7.data.Endpoints;
import consultation.rumpilstilstkin.ru.lesson7.data.models.RepsModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class NetApiClient implements NetApiClientInterface{

    private static NetApiClient ourInstance;

    public static NetApiClient getInstance() {
        if(ourInstance == null){
            ourInstance = new NetApiClient();
        }
        return ourInstance;
    }

    private Endpoints netApi = new ServiceGenerator().createService(Endpoints.class);

    @Override
    public Single<List<RepsModel>> getReps() {
        return netApi.getRepos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
