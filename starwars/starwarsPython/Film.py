class Film:
    """
    Classe Film pour représenter un film avec un titre, une année de sortie, un numéro d'épisode,
    un coût, une recette, et une liste d'acteurs.

    Auteur: Sebastien Mercellus
    Version: 1.0
    """

    def __init__(self, titre=None, annee_sortie=None, numEpisode=None, cout=None, recette=None, acteur=None):
        """
        Constructeur pour la classe Film.

        Args:
            titre (str): Le titre du film.
            annee_sortie (int): L'année de sortie du film.
            numEpisode (int): Le numéro d'épisode du film.
            cout (float): Le coût de production du film.
            recette (float): La recette générée par le film.
            acteur (list[Acteur]): Une liste d'acteurs du film.
        """
        self.titre = titre
        self.annee_sortie = annee_sortie
        self.numEpisode = numEpisode
        self.cout = cout
        self.recette = recette
        self.acteur = acteur if acteur is not None else []
        

    def __str__(self):
        return (f"Class: {self.__class__.__name__} [Titre={self.titre}, "
                f"Annee_sortie={self.annee_sortie}, numEpisode={self.numEpisode}, "
                f"cout={self.cout}, Recette={self.recette}, acteur={self.acteur}]")

    def nbActeurs(self):
        """
        Retourne le nombre d'acteurs dans un film.

        Returns:
            int: Le nombre d'acteurs dans le film.
        """
        return len(self.acteur)

    def nbPersonnage(self):
        """
        Retourne le nombre total de personnages représentés par tous les acteurs dans un film.

        Returns:
            int: Le nombre total de personnages dans le film.
        """
        return sum(len(acteur.personnages) for acteur in self.acteur)

    def calculBenefice(self):
        """
        Calcule le bénéfice ou le déficit d'un film.

        Returns:
            tuple: Un tuple contenant le bénéfice (ou déficit) et un booléen indiquant si le film est bénéficiaire.
        """
        benefice = self.recette - self.cout
        return (benefice, benefice > 0)

    def isBefore(self, annee):
        """
        Détermine si l'année donnée est antérieure à l'année de sortie du film.

        Args:
            annee (int): L'année à comparer avec l'année de sortie du film.

        Returns:
            bool: True si l'année donnée est antérieure à l'année de sortie, False sinon.

        Raises:
            ValueError: Si l'année donnée est la même que l'année de sortie du film.
        """
        if self.annee_sortie == annee:
            raise ValueError("Ils sont de la même année")
        return self.annee_sortie > annee

    def tri(self):
        """
        Trie la liste des acteurs du film par ordre alphabétique de leurs noms.
        """
        self.acteur.sort(key=lambda acteur: acteur.nom)

    def makeBackUp(self, dictionnaire):
        """
        Affiche un résumé des films stockés dans un dictionnaire, organisé par année.

        Args:
            dictionnaire (dict): Un dictionnaire avec comme clé une année et comme valeur un objet Film.
        """
        for annee, film in dictionnaire.items():
            print(f"{annee} - {film.titre} - {film.calculBenefice()[0]}")
