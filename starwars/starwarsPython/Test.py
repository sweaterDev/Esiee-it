from Film import Film
from Acteur import Acteur
from Personnage import Personnage

# Etape 2
film1 = Film("Star Wars, épisode IV : Un nouvel espoir", 1977, 4, 10000.87, 100000.98)
film2 = Film()
print(film1)

# Etape 3
perso1 = Personnage("Anne","solo")

# Etape 4
starwars = []
starwars.append(film1)
starwars.append(film2)
starwars.append(perso1)

# Etape 5
for persoFilm in starwars:
    print(persoFilm)

# Etape 8
perso2 = Personnage("chou", "baka")
duoPerso1 = (perso1, perso2)
act1 = Acteur("Ryan", "Goosling", duoPerso1)
