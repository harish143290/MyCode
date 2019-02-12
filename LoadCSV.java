

import java.io.*;
import java.util.*;

public class LoadCSV 
{
	static Map<String,String> emp;
	static Map<String,String> salary;
	static Map<String,String> leftjoin;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			emp=readFile("employee_names.csv",1);
			salary=readFile("employee_pay.csv",2);
			
			//System.out.println("Loaded " + emp.size() + "---" + salary.size());
			leftjoin=leftJoin(emp,salary);
		
			System.out.println("Id\t\t\t  FirstName \tLastName\tSalary\t\t     Bonus\n");
			for(Map.Entry<String,String> entry : leftjoin.entrySet())
			{
				System.out.printf("%-28s %-13s %-15s",entry.getKey(),entry.getValue().split(",")[0],entry.getValue().split(",")[1]);
				System.out.printf("%-19s%-10s\n",entry.getValue().split(",")[2],entry.getValue().split(",")[3]);
				
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error : " + ex);
		}
	}
	
	//method that performs left join on Employoeename and employeepay
	
	static HashMap<String,String> leftJoin(Map<String,String> master ,Map<String,String> child)
	{
		Map<String,String> results=new HashMap<String,String>();
		
		String totalvalue="";
		for(Map.Entry<String,String> entry : master.entrySet())
		{
			totalvalue=entry.getValue().split(",")[0] + "," + entry.getValue().split(",")[1] + ",";
			
			if(child.containsKey(entry.getKey()))
			{
			//	System.out.printf("%-19s%-10s\n",child.get(entry.getKey()).split(",")[0],child.get(entry.getKey()).split(",")[1]);
				totalvalue+=child.get(entry.getKey()).split(",")[0] + "," + child.get(entry.getKey()).split(",")[1];
				results.put(entry.getKey(),totalvalue);
			}
			else
			{
				totalvalue+="NULL,NULL";
				results.put(entry.getKey(), totalvalue);
			}
		}
		return (HashMap<String, String>) (results);
	}
	
	//method that reads .CSV file and loads into Memory Object of Map
	static HashMap<String,String> readFile(String fname,int order) throws Exception
	{
		Map<String,String> container;
			 container=new HashMap<String, String>();
		
		
		FileInputStream fis;
		BufferedReader br;
		String line="";
		String []parts;
		if(order==1)
		{
		EmpMain em;
		fis=new FileInputStream(fname);
		br=new BufferedReader(new InputStreamReader(fis));
		line=br.readLine();
		line=br.readLine();
		while(line!=null)
		{
				parts=line.split(",");
				em=new EmpMain(parts[0],parts[1],parts[2]);
				if(!container.containsKey(em.getEmpid()))
					container.put(em.getEmpid(),em.getFname() + "," + em.getLname());
				line=br.readLine();
		}
		br.close();
		fis.close();
		}
		else
		{
			EmpPay ep;
			fis=new FileInputStream(fname);
			br=new BufferedReader(new InputStreamReader(fis));
			line=br.readLine();
			line=br.readLine();
			Vector<String> attribues=new Vector<String>();
			while(line!=null)
			{
			parts=line.split(",");
			for(String st : parts)
			  attribues.add(st);
						
					if(attribues.size()==2)
					ep=new EmpPay(attribues.get(0),attribues.get(1),null);
					else
						ep=new EmpPay(attribues.get(0),attribues.get(1),attribues.get(2));
					if(!container.containsKey(ep.getEmpId()))
						container.put(ep.getEmpId(),ep.getSalary() + "," + ep.getBonus());
					line=br.readLine();
					attribues.clear();
			}	
			br.close();
			fis.close();
		}
		return (HashMap<String, String>) (container);
	}
}
