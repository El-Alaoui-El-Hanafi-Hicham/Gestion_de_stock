import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionStock {
    private List<Produit> produits;
    private Scanner scanner;

    public GestionStock() {
        produits = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void lancerApplication() {
        int choix;
        do {
            afficherMenu();
            System.out.print("Entrez votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    ajouterProduit();
                    break;
                case 2:
                    modifierProduit();
                    break;
                case 3:
                    supprimerProduit();
                    break;
                case 4:
                    afficherProduits();
                    break;
                case 5:
                    rechercherProduit();
                    break;
                case 6:
                    calculerValeurStock();
                    break;
                case 7:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 7);
    }

    private void afficherMenu() {
        System.out.println("\n=== MENU GESTION DE STOCK ===");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher la liste des produits");
        System.out.println("5. Rechercher un produit par nom");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("7. Quitter");
    }

    private void ajouterProduit() {
        System.out.println("\n--- Ajout d'un nouveau produit ---");

        System.out.print("Code du produit: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nom du produit: ");
        String nom = scanner.nextLine();

        System.out.print("Quantité: ");
        int quantite = scanner.nextInt();

        System.out.print("Prix unitaire: ");
        double prixUnitaire = scanner.nextDouble();

        Produit nouveauProduit = new Produit(code, nom, quantite, prixUnitaire);
        produits.add(nouveauProduit);
        System.out.println("Produit ajouté avec succès!");
    }

    private void modifierProduit() {
        System.out.println("\n--- Modification d'un produit ---");

        System.out.print("Entrez le code du produit à modifier: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        Produit produit = trouverProduitParCode(code);
        if (produit == null) {
            System.out.println("Produit non trouvé.");
            return;
        }

        System.out.println("Produit actuel: " + produit);

        System.out.print("Nouveau nom (laissez vide pour ne pas modifier): ");
        String nouveauNom = scanner.nextLine();
        if (!nouveauNom.isEmpty()) {
            produit.setNom(nouveauNom);
        }

        System.out.print("Nouvelle quantité (-1 pour ne pas modifier): ");
        int nouvelleQuantite = scanner.nextInt();
        if (nouvelleQuantite != -1) {
            produit.setQuantite(nouvelleQuantite);
        }

        System.out.print("Nouveau prix (-1 pour ne pas modifier): ");
        double nouveauPrix = scanner.nextDouble();
        if (nouveauPrix != -1) {
            produit.setPrix(nouveauPrix);
        }

        System.out.println("Produit modifié avec succès!");
    }

    private void supprimerProduit() {
        System.out.println("\n--- Suppression d'un produit ---");

        System.out.print("Entrez le code du produit à supprimer: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        Produit produit = trouverProduitParCode(code);
        if (produit == null) {
            System.out.println("Produit non trouvé.");
            return;
        }

        produits.remove(produit);
        System.out.println("Produit supprimé avec succès!");
    }

    private void afficherProduits() {
        System.out.println("\n--- Liste des produits ---");
        if (produits.isEmpty()) {
            System.out.println("Aucun produit en stock.");
            return;
        }

        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }

    private void rechercherProduit() {
        System.out.println("\n--- Recherche de produit ---");

        System.out.print("Entrez le nom (ou partie du nom) à rechercher: ");
        String recherche = scanner.nextLine();

        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getNom().toLowerCase().contains(recherche.toLowerCase())) {
                resultats.add(produit);
            }
        }

        if (resultats.isEmpty()) {
            System.out.println("Aucun produit trouvé.");
        } else {
            System.out.println("Résultats de la recherche:");
            for (Produit produit : resultats) {
                System.out.println(produit);
            }
        }
    }

    private void calculerValeurStock() {
        double valeurTotale = 0;
        for (Produit produit : produits) {
            valeurTotale += produit.getQuantite() * produit.getPrix();
        }

        System.out.printf("\nValeur totale du stock: %.2f\n", valeurTotale);
    }

    private Produit trouverProduitParCode(int code) {
        for (Produit produit : produits) {
            if (produit.getCode() == code) {
                return produit;
            }
        }
        return null;
    }


}