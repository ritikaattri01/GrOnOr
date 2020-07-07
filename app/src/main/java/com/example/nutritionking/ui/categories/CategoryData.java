package com.example.nutritionking.ui.categories;

import java.util.Arrays;
import java.util.List;

public class CategoryData {

public String[] images={"https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=145,h=140/app/images/category/cms_images/icon/icon_cat_18_v_3_500_1584355882.jpg",
        "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=145,h=140/app/images/category/cms_images/icon/icon_cat_16_v_3_500_1580063793.jpg",
        "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=145,h=140/app/images/category/cms_images/icon/icon_cat_1487_v_3_500_1580063978.jpg",
        "https://www.bigbasket.com/media/uploads/p/mm/1200068_2-bb-combo-bb-royal-idli-rice-5kg-gota-urad-1kg-raw-peanut-500g.jpg",
        "https://www.bigbasket.com/media/uploads/p/mm/40174335_5-tirumalla-refined-rice-bran-oil.jpg",
        "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=145,h=140/app/images/category/cms_images/icon/icon_cat_12_v_3_500_1580062743.jpg",
        "https://www.bigbasket.com/media/uploads/p/mm/40181003_3-nakoda-titan-plastic-square-masala-box-assorted-colour.jpg",
        "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=145,h=140/app/images/category/cms_images/icon/icon_cat_13_v_3_500_1580068677.jpg",
        "https://www.bigbasket.com/media/uploads/p/mm/40084465_3-frosch-hygiene-cleaner-lavender-trigger.jpg",
        "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=145,h=140/app/images/category/cms_images/icon/icon_cat_163_v_3_500_1584073368.jpg",


    };

    public String[] names={"Detergent Powder and Liquids",
            "Atta, Flour & Rice",
            "Fruits & Vegetables",
            "Dal & Pulses",
            "Cooking Oils",
            "Snacks,Juice & Cold Drinks",
            "Masalas,Spices & Cooking Pastes",
            "Biscuits & Cookies",
            "Home Cleaners",
            "Soap,Handwash & more",

    };

    public List<String> getNames()
    {
        return Arrays.asList(names);
    }
    public List<String> getImages()
    {
        return Arrays.asList(images);
    }
}



