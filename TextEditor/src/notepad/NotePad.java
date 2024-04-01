package notepad;

import action.Action;
import java.util.*;
import java.time.LocalDateTime;

public class NotePad 
{
  private int id = 1;
  private String notepad[];
  private Stack<Action> undoAction;
  private Stack<Action> redoAction;
  private Queue<String> clipBoard;
  private int capacity;

  public NotePad(int capacity)
  {
    notepad=new String[capacity];
    for(int i=0;i<capacity;i++)
    {
        notepad[i]="";
    }
    this.capacity=capacity;
    undoAction=new Stack<>();
    redoAction=new Stack<>();
    clipBoard=new LinkedList<>();
  }

  public void display()
  {
    for(int i=0;i<this.capacity;i++)
    {
        System.out.println(notepad[i]);
    }
  }

  public void display(int startingLine,int endingLine)
  {
    if(startingLine<1 || startingLine>endingLine || endingLine>this.capacity)
    {
        System.out.println("Unable to display text, please check the input");
        return;
    }
    for(int i=startingLine-1;i<endingLine;i++)
    {
        System.out.println(notepad[i]);
    }
  }

  public void insert(int lineNumber,String text)
  {
    if(lineNumber>this.capacity)
    {
        System.out.println("Note Pad limit crossed");
        return;
    }
    notepad[lineNumber-1]=text;
    undoAction.push(new Action(id++,LocalDateTime.now(),lineNumber,text,true));
  }

  public void delete(int lineNumber)
  {
    if(lineNumber<1 || lineNumber>this.capacity )
    {
        System.out.println("No such row to delete");
        return;
    }
    if(notepad[lineNumber-1].isEmpty())
    {
        System.out.println("Nothing to delete");
        return;
    }
    redoAction.push(new Action(id++,LocalDateTime.now(),lineNumber,notepad[lineNumber-1],false));
    notepad[lineNumber-1]="";
  }

  public void delete(int startingLine,int endingLine)
  {
    if(startingLine>endingLine || endingLine>this.capacity)
    {
        System.out.println("Unable to delete, please check the input");
        return;
    }
    for(int i=startingLine;i<=endingLine;i++)
    {
        delete(i);
    }
    display();
  }

  public void insert(int startingLine,int endingLine)
  {
    Scanner sc=new Scanner(System.in);
    if(startingLine<1 || startingLine>endingLine || endingLine>this.capacity)
    {
        System.out.println("Unable to add text, please check the input");
        return;
    }
    for(int i=startingLine;i<=endingLine;i++)
    {
       String text=sc.nextLine();
       insert(i,text);
    }
  }

  public void copy(int startingLine,int endingLine)
  {
    if(startingLine>endingLine || startingLine<1 || endingLine>this.capacity)
    {
      System.out.println("Unable to copy");
      return;
    }
    String copyText="";
    for(int i=startingLine-1;i<endingLine;i++)
    {
      copyText+=(notepad[i]+"\n");
    }
    if(!copyText.isEmpty())
      clipBoard.add(copyText);
  }

  public void copy(int lineNumber)
  {
    if(lineNumber<1 || lineNumber>this.capacity )
    {
        System.out.println("No such row to delete");
        return;
    }
    if(notepad[lineNumber-1].isEmpty())
    {
        System.out.println("Nothing to copy");
        return;
    }
    clipBoard.add(notepad[lineNumber-1]);
  }

  public void paste(int lineNumber)
  {
    if(clipBoard.isEmpty())
    {
      System.out.println("Nothing to paste");
      return;
    }
    String text=clipBoard.peek();
    insert(lineNumber,text);
  }

  public void undo()
  {
    if(this.undoAction.isEmpty())
    {
      System.out.println("Nothing to undo");
      return;
    }
    Action action=this.undoAction.peek();
    this.undoAction.pop();
    delete(action.getLineNo());
    display();
  }

  public void redo()
  {
    if(this.redoAction.isEmpty())
    {
      System.out.println("Nothing to redo");
      return;
    }
    Action action=this.redoAction.peek();
    this.redoAction.pop();
    insert(action.getLineNo(),action.getText());
    display();
  }
}
