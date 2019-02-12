
public class EmpPay
{
  private String empid;
  private String salary;
  private String bonus;
  
  public EmpPay()
  {
	  empid=salary=bonus=null;
  }
  public EmpPay(String empid,String salary,String bonus)
  {
	  this.empid=empid;
	  this.salary=salary;
	  this.bonus=bonus;
  }
  
  public String getEmpId()
  {
   return(empid);
  }
  public String getSalary()
  {
	  return(salary);
  }
  public String getBonus()
  {
	  return(bonus);
  }
  @Override
  public String toString()
  {
	  return(salary + "  " + bonus);
  }
}
