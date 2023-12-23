from Personnage import Personnage
class PersonnageMechant(Personnage):
    """
    Sous-classe de Personnage pour représenter un personnage méchant avec un attribut coteObscure.

    Auteur: Sebastien Mercellus
    Version: 1.0

    Attributes:
        coteObscure (bool): Indique si le personnage est du côté obscur.
    """

    def __init__(self, coteObscure=None):
        super().__init__()
        self.coteObscure = coteObscure

    @property
    def coteObscure(self):
        return self.coteObscure

    @coteObscure.setter
    def coteObscure(self, coteObscure):
        self.coteObscure = coteObscure

    def __str__(self):
        return f"PersonnageMechant{super().__str__()} [coteObscure={self._coteObscure}]"
