public static String FirstReverse(String str) { 
  
    char[] stringToReverse = str.toCharArray();
    String blank = "";
    for(int x = stringToReverse.length - 1; x >= 0; x--){
        blank += stringToReverse[x];
    }
       
    return blank;
    
  } 

public static String SecondReverse(String str) { 
  
    char[] stringToReverse = str.toCharArray();
    int x = 0;
    int y = stringToReverse.length - 1;
    while(x < y){
        char temp = stringToReverse[y];
        stringToReverse[y] = stringToReverse[x];
        stringToReverse[x] = temp;
        x++;
        y--;
    }
    
    return new String(stringToReverse);
    
  } 