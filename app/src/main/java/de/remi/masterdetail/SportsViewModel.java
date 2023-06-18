package de.remi.masterdetail;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import de.remi.masterdetail.data.SportsData;
import de.remi.masterdetail.model.Sport;

public class SportsViewModel extends ViewModel {
    private static final String TAG = "SportsViewModel";
    private MutableLiveData<List<Sport>> sportsList;
    private MutableLiveData<Sport> currentRecord = new MutableLiveData<>();

    public SportsViewModel(){
        List<Sport> sl = new SportsData().getSportList();
        sportsList = new MutableLiveData<>();
        sportsList.setValue( sl );
        currentRecord.setValue(sl.get(0));
    }

    public LiveData<Sport> getCurrentRecord() {
        return currentRecord;
    }

    public void setCurrentRecord(Sport currentSport) {
        Log.d(TAG, "setCurrentRecord: " + currentSport.id );
        currentRecord.setValue(currentSport);
        Log.d(TAG, "current Record is now: " + currentRecord.getValue().id );

    }

    public LiveData<List<Sport>> getSportList(){
        return sportsList;
    }
}
