package consultation.rumpilstilstkin.ru.lesson7.data;


import java.util.List;

import consultation.rumpilstilstkin.ru.lesson7.data.models.RepsModel;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Endpoints {

    @GET("/repositories")
    Single<List<RepsModel>> getRepos();
}
