
package prescription;


import java.util.Scanner;

public class Prescription {
 
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String response;

                        
            do{
            System.out.println("1. CREATE");
            System.out.println("2. READ");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            
            System.out.print("Enter action: ");
            int action = sc.nextInt();
            
            
            
                Prescription Prescription = new Prescription();
            
            switch(action){
                case 1:
                   Prescription.addPrescription();
                   break;
                   
                case 2:
                    Prescription.viewPrescription();
                   break;
                
                case 3:
                    Prescription.updatePrescription();  
                    break;
                    
                case 4:
                    Prescription.deletePrescription();
                    break;
                    
                case 5:
                    System.out.println("Existing....");
                    break;
                    
                default:
                    System.out.println("Invalid action.Please try again.");         
            }
            System.out.println("Do you want to contimue? (yes/no): ");
            response = sc.next();
            }while (response.equalsIgnoreCase("yes"));
            System.out.println("Thank you, See you soonest!");
           
        }
   
        public void addPrescription(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Prescription id: ");
        int pid = sc.nextInt();
        
        System.out.print("Prescription date: ");
        String pdate = sc.next();
        
        System.out.print("Medicatiion name: ");
        String mname = sc.next();
        
        System.out.print("Prescription dosage: ");
        String pdosage = sc.next();
        
     
        String sql = "INSERT INTO Prescription (p_id, p_date, m_name,p_dosage) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, pid, pdate, mname, pdosage);
 }
        
        private void viewPrescription(){
            config conf = new config();
            
            String qry = "SELECT * FROM PRESCRIPTION";
            String[] header = {"ID", "Date", "NAME", "DOSAGE"};
            String[] column = {"p_id", "p_date", "m_name", "p_dosage"};
                    
            conf.viewsRecord(qry, header, column);
        }
        
        
        public void updatePrescription(){
            Scanner scan = new Scanner (System.in);
            config conf = new config();
            
            System.out.print("Enter Id to update: ");
            int pid = scan.nextInt();
            
            System.out.print(" Prescription date: ");
            String pdate = scan.next();

            System.out.print("Medication name: ");
            String mname  = scan.next();

            System.out.print("Prescription dosage: ");
            String pdosage = scan.next();

           
            
            String qry = "UPDATE Prescription SET p_date = ?, m_name = ?, p_dosage = ?  WHERE s_id = ?";
            
            conf.updateRecord(pdate, mname, pdosage);
        
        }
        public void deletePrescription(){
            Scanner scan = new Scanner (System.in);
            config conf = new config();
            
            System.out.print("Enter Id to update: ");
            int pid;
            pid = scan.nextInt();
            
            String qry = "DELETE FROM Prescription Where p_id = ?";
            conf.deleteRecord(qry, pid);
           
        }
   
}