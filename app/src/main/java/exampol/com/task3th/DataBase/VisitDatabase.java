package exampol.com.task3th.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import exampol.com.task3th.Models.Visit;

@Database(entities = {Visit.class}, version = 1, exportSchema = false)
 public abstract class VisitDatabase extends RoomDatabase {
 public abstract DaoAccess daoAccess() ;
 }