package com.costular.marvelheroes.data.repository

import com.costular.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.costular.marvelheroes.data.repository.datasource.LocalDataSource
import com.costular.marvelheroes.data.repository.datasource.RemoteMarvelHeroesDataSource
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

/**
 * Created by costular on 17/03/2018.
 */
class MarvelHeroesRepositoryImpl(private val localDataSource: LocalDataSource,
                                 private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
                                 private val marvelHeroesMapper: MarvelHeroMapper)
    : MarvelHeroesRepository {


  override fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>> =
            getHeroesWS().concatWith(getHeroesDB())

    private fun getHeroesDB(): Observable<List<MarvelHeroEntity>> =
            localDataSource.getLocalMarvelHeroesList()
                    .toObservable()

    private fun getHeroesWS(): Observable<List<MarvelHeroEntity>> =
            remoteMarvelHeroesDataSource
                    .getMarvelHeroesList()
                    .map { marvelHeroesMapper.transformList(it) }
                    .doOnNext { localDataSource.saveHeroes(it) }


    override fun updateHero(hero:MarvelHeroEntity) {
            localDataSource.updateHero(hero)
    }
}