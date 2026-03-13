package dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


//Utiliser @Primary pour définir
//@Primary
@Component("dao2")
@Profile("dev")
//@Profile("dev")
// Déclare cette classe comme un bean Spring avec l'identifiant "dao2"
public class DaoImpl2 implements IDao {
  @Override
  public double getValue() {
    // Cette implémentation alternative retourne 150.0
    return 456.0;
  }
}