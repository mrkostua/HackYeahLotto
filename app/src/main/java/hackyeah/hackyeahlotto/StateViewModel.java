package hackyeah.hackyeahlotto;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;
import hackyeah.hackyeahlotto.db.DbHelper;
import hackyeah.hackyeahlotto.db.GPSDDo;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Kostiantyn Prysiazhnyi on 11/25/2018.
 */

public class StateViewModel extends ViewModel {
    private String TAG = this.getClass().getSimpleName();
    private DbHelper dbHelper;
    public MutableLiveData<Integer> points = new MutableLiveData<>();
    private CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    public StateViewModel(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
        points.postValue(0);
    }

    public void subscribeToGPSResults() {
        disposables.add(dbHelper.getAllGPSData().observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<List<GPSDDo>>() {

                    @Override
                    public void onNext(List<GPSDDo> gpsList) {
                        Log.i(TAG, "OnNext : " + gpsList.size());
                        points.setValue(getPointsFromGPSList(gpsList));

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "Error " + t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete ");
                    }
                }));
    }

    private int getPointsFromGPSList(List<GPSDDo> gpsList) {
        int result = 0;
        for (int i = 0; i < gpsList.size(); i++) {
            Log.i(TAG, "point : " + gpsList.get(i).toString());
            if (gpsList.get(i).getSpeed() > 0 && gpsList.get(i).getSpeed() < 60) {
                result += 1;
            }
        }

        return result;

    }
}
