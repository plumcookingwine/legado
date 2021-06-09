package io.legado.app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.legado.app.data.entities.DrawLineEntity

@Dao
interface BookLineDao {

    @Query("SELECT * FROM `book_line` WHERE `chapterIndex` = :index")
    fun getLineByChapter(index: Int): LiveData<List<DrawLineEntity>>
}