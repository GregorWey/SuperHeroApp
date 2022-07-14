package pdm.carlos.android.superhero.rest;

import java.util.List;

import pdm.carlos.android.superhero.model.SuperHero;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("all.json")
    Call<List<SuperHero>> listSuperHeroes();
}
