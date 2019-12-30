package com.example.huashangdian.Models;

import com.example.huashangdian.R;

public class NewFlowers {
    public static NewFlower[] getNewFlowers() {
        return NEWFLOWERS;
    }

    public static final NewFlower Anemone = new NewFlower("Anemone", R.drawable.anemone,
            "Scientific Name: Anemone A temperate-loving flower with a sturdy construction and tendency towards vibrant, long-lasting flowers, anemones are also called \"wind flowers\", " +
                    "a name derived from their scientific namesakes, the Greek gods Anemoi who ruled over the winds. ",
            "https://www.thespruce.com/growing-anemone-flowers-1316064");

    public static final NewFlower Gladiolus = new NewFlower("Gladiolus", R.drawable.gladiolus,
            "Scientific Name: Gladiolus Here's where flowers with names can get complicated: the gladiolus is part of the Iris family of plants but is commonly called the \"sword lily\" due to its long, " +
                    "thin trumpet reminiscent of true lilies. The scientific name comes from the Latin for sword, gladius.",
            "https://www.thespruce.com/gladiolus-flowers-1315704");

    public static final NewFlower Chrysanthemums = new NewFlower("Chrysanthemums", R.drawable.chrysanthemums,
            "Scientific Name: Chrysanthemum A flower with many meanings, the chrysanthemum is found mainly in East Asia and has great significance for Chinese, " +
                    "Japanese and Korean cultures where it can symbolise everything from grief and adversity to representing the Japanese Imperial Family.",
            "https://www.thespruce.com/fall-garden-mums-hardy-or-no-1402718");

    public static final NewFlower Hyacynth = new NewFlower("Hyacynth", R.drawable.hyacynth,
            "Scientific Name: Alstroemeria Finding their home along the warm eastern Mediterranean, hyacinths are often confused with the similar-looking " +
                    "muscari flower, another blue-budded plant which grows clusters of flowers along its stem. ",
            "https://www.theflowerexpert.com/content/growingflowers/growingflowers/hyacinth");

    public static final NewFlower Freesia = new NewFlower("Freesia", R.drawable.freesia,
            "Scientific Name: Freesia What we call freesias are actually cultivated hybrids of a number of flowers in the Freesia family, " +
                    "and that’s why we refer to them as their scientific name. Unlike many of the other entries in this list, " +
                    "these beautiful trumpet-like blooms aren’t named after something in Latin or Greek, but take their name from botanist and doctor Friedrich Freese. ",
            "https://www.theflowerexpert.com/content/mostpopularflowers/morepopularflowers/freesia");

    public static final NewFlower Carnation = new NewFlower("Carnation", R.drawable.carnation,
            "Scientific Name: Dianthus Just like we mentioned above, the humble dianthus is one of the UK's favourite flowering plants, and it's mainly native to " +
                    "Europe and Asia which explains our long-standing fascination with this hardy plant. ",
            "https://www.flowermeaning.com/carnation-flower-meaning/");

    public static final NewFlower Orchids = new NewFlower("Orchids ", R.drawable.orchids,
            "Scientific Name: Phalaenopsis Here's one you'd never have guessed! What we commonly call an orchid is actually known as a phalaenopsis, which is the cultivated flower of " +
                    "choice from the family of plants known as Orchidaceae. There are over 28,000 species of orchid " +
                    "family plants, but the phalaenopsis covers about 60 of those and is mainly native to Southern Asia and Queensland.",
            "https://www.gardeners.com/how-to/growing-orchids/5072.html");

    public static final NewFlower Tulips = new NewFlower("Tulips", R.drawable.tulips,
            "Scientific Name: Tulipa Closely related to the lily and with a long history of cultivation at Latitude 40° " +
                    "North - an area spanning Ukraine and Turkey along with the Caspian Sea and even all the way to " +
                    "China - tulips have been seen as a symbol of wealth and abundance through the ages. ",
            "https://www.almanac.com/plant/tulips");

    public static final NewFlower Lilies = new NewFlower("Lilies", R.drawable.lilies,
            "Scientific Name: Lilium Tall, majestic and strikingly-shaped: lilies are a popular choice for bouquets due to their unusual shape and scent. Like roses, lilies are an important cultural" +
                    " and literary device and are known throughout the temperature Northern Hemisphere for their beauty and resilience.",
            "https://www.almanac.com/plant/lilies");

    public static final NewFlower Rose = new NewFlower("Rose", R.drawable.rose,
            "Scientific Name: Rosa Perhaps the most famous flower on the list, the beautiful " +
                    "rose has attained cultural significance around the world and is often used to symbolise love, affection and beauty.",
            "https://www.almanac.com/plant/roses");

    public static final NewFlower Daffodil = new NewFlower("Daffodil", R.drawable.daffodil,
            "Scientific Name: Narcissus Daffodil, daffadowndilly, jonquil, lent lily - narcissus are iconic flowers well known to ancient civilisations for their botanical " +
                    "and medicinal value, and many of their names derive from their appearance in everyday life.",
            "https://www.almanac.com/plant/daffodils");

    public static final NewFlower Poppy = new NewFlower("Poppy", R.drawable.poppy,
            "Scientific Name: Papaver Beautiful but deadly, Europe and the Middle East have had a complex relationship with the " +
                    "poppy for thousands of years. Long known to contain powerful narcotic " +
                    "substances - morphine, opium and codeine are all created from the papaver somniferum - these innocuous flowers represent sleep, death and peace. ",
            "https://www.thespruce.com/poppy-plant-varieties-2132570");

    public static final NewFlower Sunflower = new NewFlower("Sunflower", R.drawable.sunflower,
            "Scientific Name: Helianthus Taking its name for the Greek words for sun \"helios\" and flower \"anthus\" respectively," +
                    " the sunflower is an iconic American plant known for its bright and cheery bloom with the striking brown centre.Amazingly, " +
                    "these towering giants can grow up to 300 cm tall: definitely not easy to work into a bouquet. ",
            "https://www.thespruce.com/grow-giant-sunflowers-1315841");

    public static final NewFlower[] NEWFLOWERS = {Anemone, Gladiolus, Chrysanthemums, Hyacynth, Freesia, Carnation, Orchids, Tulips, Lilies, Rose,Daffodil,Poppy,Sunflower};
}

