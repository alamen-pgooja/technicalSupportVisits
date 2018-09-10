package exampol.com.task3th;

import exampol.com.task3th.Models.DaoMaster;
import exampol.com.task3th.Models.DaoSession;
import exampol.com.task3th.Models.SITEVISITLISTItem;

public class Application extends android.app.Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "SITEVISITLIST.db").getWritableDb()).newSession();

    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    /*
     * https://github.com/greenrobot/greenDAO/issues/369
     * */
}
