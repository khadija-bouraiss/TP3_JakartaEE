package metier;

import dao.IDao;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implémentation de la couche métier (Business Logic Layer).
 * Cette classe contient les règles et traitements métier de l'application.
 *
 * @Component("metier") : enregistre cette classe comme bean Spring
 * sous le nom "metier" dans le conteneur IoC.
 * Spring la détecte automatiquement grâce au scan des composants.
 */
@Component("metier")
public class MetierImpl implements IMetier {

  /**
   * Dépendance vers la couche DAO, gérée entièrement par Spring.
   *
   * @Autowired : Spring recherche dans son conteneur un bean
   * compatible avec le type IDao et l'injecte automatiquement.
   * C'est le principe fondamental de l'injection de dépendances (DI).
   * <p>
   * Avantage : MetierImpl ne crée jamais elle-même son DAO
   * couplage faible, code testable et maintenable.
   */
  @Autowired


  private IDao dao;

  @PostConstruct
  private void init() {
    System.out.println("[TRACE] DAO injecté = " + dao.getClass().getSimpleName());
  }

  /**
   * Applique la logique métier sur la donnée récupérée depuis le DAO.
   * <p>
   * Principe de séparation des responsabilités (SoC) :
   * - Le DAO s'occupe uniquement de récupérer la donnée brute
   * - Le Métier s'occupe uniquement de la transformer/traiter
   *
   * @return le résultat du calcul : valeur du DAO multipliée par 2
   */
  @Override
  public double calcul() {
    return dao.getValue() * 2;
  }

  /**
   * Setter permettant une injection de dépendance manuelle.
   * Alternative à @Autowired pour les tests unitaires (ex: Mockito)
   * ou pour une configuration XML Spring (property ref="dao").
   *
   * @param dao l'implémentation de IDao à utiliser
   */
  public void setDao(IDao dao) {
    this.dao = dao;
  }


}