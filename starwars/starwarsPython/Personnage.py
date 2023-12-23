class Personnage:
    """
    Classe Personnage pour représenter un personnage avec un nom et un prénom.

    Auteur: Sebastien Mercellus
    Version: 1.0

    Attributes:
        nom (str): Le nom du personnage.
        prenom (str): Le prénom du personnage.
    """

    def __init__(self, nom=None, prenom=None):
        self.nom = nom
        self.prenom = prenom
    

    def __str__(self):
        return f"Personnage [nom={self.nom}, prenom={self.prenom}]"
