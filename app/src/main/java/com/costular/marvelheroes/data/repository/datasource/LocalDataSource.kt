package com.costular.marvelheroes.data.repository.datasource


import com.costular.marvelheroes.data.database.HeroesDatabase
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class LocalDataSource(private val heroesDatabase: HeroesDatabase) {

    fun getLocalMarvelHeroesList(): Flowable<List<MarvelHeroEntity>> =
            heroesDatabase
                    .heroesDao()
                    .getAllHeroes()
                    .toFlowable()

    fun saveHeroes(heroes: List<MarvelHeroEntity>) {
        Observable.fromCallable {
            heroesDatabase.heroesDao().insertAll(heroes)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun updateHero(hero: MarvelHeroEntity){
        Observable.fromCallable {
            heroesDatabase.heroesDao().updateHero(hero)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}