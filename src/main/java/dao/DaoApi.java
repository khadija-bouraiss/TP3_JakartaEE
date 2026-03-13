package dao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// DaoApi.java
@Component("daoApi")
@Profile("api")
public class DaoApi implements IDao {
  @Override public double getValue() { return 321.0; }
}