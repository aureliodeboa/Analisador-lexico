/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analisadorlexico;

/**
 *
 * @author aurel
 */
public class Scanner {
    private char currentChar= 'a'; //receber primeiro caracter do arquivo
    private byte currentKind;
    private StringBuffer currentSpelling;
    private void take (char expectedChar){
        if (currentChar == expectedChar){
            currentSpelling.append(currentChar);
            //currentChar = colocar leitura de arquivo; 
        } else 
            System.out.println("ERRO LEXICO"); // escrever no arquivo de saida erro
    }
      
       private void takeIt(){
     currentSpelling.append(currentChar);
     //currentChar = colocar leitura de arquivo; 
     
}
       
       private boolean isDigit(char c){
           
           return (c >= '0' && c <= '9');
       }
       private boolean isLetter (char c){
           return (c >= 'a' && c <= 'z') || (c>='A' && c <='Z');
           
       }
       private boolean isGraphic (char c){
           int i = c;
           return (i>= 32);
           
           
       }
       
       private void scanSeparator() {
           switch (currentChar) {
               case '!': {
                   takeIt(); 
                   while ( isGraphic(currentChar))
                       takeIt();
                       take('\n');
               } break;
               case ' ' : case '\n' : takeIt(); break;
           }
       }
       
       private byte scanToken () {
   switch(currentChar){
       case 'a' : case 'b' : case 'c' : case 'd': case 'e': case 'f':
        case 'g': case 'h' : case 'i': case 'j' : case 'k' : case 'l' : case 'm': case 'n' : case 'o':
       case 'p' : case 'q':  case'r' :case 's' : case 't' : case 'u': case 'v': case 'w': case 'y': case 'z': case 'x':
         
           case 'A': case 'B' : case 'C' : case 'D': case 'E':case 'F':
            case'G' :case 'H' :case 'I': case 'J': case'K': case'L': case'M': case'N': case'O':
            case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U':case 'V':case 'W': case 'Y': case 'Z': case 'X':   
                
           takeIt();
         
           while(isLetter (currentChar)||isDigit(currentChar)) takeIt();  
         return Token.IDENTIFIER;
     
      case'0': case'1': case'2': case'3': case'4':
      case'5': case'6': case'7': case'8': case'9':
          takeIt();
          while(isDigit(currentChar))
              takeIt();
          return Token.INTLITERAL;
          
      case '+' :  takeIt(); return Token.ADD; 
      case '-' : takeIt(); return Token.SUB; 
      case '|': takeIt(); return Token.OR;  
      case '*' : takeIt(); return Token.MUL;
      case '/' : takeIt(); return Token.DIV;
      case '&' :takeIt(); return Token.AND;
      case '<' : takeIt();if (currentChar == '='){takeIt(); return Token.MENQI;} else { if (currentChar == '>'){takeIt(); return Token.DIF;}return Token.MENQ;} 
      case '>' : takeIt();if (currentChar == '='){takeIt(); return Token.MAIQI;} return Token.MAIQ;
      case '=' : takeIt(); return Token.IGUA; 
      //case '<>' : takeIt(); return Token.DIF;
      case '.' : takeIt(); return Token.DOT; 
      case '!' : takeIt(); return Token.COMEN;
      //case ';' : takeIt(); return Token.SEMICOLON;
      case ')' : takeIt(); return Token.RPAREN;
      case '(' : takeIt(); return Token.LPAREN;
      case ':' : takeIt(); if(currentChar == '='){takeIt();return Token.BECOMES;}
      else return Token.COLON;
      case '\000' : takeIt(); return Token.EOT;
      
      default : return Token.ERROR;
      }
           
}
       
       public  Token scan(){
           while (currentChar == '!'|| currentChar == ' ' ||currentChar == '\n')
               scanSeparator();
           currentSpelling= new StringBuffer ("");
           currentKind = scanToken();
           return new Token (currentKind,currentSpelling.toString());
           
           
       }
       
       
      
    
}

  
