INSERT INTO statut (denomination) VALUES ('Occupé'), ('En ligne');

INSERT INTO utilisateur (nom, prenom, statut_id) VALUES ('John', 'DOE', 1), ('Fly', 'Jason', 2);

INSERT INTO competence (denomination) VALUES ('Développeur fullstack'), ('Anglais');

INSERT INTO competence_utilisateur (utilisateur_id, competence_id) VALUES (1,1), (1,2), (2,1);