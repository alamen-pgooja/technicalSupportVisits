package exampol.com.task3th.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import exampol.com.task3th.Models.Visit;

@Dao
public interface DaoAccess {

    //to ignore duplication
    @Insert(onConflict = 1)
    void insertVisit(Visit movies);

    @Insert(onConflict = 1)
    void insertMultipleVisits(List<Visit> visitList);

    @Query("SELECT * FROM VISITS WHERE id = :visitId")
    Visit fetchOneVisitById(int visitId);

    @Query("SELECT * FROM VISITS")
    List<Visit> fetchAllVisits();

    @Update
    void updateMovie(Visit visit);

    @Delete
    void deleteMovie(Visit visit);
}