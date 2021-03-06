package com.costular.marvelheroes.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.costular.marvelheroes.data.db.HeroesDao
import com.costular.marvelheroes.domain.model.MarvelHeroEntity

@Database(entities = [MarvelHeroEntity::class], version = 1)
abstract class HeroesDatabase : RoomDatabase() {

    abstract fun heroesDao(): HeroesDao

}