package com.costular.marvelheroes.data.repository.datasource


import com.costular.marvelheroes.data.database.HeroesDatabase
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class LocalDataSource(private val heroesDatabase: HeroesDatabase) {

    fun getLocalMarvelHeroesList(): Flowable<List<MarvelHeroEntity>> =
            heroesDatabase
                    .getHeroesDao()
                    .getAllHeroes()
                    .toFlowable()

    fun saveHeroes(heroes: List<MarvelHeroEntity>) {
        Observable.fromCallable {
            heroesDatabase.getHeroesDao().removeAndInsertHeroes(heroes)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}