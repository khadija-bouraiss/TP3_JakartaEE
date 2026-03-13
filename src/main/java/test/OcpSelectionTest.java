
package test;

import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import presentation.Presentation2;
import static org.junit.Assert.assertEquals;


// Ces tests prouvent que MetierImpl est vraiment fermé à la modification
// mais ouvert à l'extension — j'ajoute des implémentations sans toucher au métier.
public class OcpSelectionTest {

  @Test
  public void devProfile_choisitDao2_300() {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.getEnvironment().setActiveProfiles("dev");
    ctx.register(Presentation2.class);
    ctx.refresh();
    IMetier m = ctx.getBean(IMetier.class);
    assertEquals(300.0, m.calcul(), 1e-6);
    ctx.close();
  }

  @Test
  public void prodProfile_choisitDao_200(){
    System.setProperty("dao.target", "dao");  // force dao pour ce test
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.getEnvironment().setActiveProfiles("prod");
    ctx.register(Presentation2.class);
    ctx.refresh();
    IMetier m = ctx.getBean(IMetier.class);
    assertEquals(200.0, m.calcul(), 1e-6);
    ctx.close();
    System.clearProperty("dao.target");  // nettoie après le test
  }

  @Test
  public void propriete_daoApi_440() {
    System.setProperty("dao.target", "daoApi");
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.getEnvironment().setActiveProfiles("api");  // <-- ajoute ici
    ctx.register(Presentation2.class);
    ctx.refresh();
    IMetier m = ctx.getBean(IMetier.class);
    assertEquals(440.0, m.calcul(), 1e-6);
    ctx.close();
    System.clearProperty("dao.target");
  }
}