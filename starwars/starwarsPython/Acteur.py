class Acteur:
    """
    Classe Acteur pour représenter un acteur avec un nom, un prénom, un duo de personnages et une liste de personnages.

    Auteur: Sebastien Mercellus
    Version: 1.0
    """

    def __init__(self, nom=None, prenom=None, personnages=None):
        self.nom = nom
        self.prenom = prenom
        self.personnages = personnages

    def __str__(self):
        return (f"class: {self.__class__.__name__}\n"
                f"Nom: {self.nom}\n"
                f"Prenom: {self.prenom}\n"
                f"Personnages: {self.personnages}")

    def nbPersonnages(self):
        """
        Retourne le nombre de personnages incarnés par l'acteur.

        Returns:
            int: Le nombre de personnages joués par l'acteur.
        """
        return len(self.personnages) 
