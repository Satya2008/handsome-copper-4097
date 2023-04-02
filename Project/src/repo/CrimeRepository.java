package repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Crime;
import model.Criminal;

public class CrimeRepository {
    public static Map<Integer, Crime> CrimeRepo = new HashMap<>();

    public static Map<Integer, List<Criminal>> crimeCriminalRepo = new HashMap<>();

}