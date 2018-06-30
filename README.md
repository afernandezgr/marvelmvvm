# Marvel Heroes 💪🏻

Marvel Heroes es una app para Android que muestra algunos de los súperheroes de Marvel con sus características.

 Main                      |  Detail
:-------------------------:|:-------------------------:
![main](https://raw.githubusercontent.com/costular/marvel-super-heroes/master/art/main.png) | ![detail](https://raw.githubusercontent.com/costular/marvel-super-heroes/master/art/detail.png)

## Características ✨

- Kotlin
- MVVM
- Dagger2
- Room
- LiveData
-

## Notas 📝

- Utiliza una arquitectura MVVM Clean (simplificada). Se ha simplicado dicha arquitectura con motivo de demostrar el uso de una arquitectura limpia con batería de tests sin perder demasiado tiempo teniendo en cuenta que es una app demo.

- Se ha utilizado ActionBar en lugar de implementar Toolbar con el objetivo de ahorrar tiempo.

- He utilizado `notifyDataSetChanged()` por el mismo motivo que anteriormente: el tiempo. Sin embargo, lo recomendado sería utilizar [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html), el cual nos calcula la diferencia entre dos listas para refrescar la información con menos consumo de recursos y animando el resultado.

- Normalmente suelo aplicar BDD mediante [GivenWhenThen](https://martinfowler.com/bliki/GivenWhenThen.html), sin embargo, este no ha sido el caso (en todos los tests, al menos). Sí, una vez más por el mismo motivo 😛

- Se ha utilizado [Android KTX](https://github.com/android/android-ktx) para añadir ciertas extension functions muy interesantes y útiles para el desarrollo. Algunas como `Context.toast()` no están en el repositorio de Maven en el momento que se desarrolla esta app; aunque sí que lo está en el repositorio de GitHub.

-  Emplea [Room](https://developer.android.com/topic/libraries/architecture/room.html) para persistir los datos en base de datos. Repository gestiona los datos recuperados desde webservice y a su vez lo cachea en base de datos.

- Podría y debería haber más tests
