from Personnage import Personnage

class PersonnageGentil(Personnage):
    """
    Sous-classe de Personnage pour représenter un personnage gentil avec une force supplémentaire.

    Auteur: Sebastien Mercellus
    Version: 1.0

    Attributes:
        force (bool): La force du personnage gentil.
    """

    def __init__(self, force=None):
        super().__init__()
        self.force = force
        
    @property
    def force(self):
        return self.force

    @force.setter
    def coteObscure(self, force):
        self.force = force

    def __str__(self):
        return f"PersonnageGentil{super().__str__()} [force={self.force}]"
