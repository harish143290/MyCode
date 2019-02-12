
public class EmpMain
{
   private String empid;
   private String fname;
   private String lname;
   
   public EmpMain()
   {
	   empid=fname=lname="NA";
   }
   
   public EmpMain(String empid,String fname,String lname)
   {
	   this.empid=empid;
	   this.fname=fname;
	   this.lname=lname;
   }
   public String getEmpid()
   {
	   return(empid);
   }
   public String getFname()
   {
   return(fname);
   }
   public String getLname()
   {
	   return(lname);
   }
   @Override
   public String toString()
   {
	   return(empid + "  " + fname + "  " + lname);
   }
}
