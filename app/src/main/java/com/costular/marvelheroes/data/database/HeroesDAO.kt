package com.costular.marvelheroes.data.db

import android.arch.persistence.room.*
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class HeroesDao {

    @Query("SELECT * FROM heroes")
    abstract fun getAllHeroes(): Maybe<List<MarvelHeroEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertAll(heroes: List<MarvelHeroEntity>)

    @Query("DELETE FROM heroes")
    abstract fun deleteAllHeroes()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun updateHero(hero: MarvelHeroEntity)

}