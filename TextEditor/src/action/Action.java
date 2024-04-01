package action;

import java.time.LocalDateTime;

public class Action 
{
   private int actionId;
   private LocalDateTime dateTime;
   private int lineNo ;
   private String text;
   private boolean isAddition;

   public Action(int actionId,LocalDateTime dateTime,int lineNo,String text,boolean isAddition)
   {
    this.actionId=actionId;
    this.dateTime=dateTime;
    this.lineNo=lineNo;
    this.text=text;
    this.isAddition=isAddition;
   }

   public Action()
   {
    
   }

   public void setActionId(int actionId)
   {
     this.actionId=actionId;
   }

   public int getActionId()
   {
    return this.actionId;
   }

   public void setDateTime(LocalDateTime dateTime)
   {
    this.dateTime=dateTime;
   }

   public LocalDateTime getDateTime()
   {
    return this.dateTime;
   }

   public void setLineNo(int lineNo)
   {
    this.lineNo=lineNo;
   }

   public int getLineNo()
   {
    return this.lineNo;
   }

   public void  setText(String text)
   {
    this.text=text;
   }

   public String getText()
   {
    return this.text;
   }

   public void setIsAddition(boolean isAddition)
   {
    this.isAddition=isAddition;
   }

   public boolean getIsAddition()
   {
    return this.isAddition;
   }
}
