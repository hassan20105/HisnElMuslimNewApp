package com.hisnElMuslem.myapplication.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.hisnElMuslem.myapplication.Model.ZekrItems;

import java.util.List;

@Dao
public interface ZekrDao {
    @Insert
    long insertZekr(ZekrItems zekrItems);

    @Update
    int updateZekr(ZekrItems zekrItems);

    @Query("DELETE  FROM ZekrItems")
    int deleteAllZekr();

    @Query("SELECT * FROM ZekrItems where Category= (:input)")
    List<ZekrItems> selectZekrDetail(String input);

    @Query("SELECT zekr FROM ZekrItems where Category= (:input)")
    List<String> selectZekrOnly(String input);

    @Query("Update zekritems set favourite = (:f) where category= (:c)")
    void updateFavouriteCatalog(String c, int f);

    @Query("SELECT * FROM ZekrItems")
    List<ZekrItems> selectZekrDetail();

    @Query("SELECT Distinct Category FROM ZekrItems")
    List<String> selectCategoryDetail();

    @Query("SELECT Distinct Category FROM ZekrItems where favourite = 1")
    List<String> selectFavouriteCategoryDetail();

    @Query("SELECT  favourite FROM ZekrItems where category =(:input)")
    int selectDistinctFavourite(String input);

}
