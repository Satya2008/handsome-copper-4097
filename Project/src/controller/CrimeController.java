package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Crime;
import model.CrimeType;
import model.Criminal;
import model.UpdateCrime;
import repo.CrimeRepository;
import repo.CriminalRepository;

public class CrimeController {


    public String addCrimeDetail(Crime crime){
        CrimeRepository.CrimeRepo.put(crime.getCrimeId(), crime);
        return crime.getCrimeId()+" successfully recorded !!";
    }

    public String updateCrimeType(int id, UpdateCrime updateCrime){
        Crime crime = CrimeRepository.CrimeRepo.get(id);
        if(updateCrime.getType() != null){
            crime.setType(updateCrime.getType());
        }

        if(updateCrime.getDesc() != null){
            crime.setDesc(updateCrime.getDesc());
        }

        if(updateCrime.getPsArea() != null){
            crime.setPsArea(updateCrime.getPsArea());
        }

        if(updateCrime.getVictim() != null){
            crime.setVictim(updateCrime.getVictim());
        }

        if(updateCrime.getDate() != null){
            crime.setDate(updateCrime.getDate());
        }

        CrimeRepository.CrimeRepo.put(id,crime);

        return crime.getCrimeId()+" successfully Updated !!";
    }

    public String deleteCrimeByCrimeId(int id){
        CrimeRepository.CrimeRepo.remove(id);
        return id+" successfully Deleted !!";
    }

    public String addCriminalToCrime(Crime crime, Criminal criminal){
        List<Criminal> criminalList;
        List<Crime> crimeList;
        if(CrimeRepository.crimeCriminalRepo.containsKey(crime.getCrimeId())){
            criminalList = CrimeRepository.crimeCriminalRepo.get(crime.getCrimeId());

        }else{
            criminalList = new ArrayList<>();
        }
        criminalList.add(criminal);
        CrimeRepository.crimeCriminalRepo.put(crime.getCrimeId(), criminalList);

        if(CriminalRepository.criminalCrimeRepo.containsKey(criminal.getCriminalId())){
            crimeList = CriminalRepository.criminalCrimeRepo.get(criminal.getCriminalId());
        }
        else{
            crimeList = new ArrayList<>();
        }
        crimeList.add(crime);
        CriminalRepository.criminalCrimeRepo.put(criminal.getCriminalId(),crimeList);

        return criminal.getName()+" Added to crime "+crime.getCrimeId();
    }

    public String removeCriminalToCrime(Crime crime, Criminal criminal){
        List<Criminal> criminalList;
        List<Crime> crimeList;
        if(CrimeRepository.crimeCriminalRepo.containsKey(crime.getCrimeId())){
            criminalList = CrimeRepository.crimeCriminalRepo.get(crime.getCrimeId());
            criminalList.remove(criminal);
            if(criminalList.size()>0){
                CrimeRepository.crimeCriminalRepo.put(crime.getCrimeId(), criminalList);
            }else{
                CrimeRepository.crimeCriminalRepo.remove(crime.getCrimeId());
            }

        }else{
            return "No crime found for this criminal !!";
        }

        if(CriminalRepository.criminalCrimeRepo.containsKey(criminal.getCriminalId())){
            crimeList = CriminalRepository.criminalCrimeRepo.get(criminal.getCriminalId());
            crimeList.remove(crime);
            if(crimeList.size()>0){
                CriminalRepository.criminalCrimeRepo.put(criminal.getCriminalId(),crimeList);
            }else{
                CriminalRepository.criminalCrimeRepo.remove(criminal.getCriminalId());
            }
        }
        else{
            return "No Criminal found for this crime !!";
        }

        return criminal.getName()+" removed from crime "+crime.getCrimeId();
    }

    public Crime searchCrimeByDesc(String crimeDesc){
        for(Map.Entry<Integer, Crime> entry : CrimeRepository.CrimeRepo.entrySet()){
            if(entry.getValue().getDesc().equalsIgnoreCase(crimeDesc)){
                return entry.getValue();
            }
        }
        return null;
    }

    public Map<CrimeType, Integer> totalCrimeByType(CrimeType type, Date from , Date to){
        Map<CrimeType, Integer> map = new HashMap<>();
        for(Map.Entry<Integer, Crime> entry : CrimeRepository.CrimeRepo.entrySet()){
            Crime c = entry.getValue();
            if(c.getType() == type && c.getDate().compareTo(from)>=0 && c.getDate().compareTo(to)<=0){
                map.put(c.getType(), map.getOrDefault(c.getType(),0)+1);
            }
        }
        return map;
    }

    public Map<String, Integer> totalCrimeByPS(String ps, Date from, Date to){
        Map<String, Integer> map = new HashMap<>();

        for(Map.Entry<Integer, Crime> entry : CrimeRepository.CrimeRepo.entrySet()){
            Crime c = entry.getValue();
            if(c.getPsArea().equalsIgnoreCase(ps) && c.getDate().compareTo(from)>=0 && c.getDate().compareTo(to)<=0){
                map.put(c.getPsArea(), map.getOrDefault(c.getPsArea(),0)+1);
            }
        }
        return map;
    }

}
