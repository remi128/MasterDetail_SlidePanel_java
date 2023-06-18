package de.remi.masterdetail.data;

import java.util.ArrayList;
import java.util.List;

import de.remi.masterdetail.R;
import de.remi.masterdetail.model.Sport;

public class SportsData {
    List<Sport> list =  new ArrayList<>();

    public SportsData(){
        initList();
    }

    public List<Sport> getSportList(){
        return list;
    }

    private void initList(){

        list.add( new Sport(1, R.string.baseball, R.string.baseball_subtitle,
                R.drawable.icon_baseball, R.drawable.img_baseball
        ));

        list.add( new Sport(2, R.string.badminton, R.string.badminton_subtitle,
                R.drawable.icon_badminton, R.drawable.img_badminton
        ));

        list.add( new Sport(3, R.string.basketball, R.string.basketball_subtitle,
                R.drawable.icon_basketball, R.drawable.img_basketball
        ));

        list.add( new Sport(4, R.string.bowling, R.string.bowling_subtitle,
                R.drawable.icon_bowling, R.drawable.img_bowling
        ));

        list.add( new Sport(5, R.string.cycling, R.string.cycling_subtitle,
                R.drawable.icon_cycling, R.drawable.img_cycling
        ));

        list.add( new Sport(6, R.string.golf, R.string.golf_subtitle,
                R.drawable.icon_golf, R.drawable.img_golf
        ));

        list.add( new Sport(7, R.string.running, R.string.running_subtitle,
                R.drawable.icon_running, R.drawable.img_running
        ));

        list.add( new Sport(8, R.string.soccer, R.string.soccer_subtitle,
                R.drawable.icon_soccer, R.drawable.img_soccer
        ));

        list.add( new Sport(9, R.string.swimming, R.string.swimming_subtitle,
                R.drawable.icon_swimming, R.drawable.img_swimming
        ));

        list.add( new Sport(10, R.string.table_tennis, R.string.table_tennis_subtitle,
                R.drawable.icon_tabletennis, R.drawable.img_tabletennis
        ));

        list.add( new Sport(11, R.string.tennis, R.string.tennis_subtitle,
                R.drawable.icon_tennis, R.drawable.img_tennis
        ));


    }

}
