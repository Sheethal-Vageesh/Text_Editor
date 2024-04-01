import notepad.NotePad;
import java.util.*;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
       Scanner sc=new Scanner(System.in);
       NotePad notepad=new NotePad(100);
       int choice;
       do
       {
         System.out.println("choose your option");
         System.out.println("1 : Display the text\n2 : Display the from given line");
         System.out.println("3 : Insert the text");
         System.out.println("4 : Delete the text\n5 : Delete from given lines");
         System.out.println("6 : Copy the text\n7 : copy the text from given lines");
         System.out.println("8 : Past the text");
         System.out.println("9 : Undo your action");
         System.out.println("10 : Redo your action");
         System.out.println("11 : Exit");

         System.out.print("\nEnter your choice : ");
         choice=sc.nextInt();
         int startLine,endLine,lineNo;
         String text;

         switch(choice)
         {
            case 1:notepad.display();
                   break;
            case 2:System.out.println("Enter the starting line and ending line : ");
                   startLine=sc.nextInt();
                   endLine=sc.nextInt();            
                   notepad.display(startLine,endLine);
                   break;
            case 3:System.out.println("Enter the line number : ");
                    lineNo=sc.nextInt();
                    System.out.println("Enter the text : ");
                   text=sc.next();
                   notepad.insert(lineNo,text);
                   break;
            case 4:System.out.println("Enter the line number : ");
                   lineNo=sc.nextInt();
                   notepad.delete(lineNo);
                   break;
            case 5:System.out.println("Enter the starting line and ending line : ");
                   startLine=sc.nextInt();
                   endLine=sc.nextInt();            
                   notepad.delete(startLine,endLine);
                   break;
            case 6:System.out.println("Enter the line number : ");
                   lineNo=sc.nextInt();
                   notepad.copy(lineNo);
                   break;
            case 7:System.out.println("Enter the starting line and ending line : ");
                   startLine=sc.nextInt();
                   endLine=sc.nextInt();            
                   notepad.copy(startLine,endLine);
                   break;
            case 8:System.out.println("Enter the line number : ");
                   lineNo=sc.nextInt();
                   notepad.paste(lineNo);
                   break;
            case 9:notepad.undo();
                   break;
            case 10:notepad.redo();
                   break;
            case 11: System.out.println("Exit from the program");
                     System.exit(0);
                     break;
            default:System.out.println("Invalid choice ");
                   break;
         }
       }while(choice!=11);
       
        sc.close();
    }
}
