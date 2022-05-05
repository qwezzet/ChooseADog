package com.example.myproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity  {

    public static ArrayList<State> stateList = new ArrayList<State>();
    private ListView listView;
    ImageButton tabl;
    SearchView stateListSearchView;
    private LinearLayout filterLinearView1;
    private LinearLayout filterLinearView2;
    private Button filterButton;
    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;
    boolean filterHidden = true;


    @Override

    protected void onCreate(Bundle savedInstanceState) {


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setupData();
        initWidgets();
        setupList();
        initSearchWidgets();
        setupOnClickListener();
        hideFilter();

        tabl = findViewById(R.id.btntotbl);
        stateListSearchView = findViewById(R.id.stateListSearchView);
        tabl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoActivity.this, Table.class);
                startActivity(i);
            }
        });


    }

    private void hideFilter() {
        searchView.setVisibility(View.INVISIBLE);
        filterLinearView1.setVisibility(View.INVISIBLE);
        filterLinearView2.setVisibility(View.INVISIBLE);
        filterButton.setText("Фильтры и поиск");

    }
    private void showFilter() {
        searchView.setVisibility(View.VISIBLE);
        filterLinearView1.setVisibility(View.VISIBLE);
        filterLinearView2.setVisibility(View.VISIBLE);
        filterButton.setText("Закрыть");
    }

    private void initWidgets() {
        filterButton = (Button) findViewById(R.id.sortandsearchButton);
        filterLinearView1 = (LinearLayout) findViewById(R.id.filterTabsLayout);
        filterLinearView2 = (LinearLayout) findViewById(R.id.filterTabsLayoutSecond);

    }




    private void initSearchWidgets() {
        searchView = (SearchView) findViewById(R.id.stateListSearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                currentSearchText = s;

                ArrayList<State> filteredStates = new ArrayList<State>();

                for (State state : stateList) {
                    if (state.getPoroda().toLowerCase().contains(s.toLowerCase())) {
                        if (selectedFilter.equals("all")) {


                            filteredStates.add(state);
                        } else {
                            if (state.getPoroda().toLowerCase().contains(selectedFilter)) {
                                filteredStates.add(state);
                            }
                        }
                    }
                }
                StateAdapter adapter = new StateAdapter(getApplicationContext(), 0, filteredStates);
                listView.setAdapter(adapter);

                return false;

            }
        });
    }


    private void setupData() {
        State avstrovch = new State("0", "Австралийская овчарка", R.drawable.img_avstr_ovch);
        stateList.add(avstrovch);
        State akitainu = new State("1", "Акита-Ину", R.drawable.img_akita_inu);
        stateList.add(akitainu);
        State americstafford = new State("2", "Американский стаффордширский терьер", R.drawable.img_americ_stafford);
        stateList.add(americstafford);
        State englbulldog = new State("3", "Английский бульдог", R.drawable.img_engl_bulldog);
        stateList.add(englbulldog);
        State bassethaund = new State("4", "Бассет-Хаунд", R.drawable.img_basset_haund);
        stateList.add(bassethaund);
        State burnzennen = new State("5", "Бернский зенненхунд", R.drawable.img_burn_zennen);
        stateList.add(burnzennen);
        State bigl = new State("6", "Бигль", R.drawable.img_bigl);
        stateList.add(bigl);
        State velshkorgi = new State("7", "Вельш-корги", R.drawable.img_velsh_korgi);
        stateList.add(velshkorgi);
        State vesteuovcharka = new State("8", "Восточноевропейская овчарка", R.drawable.img_vesteu_ovcharka);
        stateList.add(vesteuovcharka);
        State gavanbishon = new State("9", "Гаванский бишон", R.drawable.img_gavan_bishon);
        stateList.add(gavanbishon);
        State dolmatin = new State("10", "Далматин", R.drawable.img_dolmatin);
        stateList.add(dolmatin);
        State doberman = new State("11", "Доберман", R.drawable.img_doberman);
        stateList.add(doberman);
        State zapadsiblaika = new State("12", "Западносибирская лайка", R.drawable.img_zapadsib_laika);
        stateList.add(zapadsiblaika);
        State goldretriver = new State("13", "Золотистый ретривер", R.drawable.img_gold_retriver);
        stateList.add(goldretriver);
        State irelandvolkodav = new State("14", "Ирландский волкодав", R.drawable.img_ireland_volkodav);
        stateList.add(irelandvolkodav);
        State spanishmastif = new State("15", "Испанский мастиф", R.drawable.img_spanish_mastif);
        stateList.add(spanishmastif);
        State iorkterrer = new State("16", "Йоркширский терьер", R.drawable.img_iork_terrer);
        stateList.add(iorkterrer);
        State kavkazovcharka = new State("17", "Кавказская овчарка", R.drawable.img_kavkaz_ovcharka);
        stateList.add(kavkazovcharka);
        State kanecorso = new State("18", "Кане-корсо", R.drawable.img_kane_corso);
        stateList.add(kanecorso);
        State chinahohl = new State("19", "Китайская хохлатая", R.drawable.img_china_hohl);
        stateList.add(chinahohl);
        State komandor = new State("20", "Комондор", R.drawable.img_komandor);
        stateList.add(komandor);
        State labladorretr = new State("21", "Лабрадор-ретривер", R.drawable.img_lablador_retr);
        stateList.add(labladorretr);
        State leonberger = new State("22", "Леонбергер", R.drawable.img_leonberger);
        stateList.add(leonberger);
        State maltabalon = new State("23", "Мальтийская болонка", R.drawable.img_malta_balon);
        stateList.add(maltabalon);
        State mops = new State("24", "Мопс", R.drawable.img_mops);
        stateList.add(mops);
        State doichovcharka = new State("25", "Немецкая овчарка", R.drawable.img_doich_ovcharka);
        stateList.add(doichovcharka);
        State doichbokser = new State("26", "Немецкий боксер", R.drawable.img_doich_bokser);
        stateList.add(doichbokser);
        State doichdog = new State("27", "Немецкий дог", R.drawable.img_doich_dog);
        stateList.add(doichdog);
        State newfoundland = new State("28", "Ньюфаундленд", R.drawable.img_newfoundland);
        stateList.add(newfoundland);
        State pekines = new State("29", "Пекинес", R.drawable.img_pekines);
        stateList.add(pekines);
        State pomeranskshpic = new State("30", "Померанский шпиц", R.drawable.img_pomeransk_shpic);
        stateList.add(pomeranskshpic);
        State pudel = new State("31", "Пудель", R.drawable.img_pudel);
        stateList.add(pudel);
        State rizenshaunzer = new State("32", "Ризеншнауцер", R.drawable.img_rizenshaunzer);
        stateList.add(rizenshaunzer);
        State rotveiler = new State("33", "Ротвейлер", R.drawable.img_rotveiler);
        stateList.add(rotveiler);
        State russianborzya = new State("34", "Русская псовая борзая", R.drawable.img_russian_borzya);
        stateList.add(russianborzya);
        State russiantoi = new State("35", "Русский той", R.drawable.img_russian_toi);
        stateList.add(russiantoi);
        State samoed = new State("36", "Самоед", R.drawable.img_samoed);
        stateList.add(samoed);
        State senbernar = new State("37", "Сенбернар", R.drawable.img_senbernar);
        stateList.add(senbernar);
        State taksa = new State("38", "Такса", R.drawable.img_taksa);
        stateList.add(taksa);
        State tibetskimastif = new State("39", "Тибетский мастиф", R.drawable.img_tibetski_mastif);
        stateList.add(tibetskimastif);
        State uippet = new State("40", "Уиппет", R.drawable.img_uippet);
        stateList.add(uippet);
        State pharaondog = new State("41", "Фараонова собака", R.drawable.img_pharaon_dog);
        stateList.add(pharaondog);
        State francebulldog = new State("42", "Французский бульдог", R.drawable.img_france_bulldog);
        stateList.add(francebulldog);
        State hovavart = new State("43", "Ховаварт", R.drawable.img_hovavart);
        stateList.add(hovavart);
        State cvergshnaucer = new State("44", "Цвергшнауцер", R.drawable.img_cvergshnaucer);
        stateList.add(cvergshnaucer);
        State chauchau = new State("45", "Чау-чау", R.drawable.img_chau_chau);
        stateList.add(chauchau);
        State blackterrer = new State("46", "Черный терьер", R.drawable.img_black_terrer);
        stateList.add(blackterrer);
        State chihuahua = new State("47", "Чихуахуа", R.drawable.img_chihuahua);
        stateList.add(chihuahua);
        State sharpay = new State("48", "Шарпей", R.drawable.img_sharpay);
        stateList.add(sharpay);
        State shitsu = new State("49", "Ши-тцу", R.drawable.img_shi_tsu);
        stateList.add(shitsu);
        State elderterrer = new State("50", "Эрдельтерьер", R.drawable.img_elder_terrer);
        stateList.add(elderterrer);
        State dogwithblackmouth = new State("51", "Южнорусская овчарка", R.drawable.img_dogwithblackmouth);
        stateList.add(dogwithblackmouth);
        State japanesexin = new State("52", "Японский хин", R.drawable.img_japanese_xin);
        stateList.add(japanesexin);
        State japaneseshpic = new State("53", "Японский шпиц", R.drawable.img_japanese_shpic);
        stateList.add(japaneseshpic);


    }


    private void setupList() {
        listView = (ListView) findViewById(R.id.doglistview);
        StateAdapter dogadapter = new StateAdapter(getApplicationContext(), 0, stateList);
        listView.setAdapter(dogadapter);
    }


    private void setupOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                State selectedState = (State) (listView.getItemAtPosition(position));
                Intent showDeital = new Intent(getApplicationContext(), StateAboutDog.class);
                showDeital.putExtra("id", selectedState.getId());
                startActivity(showDeital);
            }
        });
    }




    private void filterList(String status) {
        selectedFilter = status;
        ArrayList<State> filteredStates = new ArrayList<State>();
        for (State state : stateList) {
            if (state.getPoroda().toLowerCase().contains(status)) {
                if (currentSearchText == "") {
                    filteredStates.add(state);
                } else {
                    if (state.getPoroda().toLowerCase().contains(currentSearchText.toLowerCase())) {
                        filteredStates.add(state);
                    }
                }
            }
        }
        StateAdapter adapter = new StateAdapter(getApplicationContext(), 0, filteredStates);
        listView.setAdapter(adapter);
    }


    public void allbtnfilterTapped(View view) {
        selectedFilter = "all";
        searchView.setQuery("", false);
        searchView.clearFocus();
        StateAdapter adapter = new StateAdapter(getApplicationContext(), 0, stateList);
        listView.setAdapter(adapter);
    }

    public void storozhbtnfilterTapped(View view) {
        filterList("Австралийская овчарка");
    }

    public void housebtnfilterTapped(View view) {
        filterList("Австралийская овчарка");
    }

    public void dlinnoshbtnfilterTapped(View view) {
        filterList("Австралийская овчарка");
    }

    public void korotkshbtnfilterTapped(View view) {
        filterList("Австралийская овчарка");
    }

    public void bigbtnfilterTapped(View view) {
        filterList("Австралийская овчарка");
    }

    public void midlebtnfilterTapped(View view) {
        filterList("Австралийская овчарка");
    }

    public void smallbtnfilterTapped(View view) {
        filterList("Австралийская овчарка");
    }




    public void showSortTapped(View view) {
        if (filterHidden == true){
            filterHidden = false;
            showFilter();
        }
        else {
            filterHidden = true;
            hideFilter();
        }
    }
}