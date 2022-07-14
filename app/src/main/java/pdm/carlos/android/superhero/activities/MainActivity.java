package pdm.carlos.android.superhero.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pdm.carlos.android.superhero.R;
import pdm.carlos.android.superhero.adapter.ItemClickListener;
import pdm.carlos.android.superhero.adapter.SuperHeroListAPIAdapter;
import pdm.carlos.android.superhero.banco.BDSQLiteHelper;
import pdm.carlos.android.superhero.banco.SuperheroBancoDados;
import pdm.carlos.android.superhero.banco.SalvaBancoInicial;
import pdm.carlos.android.superhero.model.SuperHero;
import pdm.carlos.android.superhero.rest.ApiClient;
import pdm.carlos.android.superhero.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    public static List<SuperHero> lista_SuperHeroes_API = new ArrayList<>();//lista que virá do retrofit
    public static List<SuperheroBancoDados> lista_SuperHeroes_BD = new ArrayList<>();//lista que irá para o banco
    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_mostraDadosAPI);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getSuperHero().create(ApiInterface.class);
        Call<List<SuperHero>> call = apiService.listSuperHeroes();

        Button mostrardadosbanco = (Button) findViewById(R.id.buttonmostrardadosbanco);
        mostrardadosbanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MostrarDadosBancoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        call.enqueue(new Callback<List<SuperHero>>() {
            @Override
            public void onResponse(Call<List<SuperHero>> call, Response<List<SuperHero>> response) {
                if (response.isSuccessful()) {
                    lista_SuperHeroes_API = response.body();

                    //converte do retrofit para um arraylist de objetos do tipo SuperheroBancoDados
                    SalvaBancoInicial a = new SalvaBancoInicial(lista_SuperHeroes_API);
                    lista_SuperHeroes_BD = a.salvaBancoInicial2();
                    bd = new BDSQLiteHelper(MainActivity.this);
                    if (bd.getAllSuperheros().size() <= 0) {
                        for (SuperheroBancoDados superhero : lista_SuperHeroes_BD) {
                            bd.addsuperhero(superhero);
                        }
                    }
                    SuperHeroListAPIAdapter adapter = new SuperHeroListAPIAdapter(lista_SuperHeroes_API, R.layout.layout_superhero, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    adapter.setClickListener(MainActivity.this);

                }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("API conectada com Sucesso!")
                        .setMessage("Foram baixados " + new Integer(lista_SuperHeroes_API.size()).toString() + " registros.")
                        .setIcon(android.R.drawable.star_big_on)
                        .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        }).show();
            }

            @Override
            public void onFailure(Call<List<SuperHero>> call, Throwable exception) {
                exception.printStackTrace();
                exception.printStackTrace();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Sem acesso a Internet")
                        .setMessage("Não foi possível baixar dados da API. Você será redirecionado para a tela com os dados do banco local." +
                                "Por favor, verifique a sua conexão a internet e tente novamente.")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        }).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View view, int position) {
        final SuperHero sh = lista_SuperHeroes_API.get(position);
        Intent i = new Intent(this, DetalhesSuperHeroAPIActivity.class);
        i.putExtra("ID", sh.getId());
        startActivity(i);
    }
}