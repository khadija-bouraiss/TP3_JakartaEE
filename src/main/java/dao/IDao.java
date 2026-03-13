package dao;

// Cette interface est le contrat que toutes mes sources de données doivent respecter.
// Grâce à elle, MetierImpl ne connait jamais l'implémentation réelle — c'est le principe de POC.

public interface IDao {
  double getValue();
}