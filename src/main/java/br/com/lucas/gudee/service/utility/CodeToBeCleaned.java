package br.com.lucas.gudee.service.utility;

import java.util.ArrayList;
import java.util.List;

public class CodeToBeCleaned {

	
	public static List<Integer> toConvert(String tex){
		//utilizar ....
		System.out.println("ok aqui");
		String guues = ",";
		List<Integer> valore = new ArrayList<>();
		
		if(tex.indexOf(guues) != -1) {
			
	
		List<Integer> local = new ArrayList<>();
		local.add(0);
		for (int index = tex.indexOf(guues); index >= 0; index = tex.indexOf(guues, index + 1)) {
			 
			local.add(index);
		}

		int con = 0;
		for (Integer integer : local) {

			if (con == 0 && local.size() > 1) {
				String a = tex.substring(0, local.get(1));
				valore.add(Integer.parseInt(a));
			}
			if (local.size() < 1) {
				valore.add(Integer.parseInt(tex));
			}
			con++;
			if (con != local.size()) {
				String a = tex.substring(integer + 1, local.get(con));
			  
			   if(!a.equals(""))
			 	valore.add(Integer.parseInt(a));
			}
			if (con == local.size()) {
				String a = tex.substring(integer + 1, tex.length());
				valore.add(Integer.parseInt(a));
				 
			}

		}
	 
		}else {			
			valore.add(Integer.parseInt(tex));
		}
		
		return valore;
		
	}
	
}
