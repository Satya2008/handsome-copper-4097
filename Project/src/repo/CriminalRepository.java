package repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Crime;
import model.Criminal;

public class CriminalRepository {
    public static Map<Integer, Criminal> CriminalRepo = new HashMap<>();

    public static Map<Integer, List<Crime>> criminalCrimeRepo = new HashMap<>();

    public static Map<String, Criminal> CriminalNameRepo = new HashMap<>();


}

