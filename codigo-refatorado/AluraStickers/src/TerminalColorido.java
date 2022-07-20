
public class TerminalColorido {
  // Declaring ANSI_RESET so that we can reset the color
  public static final String ANSI_RESET = "\u001B[0m";
  
  // Declaring the color
  // Custom declaration
  public static final String ANSI_YELLOW = "\u001B[34m";

  // Main driver method
  public static void main(String[] args)
  { 
  }
  public String colorirTexto(String txt){
    // Printing the text on console prior adding
      // the desired color
    String texto = ANSI_YELLOW
                      + txt + ANSI_RESET;
    return texto;
  }
}
