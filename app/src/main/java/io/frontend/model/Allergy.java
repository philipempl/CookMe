package io.frontend.model;


import java.util.ArrayList;
import java.util.List;

class Allergy {

    private static final List<String> eggAllergy = new ArrayList<String>() {{
        add("Ei");
        add("Paniermehl");
        add("Käse");
    }};

    private static final List<String> nutAllergy = new ArrayList<String>() {{
        add("Nuss");
        add("Nüsse");
    }};

    private static final List<String> fishAllergy = new ArrayList<String>() {{
        add("Fisch");
        add("Barsch");
        add("Makrele");
        add("Barbe");
        add("Brasse");
        add("Mundi");
        add("Tilapia");
        add("Dorsch");
        add("Kabeljau");
        add("Lachs");
        add("Forelle");
        add("Hecht");
        add("Sardelle");
        add("Hering");
        add("Flunder");
        add("Seeteufel");
        add("Wels");
        add("Steinbeißer");
        add("Pangasius");
    }};

   private static final List<String> glutenAllergy = new ArrayList<String>() {{
        add("Brathering");
        add("Rollmops");
        add("Keks");
        add("Seitan");
        add("Weizen");
        add("Roggen");
        add("Hafer");
        add("Tritikale");
        add("Gerste");
        add("Dinkel");
        add("Grünkern");
        add("Einkorn");
        add("Emmer");
        add("Udon");
        add("Bulgur");
        add("Couscous");
        add("Cerealien");
        add("Malz");
        add("Getreide");
        add("Bier");
        add("Likör");
        add("Punsch");
        add("Glühwein");
    }};
    public static String getAllergy(String name)
    {
        for(String egg : eggAllergy) {
            if(egg.contains(name)) {
                return "Eier/-Erzeugnisse"; }}
        for(String nut : nutAllergy) {
            if(nut.contains(name)) {
                return "Erdnüsse/-Erzeugnisse";}}
        for(String fish : fishAllergy) {
            if(fish.contains(name)) {
                return "Fisch/-Erzeugnisse";}}
        for(String gluten : glutenAllergy) {
            if(gluten.contains(name)) {
                return "Glutenhaltiges Getreide/-Erzeugnisse"; }}

                return null;
    }
}
