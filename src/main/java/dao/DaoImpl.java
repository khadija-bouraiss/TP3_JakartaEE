package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Implémentation concrète de l'interface IDao.
 * Représente la couche d'accès aux données (Data Access Object).
 *
 * @Component("dao") : Spring détecte automatiquement cette classe
 * lors du scan des composants et la enregistre comme bean
 * dans le conteneur IoC sous le nom "dao".
 */
@Component("dao")
@Profile("prod")

// Implémentation de production — activée uniquement avec le profil "prod"
// Simule une base de données réelle qui retourne 123.0

public class DaoImpl implements IDao {

  /**
   * Simule la récupération d'une donnée depuis une source externe
   * (base de données, fichier, API, etc.).
   * Ici, une valeur fixe est retournée à titre d'exemple.
   *
   * @return 100.0 — valeur simulée
   */
  @Override
  public double getValue() {
    return 123.0;
  }
}