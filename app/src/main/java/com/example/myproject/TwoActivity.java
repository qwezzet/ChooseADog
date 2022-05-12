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
                            if (state.getId().toLowerCase().contains(selectedFilter)) {
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

        String[] nm = getResources().getStringArray(R.array.dogs_names);
        String[] snm = getResources().getStringArray(R.array.dogs_secondnames);
        String[] dsc = getResources().getStringArray(R.array.dogs_descs);

        State avstrovch = new State("0", nm[0], snm[0], dsc[0], R.drawable.avstr);
        stateList.add(avstrovch);
        State akitainu = new State("1", nm[1], snm[1], dsc[1], R.drawable.akita);
        stateList.add(akitainu);
        State americstafford = new State("2", nm[2], snm[2], dsc[2], R.drawable.am_staff);
        stateList.add(americstafford);
        State englbulldog = new State("3", nm[3], snm[3], dsc[3], R.drawable.bull);
        stateList.add(englbulldog);
        State bassethaund = new State("4", nm[4], snm[4], dsc[4], R.drawable.bassh);
        stateList.add(bassethaund);
        State burnzennen = new State("5", nm[5], snm[5], dsc[5], R.drawable.zennen);
        stateList.add(burnzennen);
        State bigl = new State("6", nm[6], snm[6], dsc[6], R.drawable.bigl);
        stateList.add(bigl);
        State velshkorgi = new State("7", nm[7], snm[7], dsc[7], R.drawable.korgi);
        stateList.add(velshkorgi);
        State vesteuovcharka = new State("8", nm[8], snm[8], dsc[8], R.drawable.vesteuov);
        stateList.add(vesteuovcharka);
        State gavanbishon = new State("9", nm[9], snm[9], dsc[9], R.drawable.gavbish);
        stateList.add(gavanbishon);
        State dolmatin = new State("10", nm[10], snm[10], dsc[10], R.drawable.dolm);
        stateList.add(dolmatin);
        State doberman = new State("11", nm[11], snm[11], dsc[11], R.drawable.dober);
        stateList.add(doberman);
        State zapadsiblaika = new State("12", nm[12], snm[12], dsc[12], R.drawable.zaplaika);
        stateList.add(zapadsiblaika);
        State goldretriver = new State("13", nm[13], snm[13], dsc[13], R.drawable.retriv);
        stateList.add(goldretriver);
        State irelandvolkodav = new State("14", nm[14], snm[14], dsc[14], R.drawable.volkod);
        stateList.add(irelandvolkodav);
        State spanishmastif = new State("15", nm[15], snm[15], dsc[15], R.drawable.spmast);
        stateList.add(spanishmastif);
        State iorkterrer = new State("16", nm[16], snm[16], dsc[16], R.drawable.ioterr);
        stateList.add(iorkterrer);
        State kavkazovcharka = new State("17", nm[17], snm[17], dsc[17], R.drawable.kavov);
        stateList.add(kavkazovcharka);
        State kanecorso = new State("18", nm[18], snm[18], dsc[18], R.drawable.kane);
        stateList.add(kanecorso);
        State chinahohl = new State("19", nm[19], snm[19], dsc[19], R.drawable.chhohl);
        stateList.add(chinahohl);
        State komandor = new State("20", nm[20], snm[20], dsc[20], R.drawable.koman);
        stateList.add(komandor);
        State labladorretr = new State("21", nm[21], snm[21], dsc[21], R.drawable.labret);
        stateList.add(labladorretr);
        State leonberger = new State("22", nm[22], snm[22], dsc[22], R.drawable.leon);
        stateList.add(leonberger);
        State maltabalon = new State("23", nm[23], snm[23], dsc[23], R.drawable.balon);
        stateList.add(maltabalon);
        State mops = new State("24", nm[24], snm[24], dsc[24], R.drawable.mops);
        stateList.add(mops);
        State doichovcharka = new State("25", nm[25], snm[25], dsc[25], R.drawable.dovch);
        stateList.add(doichovcharka);
        State doichbokser = new State("26", nm[26], snm[26], dsc[26], R.drawable.bokser);
        stateList.add(doichbokser);
        State doichdog = new State("27", nm[27], snm[27], dsc[27], R.drawable.ddog);
        stateList.add(doichdog);
        State newfoundland = new State("28", nm[28], snm[28], dsc[28], R.drawable.newf);
        stateList.add(newfoundland);
        State pekines = new State("29", nm[29], snm[29], dsc[29], R.drawable.pekines);
        stateList.add(pekines);
        State pomeranskshpic = new State("30", nm[30], snm[30], dsc[30], R.drawable.pspic);
        stateList.add(pomeranskshpic);
        State pudel = new State("31", nm[31], snm[31], dsc[31], R.drawable.pudel);
        stateList.add(pudel);
        State rizenshaunzer = new State("32", nm[32], snm[32], dsc[32], R.drawable.rizen);
        stateList.add(rizenshaunzer);
        State rotveiler = new State("33", nm[33], snm[33], dsc[33], R.drawable.rotv);
        stateList.add(rotveiler);
        State russianborzya = new State("34", nm[34], snm[34], dsc[34], R.drawable.rusborz);
        stateList.add(russianborzya);
        State russiantoi = new State("35", nm[35], snm[35], dsc[35], R.drawable.rustoi);
        stateList.add(russiantoi);
        State samoed = new State("36", nm[36], snm[36], dsc[36], R.drawable.samoed);
        stateList.add(samoed);
        State senbernar = new State("37", nm[37], snm[37], dsc[37], R.drawable.senbr);
        stateList.add(senbernar);
        State taksa = new State("38", nm[38], snm[38], dsc[38], R.drawable.taksa);
        stateList.add(taksa);
        State tibetskimastif = new State("39", nm[39], snm[39], dsc[39], R.drawable.tibmast);
        stateList.add(tibetskimastif);
        State uippet = new State("40", nm[40], snm[40], dsc[40], R.drawable.uippet);
        stateList.add(uippet);
        State pharaondog = new State("41", nm[41], snm[41], dsc[41], R.drawable.phar);
        stateList.add(pharaondog);
        State francebulldog = new State("42", nm[42], snm[42], dsc[42], R.drawable.frbull);
        stateList.add(francebulldog);
        State hovavart = new State("43", nm[43], snm[43], dsc[43], R.drawable.hova);
        stateList.add(hovavart);
        State cvergshnaucer = new State("44", nm[44], snm[44], dsc[44], R.drawable.cvergs);
        stateList.add(cvergshnaucer);
        State chauchau = new State("45", nm[45], snm[45], dsc[45], R.drawable.chch);
        stateList.add(chauchau);
        State blackterrer = new State("46", nm[46], snm[46], dsc[46], R.drawable.blterr);
        stateList.add(blackterrer);
        State chihuahua = new State("47", nm[47], snm[47], dsc[47], R.drawable.chihua);
        stateList.add(chihuahua);
        State sharpay = new State("48", nm[48], snm[48], dsc[48], R.drawable.sharp);
        stateList.add(sharpay);
        State shitsu = new State("49", nm[49], snm[49], dsc[49], R.drawable.shitsu);
        stateList.add(shitsu);
        State elderterrer = new State("50", nm[50], snm[50], dsc[50], R.drawable.elterr);
        stateList.add(elderterrer);
        State dogwithblmouth = new State("51", nm[51], snm[51], dsc[51], R.drawable.blmouth);
        stateList.add(dogwithblmouth);
        State japanesexin = new State("52", nm[52], snm[52], dsc[52], R.drawable.jxin);
        stateList.add(japanesexin);
        State japaneseshpic = new State("53", nm[53], snm[53], dsc[53], R.drawable.jspic);
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
            if (state.getId().toLowerCase().contains(status)) {
                if (currentSearchText.equals("")) {
                    filteredStates.add(state);
                } else {
                    if (state.getId().toLowerCase().contains(currentSearchText.toLowerCase())) {
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

    public void bigbtn(View view) {filterList("3"); }

    public void midlebtn(View view) {
        filterList("2");
    }

    public void smallbtn(View view) {
        filterList("1");
    }

    public void storozhbtn(View view) {
        filterList("4");
    }

    public void housebtn(View view) { filterList("5"); }

    public void decorbtn(View view) { filterList("6"); }

    public void dlinnoshbtn(View view) {
        filterList("7");
    }

    public void korotkshbtn(View view) {
        filterList("8");
    }

    public void smeshbtn(View view) {
        filterList("9");
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