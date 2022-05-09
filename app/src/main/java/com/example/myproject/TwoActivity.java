package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class TwoActivity extends AppCompatActivity {

    public static ArrayList<State> stateList = new ArrayList<>();
    private ListView listView;
    ImageButton tabl;
    SearchView stateListSearchView;
    private LinearLayout filterLinearView1;
    private LinearLayout filterLinearView2;
    private LinearLayout filterLinearView3;
    private LinearLayout filterLinearView4;
    private LinearLayout filterLinearView5;
    private LinearLayout filterLinearView6;
    private LinearLayout filterLinearView7;
    private Button filterButton;
    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;
    boolean filterHidden = true;


    @SuppressLint("SourceLockedOrientationActivity")
    @Override

    protected void onCreate(Bundle savedInstanceState) {


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        setupData();
        initWidgets();
        setupList();
        initSearchWidgets();
        setupOnClickListener();
        hideFilter();

        tabl = findViewById(R.id.btntotbl);
        stateListSearchView = findViewById(R.id.stateListSearchView);
        tabl.setOnClickListener(v -> {
            Intent i = new Intent(TwoActivity.this, Table.class);
            startActivity(i);
        });


    }

    private void hideFilter() {
        String[] arayofe = getResources().getStringArray(R.array.two2);
        searchView.setVisibility(View.GONE);
        filterLinearView1.setVisibility(View.GONE);
        filterLinearView2.setVisibility(View.GONE);
        filterLinearView3.setVisibility(View.GONE);
        filterLinearView4.setVisibility(View.GONE);
        filterLinearView5.setVisibility(View.GONE);
        filterLinearView6.setVisibility(View.GONE);
        filterLinearView7.setVisibility(View.GONE);
        filterButton.setText(arayofe[0]);

    }

    private void showFilter() {
        String[] arayofe = getResources().getStringArray(R.array.two2);
        searchView.setVisibility(View.VISIBLE);
        filterLinearView1.setVisibility(View.VISIBLE);
        filterLinearView2.setVisibility(View.VISIBLE);
        filterLinearView3.setVisibility(View.VISIBLE);
        filterLinearView4.setVisibility(View.VISIBLE);
        filterLinearView5.setVisibility(View.VISIBLE);
        filterLinearView6.setVisibility(View.VISIBLE);
        filterLinearView7.setVisibility(View.VISIBLE);
        filterButton.setText(arayofe[1]);
    }

    private void initWidgets() {
        filterButton = findViewById(R.id.sortandsearchButton);
        filterLinearView1 = findViewById(R.id.filterTabsLayout);
        filterLinearView2 = findViewById(R.id.filterTabsLayoutSecond);
        filterLinearView3 = findViewById(R.id.filterTabsLayoutThird);
        filterLinearView4 = findViewById(R.id.filterTabsLayoutFour);
        filterLinearView5 = findViewById(R.id.filterTabsLayoutFive);
        filterLinearView6 = findViewById(R.id.filterTabsLayoutSix);
        filterLinearView7 = findViewById(R.id.filterTabsLayoutSeven);

    }


    private void initSearchWidgets() {
        searchView = findViewById(R.id.stateListSearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                currentSearchText = s;

                ArrayList<State> filteredStates = new ArrayList<>();

                for (State state : stateList) {
                    if (state.getPoroda().toLowerCase().contains(s.toLowerCase()) || state.getSecondporoda().toLowerCase().contains(s.toLowerCase())) {
                        if (selectedFilter.equals("all")) {


                            filteredStates.add(state);
                        } else {
                            if (state.getPoroda().toLowerCase().contains(selectedFilter) || state.getDescription().toLowerCase().contains(selectedFilter)) {
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
        String[] arrayofnames = getResources().getStringArray(R.array.dogs_names);
        String[] arrayofdesc = getResources().getStringArray(R.array.dogs_descs);
        String[] arrayofsecond = getResources().getStringArray(R.array.dogs_secondnames);
        State avstrovch = new State("0", arrayofnames[0], arrayofsecond[0],arrayofdesc[0], R.drawable.img_avstr_ovch);
        stateList.add(avstrovch);
        State akitainu = new State("1", arrayofnames[1], arrayofsecond[1], arrayofdesc[1], R.drawable.img_akita_inu);
        stateList.add(akitainu);
        State americstafford = new State("2", arrayofnames[2], arrayofsecond[2], arrayofdesc[2], R.drawable.img_americ_stafford);
        stateList.add(americstafford);
        State englbulldog = new State("3", arrayofnames[3], arrayofsecond[3], arrayofdesc[3], R.drawable.img_engl_bulldog);
        stateList.add(englbulldog);
        State bassethaund = new State("4", arrayofnames[4], arrayofsecond[4], arrayofdesc[4], R.drawable.img_basset_haund);
        stateList.add(bassethaund);
        State burnzennen = new State("5", arrayofnames[5], arrayofsecond[5], arrayofdesc[5], R.drawable.img_burn_zennen);
        stateList.add(burnzennen);
        State bigl = new State("6", arrayofnames[6], arrayofsecond[6], arrayofdesc[6], R.drawable.img_bigl);
        stateList.add(bigl);
        State velshkorgi = new State("7", arrayofnames[7], arrayofsecond[7], arrayofdesc[7], R.drawable.img_velsh_korgi);
        stateList.add(velshkorgi);
        State vesteuovcharka = new State("8", arrayofnames[8], arrayofsecond[8], arrayofdesc[8], R.drawable.img_vesteu_ovcharka);
        stateList.add(vesteuovcharka);
        State gavanbishon = new State("9", arrayofnames[9], arrayofsecond[9], arrayofdesc[9], R.drawable.img_gavan_bishon);
        stateList.add(gavanbishon);
        State dolmatin = new State("10", arrayofnames[10], arrayofsecond[10], arrayofdesc[10], R.drawable.img_dolmatin);
        stateList.add(dolmatin);
        State doberman = new State("11", arrayofnames[11], arrayofsecond[11], arrayofdesc[11], R.drawable.img_doberman);
        stateList.add(doberman);
        State zapadsiblaika = new State("12", arrayofnames[12], arrayofsecond[12], arrayofdesc[12], R.drawable.img_zapadsib_laika);
        stateList.add(zapadsiblaika);
        State goldretriver = new State("13", arrayofnames[13], arrayofsecond[13], arrayofdesc[13], R.drawable.img_gold_retriver);
        stateList.add(goldretriver);
        State irelandvolkodav = new State("14", arrayofnames[14], arrayofsecond[14], arrayofdesc[14], R.drawable.img_ireland_volkodav);
        stateList.add(irelandvolkodav);
        State spanishmastif = new State("15", arrayofnames[15], arrayofsecond[15], arrayofsecond[15], R.drawable.img_spanish_mastif);
        stateList.add(spanishmastif);
        State iorkterrer = new State("16", arrayofnames[16], arrayofsecond[16], arrayofdesc[16], R.drawable.img_iork_terrer);
        stateList.add(iorkterrer);
        State kavkazovcharka = new State("17", arrayofnames[17], arrayofsecond[17], arrayofdesc[17], R.drawable.img_kavkaz_ovcharka);
        stateList.add(kavkazovcharka);
        State kanecorso = new State("18", arrayofnames[18], arrayofsecond[18], arrayofdesc[18], R.drawable.img_kane_corso);
        stateList.add(kanecorso);
        State chinahohl = new State("19", arrayofnames[19], arrayofsecond[19], arrayofdesc[19], R.drawable.img_china_hohl);
        stateList.add(chinahohl);
        State komandor = new State("20", arrayofnames[20], arrayofsecond[20], arrayofdesc[20], R.drawable.img_komandor);
        stateList.add(komandor);
        State labladorretr = new State("21", arrayofnames[21], arrayofsecond[21], arrayofdesc[21], R.drawable.img_lablador_retr);
        stateList.add(labladorretr);
        State leonberger = new State("22", arrayofnames[22], arrayofsecond[22], arrayofdesc[22], R.drawable.img_leonberger);
        stateList.add(leonberger);
        State maltabalon = new State("23", arrayofnames[23], arrayofsecond[23], arrayofdesc[23], R.drawable.img_malta_balon);
        stateList.add(maltabalon);
        State mops = new State("24", arrayofnames[24], arrayofsecond[24], arrayofdesc[24], R.drawable.img_mops);
        stateList.add(mops);
        State doichovcharka = new State("25", arrayofnames[25], arrayofsecond[25], arrayofdesc[25], R.drawable.img_doich_ovcharka);
        stateList.add(doichovcharka);
        State doichbokser = new State("26", arrayofnames[26], arrayofsecond[26], arrayofdesc[26], R.drawable.img_doich_bokser);
        stateList.add(doichbokser);
        State doichdog = new State("27", arrayofnames[27], arrayofsecond[27], arrayofdesc[27], R.drawable.img_doich_dog);
        stateList.add(doichdog);
        State newfoundland = new State("28", arrayofnames[28], arrayofsecond[28], arrayofdesc[28], R.drawable.img_newfoundland);
        stateList.add(newfoundland);
        State pekines = new State("29", arrayofnames[29], arrayofsecond[29], arrayofdesc[29], R.drawable.img_pekines);
        stateList.add(pekines);
        State pomeranskshpic = new State("30", arrayofnames[30], arrayofsecond[30], arrayofdesc[30], R.drawable.img_pomeransk_shpic);
        stateList.add(pomeranskshpic);
        State pudel = new State("31", arrayofnames[31], arrayofsecond[31], arrayofdesc[31], R.drawable.img_pudel);
        stateList.add(pudel);
        State rizenshaunzer = new State("32", arrayofnames[32], arrayofsecond[32], arrayofdesc[32], R.drawable.img_rizenshaunzer);
        stateList.add(rizenshaunzer);
        State rotveiler = new State("33", arrayofnames[33], arrayofsecond[33], arrayofdesc[33], R.drawable.img_rotveiler);
        stateList.add(rotveiler);
        State russianborzya = new State("34", arrayofnames[34], arrayofsecond[34], arrayofdesc[34], R.drawable.img_russian_borzya);
        stateList.add(russianborzya);
        State russiantoi = new State("35", arrayofnames[35], arrayofsecond[35], arrayofdesc[35], R.drawable.img_russian_toi);
        stateList.add(russiantoi);
        State samoed = new State("36", arrayofnames[36], arrayofsecond[36], arrayofdesc[36], R.drawable.img_samoed);
        stateList.add(samoed);
        State senbernar = new State("37", arrayofnames[37], arrayofsecond[37], arrayofdesc[37], R.drawable.img_senbernar);
        stateList.add(senbernar);
        State taksa = new State("38", arrayofnames[38], arrayofsecond[38], arrayofdesc[38], R.drawable.img_taksa);
        stateList.add(taksa);
        State tibetskimastif = new State("39", arrayofnames[39], arrayofsecond[39], arrayofdesc[39], R.drawable.img_tibetski_mastif);
        stateList.add(tibetskimastif);
        State uippet = new State("40", arrayofnames[40], arrayofsecond[40], arrayofdesc[40], R.drawable.img_uippet);
        stateList.add(uippet);
        State pharaondog = new State("41", arrayofnames[41], arrayofsecond[41], arrayofdesc[41], R.drawable.img_pharaon_dog);
        stateList.add(pharaondog);
        State francebulldog = new State("42", arrayofnames[42], arrayofsecond[42], arrayofdesc[42], R.drawable.img_france_bulldog);
        stateList.add(francebulldog);
        State hovavart = new State("43", arrayofnames[43], arrayofsecond[43], arrayofdesc[43], R.drawable.img_hovavart);
        stateList.add(hovavart);
        State cvergshnaucer = new State("44", arrayofnames[44], arrayofsecond[44], arrayofdesc[44], R.drawable.img_cvergshnaucer);
        stateList.add(cvergshnaucer);
        State chauchau = new State("45", arrayofnames[45], arrayofsecond[45], arrayofdesc[45], R.drawable.img_chau_chau);
        stateList.add(chauchau);
        State blackterrer = new State("46", arrayofnames[46], arrayofsecond[46], arrayofdesc[46], R.drawable.img_black_terrer);
        stateList.add(blackterrer);
        State chihuahua = new State("47", arrayofnames[47], arrayofsecond[47], arrayofdesc[47], R.drawable.img_chihuahua);
        stateList.add(chihuahua);
        State sharpay = new State("48", arrayofnames[48], arrayofsecond[48], arrayofdesc[48], R.drawable.img_sharpay);
        stateList.add(sharpay);
        State shitsu = new State("49", arrayofnames[49], arrayofsecond[49], arrayofdesc[49], R.drawable.img_shi_tsu);
        stateList.add(shitsu);
        State elderterrer = new State("50", arrayofnames[50], arrayofsecond[50], arrayofdesc[50], R.drawable.img_elder_terrer);
        stateList.add(elderterrer);
        State dogwithblackmouth = new State("51", arrayofnames[51], arrayofsecond[51], arrayofdesc[51], R.drawable.img_dogwithblackmouth);
        stateList.add(dogwithblackmouth);
        State japanesexin = new State("52", arrayofnames[52], arrayofsecond[52], arrayofdesc[52], R.drawable.img_japanese_xin);
        stateList.add(japanesexin);
        State japaneseshpic = new State("53", arrayofnames[53], arrayofsecond[53], arrayofdesc[53], R.drawable.img_japanese_shpic);
        stateList.add(japaneseshpic);


    }


    private void setupList() {
        listView = findViewById(R.id.doglistview);
        StateAdapter dogadapter = new StateAdapter(getApplicationContext(), 0, stateList);
        listView.setAdapter(dogadapter);
    }


    private void setupOnClickListener() {
        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            State selectedState = (State) (listView.getItemAtPosition(position));
            Intent showDeital = new Intent(getApplicationContext(), StateAboutDog.class);
            showDeital.putExtra("id", selectedState.getId());
            startActivity(showDeital);
        });
    }


    private void filterList(String status) {
        selectedFilter = status;
        ArrayList<State> filteredStates = new ArrayList<>();
        for (State state : stateList) {
            if (state.getPoroda().toLowerCase().contains(status)) {
                if (currentSearchText.equals("")) {
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

    }

    public void housebtnfilterTapped(View view) {
        filterList("avstrovch");
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
        if (filterHidden) {
            filterHidden = false;
            showFilter();
        } else {
            filterHidden = true;
            hideFilter();
        }
    }
}