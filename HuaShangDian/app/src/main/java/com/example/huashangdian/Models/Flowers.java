package com.example.huashangdian.Models;

import com.example.huashangdian.R;

import java.math.BigDecimal;

public class Flowers {
    public static Flower[] getFlowers(){
        return FLOWERS;
    }

//    public static Flower[] getFlowerAt(int param){
//        for (Flower flo: FLOWERS){
//            return flo.getImage();
//        }
//    }

    public static final Flower FLOWER_ONE = new Flower("Flower One", R.drawable.flower_one,
            new BigDecimal(10), "The sweet,almost sickly, smell of flowers cut through the soft scent of the morning's dewy grass.");

    public static final Flower FLOWER_TWO = new Flower("Flower Two", R.drawable.flower_two,
            new BigDecimal(20), "The flowers lay scattered on the grass like frozen flames, bringing their cool blaze to the late spring morning.");

    public static final Flower FLOWER_THREE = new Flower("Flower Three", R.drawable.flower_three,
            new BigDecimal(12), "People told tales about how rare flowers grew like weeds in the gardens; mint green jade vines with their " +
            "unique claw shaped flowers bloomed among the rich," +
            " deep red chocolate cosmos.");

    public static final Flower FLOWER_FOUR = new Flower("Flower Four", R.drawable.flower_four,
            new BigDecimal(16), "As delicate as the thinnest of tissues and as " +
            "vibrant as in Indian silk, the blooms with their various " +
            "forms added their perfume to the drawing room. The gardener would " +
            "clip them fresh every Monday and Thursday and pass them to the housekeeper for changing.");

    public static final Flower FLOWER_FIVE = new Flower("Flower Five", R.drawable.flower_five,
            new BigDecimal(21), "Think not that the bud isn't ready, nor that beneath the petals are not perfect. Think of it as art ready to bloom into" +
            " a sun ready to give of its light. Think of it as the flower it already is, perfect within and destined to open. " +
            "It is the promise, the hope within that is born to seek liberty and to be a giving part of our world.");

    public static final Flower FLOWER_SIX = new Flower("Flower Six", R.drawable.flower_six,
            new BigDecimal(15), "The dew and the bud are the sweetest chorus of the dawn, as if they were always supposed to be together, water " +
            "within and around. Inside is sweet aromas and petals of finest natural silk. It is a perfection to compliment the halo of buds around it, each of them a part of the beauty that is spring.");

    public static final Flower FLOWER_SEVEN = new Flower("Flower Seven", R.drawable.flower_seven,
            new BigDecimal(25), "Inside the protective layers of green, are the colours that will ignite the spring into the vibrancy " +
            "that lives in my memories. As they grow I will welcome the first colours as much as any bird welcomes the first cracks of her opening eggs. " +
            "For from those timid vibrant stripes comes the new flower, the new sweetness unto the world.");

    public static final Flower FLOWER_EIGHT = new Flower("Flower Eight", R.drawable.flower_eight,
            new BigDecimal(18), "April sees my birth-flower appear like buttons over the lawns, the daisy flowers meaning innocence and purity." +
            " Every petal lies perfect under the sun, white, yet kissed pink at the tips. I love that they come not in ones or twos, but in hundreds like an intense floral flash-mob.");

    public static final Flower FLOWER_NINE = new Flower("Flower Nine", R.drawable.flower_nine,
            new BigDecimal(30), "Sitting just behind her ear is a daisy tattoo. The flower isn't a simple outline, but a bloom as full as " +
            "any painted on a canvass. The petals have a soft pink hue, delicate against the sunny centre. I want to ask her what it means to her, why a simple " +
            "daisy flower? But before I summon the courage she's swept away in the crowd...");

    public static final Flower FLOWER_TEN = new Flower("Flower Ten", R.drawable.flower_ten,
            new BigDecimal(5), "The golden flowers were a sunrise that stayed, blooming with determined brilliance. " +
            "It was as if they saw they were not the leaves nor the grass, and so they became themselves all the more; ever more beautiful for their boldness.");

    public static final Flower[] FLOWERS = {FLOWER_ONE, FLOWER_TWO, FLOWER_THREE, FLOWER_FOUR, FLOWER_FIVE, FLOWER_SIX, FLOWER_SEVEN, FLOWER_EIGHT, FLOWER_NINE, FLOWER_TEN};
}

