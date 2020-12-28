package db_project;


/*@author S-R-H Khan
 */
public class Table {
private String ID_Ad,Name1,other;
private Integer Total_SUM,Members,Total_tickets;

    public Table(String ID_Ad, String Name1, Integer Total_tickets,Integer Total_SUM) {
        this.ID_Ad = ID_Ad;
        this.Name1 = Name1;
        this.Total_SUM = Total_SUM;
        this.Total_tickets = Total_tickets;
    }

    public Table(String ID_Ad, String Name1, Integer Total_SUM) {
        this.ID_Ad = ID_Ad;
        this.Name1 = Name1;
        this.Total_SUM = Total_SUM;
    }

    public Table(String Name1, Integer Total_SUM) {
        this.Name1 = Name1;
        this.Total_SUM = Total_SUM;
    }

    public Table(String ID_Ad, String Name1, String other, Integer Total_SUM) {
        this.ID_Ad = ID_Ad;
        this.Name1 = Name1;
        this.other = other;
        this.Total_SUM = Total_SUM;
    }

    public Table(String Name1, Integer Members, Integer Total_SUM) {
        this.Name1 = Name1;
        this.Total_SUM = Total_SUM;
        this.Members = Members;
    }

    public Table(Integer Members, Integer Total_tickets) {
        this.Members = Members;
        this.Total_tickets = Total_tickets;
    }
    

  
    

    public String getID_Ad() {
        return ID_Ad;
    }

    public void setID_Ad(String ID_Ad) {
        this.ID_Ad = ID_Ad;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String Name1) {
        this.Name1 = Name1;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public int getTotal_SUM() {
        return Total_SUM;
    }

    public void setTotal_SUM(Integer Total_SUM) {
        this.Total_SUM = Total_SUM;
    }

    public int getMembers() {
        return Members;
    }

    public void setMembers(Integer Members) {
        this.Members = Members;
    }

    public int getTotal_tickets() {
        return Total_tickets;
    }

    public void setTotal_tickets(Integer Total_tickets) {
        this.Total_tickets = Total_tickets;
    }
    
    

}
