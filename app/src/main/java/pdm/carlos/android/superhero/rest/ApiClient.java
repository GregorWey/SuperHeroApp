package pdm.carlos.android.superhero.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getSuperHero() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}