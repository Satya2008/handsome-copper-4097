package controller;

import model.Criminal;
import model.UpdateCriminal;
import repo.CriminalRepository;

public class CriminalController {
	   public String addCriminalDetail(Criminal criminal){
	        CriminalRepository.CriminalRepo.put(criminal.getCriminalId(), criminal);
	        CriminalRepository.CriminalNameRepo.put(criminal.getName(), criminal);
	        return criminal.getName()+" successfully recorded !!";
	    }

	    public String updateCriminalDetail(int id, UpdateCriminal updateCriminal){
	        Criminal criminal = CriminalRepository.CriminalRepo.get(id);
	        if(updateCriminal.getDob() != null){
	            criminal.setDob(updateCriminal.getDob());
	        }

	        if(updateCriminal.getGender() != null){
	            criminal.setGender(updateCriminal.getGender());
	        }

	        if(updateCriminal.getName() != null){
	            criminal.setName(updateCriminal.getName());
	        }

	        if(updateCriminal.getIdentifyingMark() != null){
	            criminal.setIdentifyingMark(updateCriminal.getIdentifyingMark());
	        }

	        if(updateCriminal.getFirstArrestDate() != null){
	            criminal.setFirstArrestDate(updateCriminal.getFirstArrestDate());
	        }

	        if(updateCriminal.getArrestedFromPsArea() != null){
	            criminal.setArrestedFromPsArea(updateCriminal.getArrestedFromPsArea());
	        }

	        CriminalRepository.CriminalRepo.put(id,criminal);

	        return criminal.getName()+" successfully Updated !!";
	    }

	    public String deleteCriminalByCriminalId(int id){
	        CriminalRepository.CriminalRepo.remove(id);
	        return "criminal "+id+" successfully removed !!";
	    }

	    public Criminal searchCriminalByName(String name){
	        if(CriminalRepository.CriminalNameRepo.containsKey(name)){
	            return CriminalRepository.CriminalNameRepo.get(name);
	        }
	        return null;
	    }
	}
