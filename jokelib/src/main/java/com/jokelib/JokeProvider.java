package com.jokelib;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class JokeProvider {

    private List<String> jokes;

    public JokeProvider()
    {
        jokes = new ArrayList<String>();
        jokes.add(" What do you call an alligator in a vest? An Investigator.");
        jokes.add(" What's the difference between a guitar and a fish? You can't tuna fish.");
        jokes.add(" What do you get from a pampered cow? Spoiled milk.");
        jokes.add(" What gets wetter the more it dries? A towel.");
        jokes.add(" What did the pencil say to the other pencil? Your looking sharp.");
        jokes.add(" Why did the picture go to jail? Because it was framed.");
        jokes.add(" Who earns a living driving their customers away? A taxi driver.");
        jokes.add(" How do you make holy water? Boil the hell out of it!");
        jokes.add(" What stays in the corner and travels all over the world? A stamp.");
        jokes.add(" What bow can't be tied? A rainbow!");
    }

    public String GetJoke()
    {
        return jokes.get(randInt(0,9));
    }

    private int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
