package consultation.rumpilstilstkin.ru.lesson7.data.rest;


import java.util.List;

import consultation.rumpilstilstkin.ru.lesson7.data.models.RepsModel;
import io.reactivex.Single;


public interface NetApiClientInterface {
    Single<List<RepsModel>> getReps();
}
