package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {


    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "https://facebook.com/Caroline","Paris", "calme", "0756343523" ),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e","https://facebook.com/jack", "Paris","Sport", "0754325647"),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f", "https://facebook.com/chloé", "Paris", "March", "0745353678"),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a", "https://facebook.com/vincent", "Paris", "Tennis","0745363536"),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b", "https://facebook.com/élodie", "Paris", "Natation", "0777546454"),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c", "https://facebook.com/sylvain", "Paris", "Football","0745369845"),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d", "https://facebook.com/laetitia", "Paris", "Lecture","0765431201"),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b", "https://facebook.com/dan", "Paris", "Footing","0787654387"),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d","https://facebook.com/joseph", "Paris", "Basketball","0798996543"),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d", "https://facebook.com/emma", "Paris", "Animaux","0773213456"),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d", "https://facebook.com/patrick", "Paris", "Voyage","0776898776"),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d", "https://facebook.com/lodovic", "Paris", "Photographie","0787993344")
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }

    }




