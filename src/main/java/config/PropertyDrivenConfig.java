package config;

import dao.IDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:app.properties")
@Profile("!prod & !dev & !file")

// Ma configuration préférée : je change juste app.properties
// et toute l'application bascule vers une autre source de données.
// Aucun recompilation, aucune modification de code.
public class PropertyDrivenConfig {

  private final ApplicationContext ctx;

  public PropertyDrivenConfig(ApplicationContext ctx) {
    this.ctx = ctx;
  }

  @Value("${dao.target:dao}")
  private String target;

  @Bean(name = "selectedDao")
  @Primary
  @DependsOn("propertySourcesPlaceholderConfigurer")
  public IDao selectedDao() {
    IDao bean = (IDao) ctx.getBean(target);
    if (bean == null) {
      throw new IllegalArgumentException("Inconnu: " + target);
    }
    return bean;
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}