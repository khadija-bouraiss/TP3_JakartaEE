
import metier.MetierImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("dao", "metier", "config", "presentation");
                new AnnotationConfigApplicationContext("dao", "metier", "config");


        MetierImpl metier = ctx.getBean(MetierImpl.class);
        System.out.println(metier.calcul());

        ctx.close();
    }
}