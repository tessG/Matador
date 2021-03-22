public class Board {
    static Field[] fields = new Field[40];


   public Board(){

       setFields();

   }
/**
 *
 *  This method reads configuration, and for each line, creates a Field instance of the right type
 *
 * */
    private static void setFields() {
        Field field = null;
       String[] config = loadConfig();
      for(int i = 0; i< config.length;i++){
          String [] fieldData = config[i].split(",");

          String fieldtype = fieldData[1].trim();
          int id = Integer.parseInt(fieldData[0]);
          String label = fieldData[2].trim();
          int cost = Integer.parseInt(fieldData[3].trim());
          int income = Integer.parseInt(fieldData[4].trim());

          switch(fieldtype){
              case "Start": field = new Start(id, label, income);
              break;
              case "Land": field = new Land(id, label, cost, income);
                  break;
              case "Event": field = new Event(id, label);
                  break;
              case "Tax": field = new Tax(id, label, cost);
                  break;
              case "ShippingLine": field = new ShippingLine(id, label,cost, income);
                  break;
          }
          fields[id-1] = field;
      }

    }
    public Field getField(int index) {
        for(int i = 0; i < fields.length; i++) {
            if(fields[i].id == index) {
                return fields[i];
            }
        }
        //hvis den ikke finder et felt med det index
        return null;
    }


    /**
     * Config data bør læses fra en fil, fx csv med flg. (eller lign.) format
     *
     * */

    private static String[] loadConfig(){
        String[] config = new String[40];

        config[0] = "1, Start, Start, 0, 30000";
        config[1] = "2, Land, Rødovrevej, 1200, 100";
        config[2] = "3, Event, Prøv Lykken, 0, 0";
        config[3] = "4, Land, Hvidovrevej, 1200, 100";
        config[4] = "5, Tax, Skat, 4000, 0";
        config[5] = "6, ShippingLine, Limfjorden A/S, 4000, 1000";
        config[6] = "7, Land, Roskildevej, 2000, 200";
        config[7] = "8, Event, Prøv Lykken, 0, 0";
        config[8] = "9, Land, Valby langegade, 2000, 200";
        config[9] = "10, Land, Allergade, 2400, 250";
        config[10] = "11, Prison, Fængsel, 0, 0";//------------------------------------error
        config[11] = "12, Land, Frederiksberg Alle, 2800, 250";
        config[12] = "13, Brewery, Coca cola, 3000, 250";
        config[13] = "14, Land, Burlowsvej, 2800, 250";
        config[14] = "15, Land, Gl.Kongevej, 3200, 250";
        config[15] = "16, ShippingLine, Danmark, 4000, 250";
        config[16] = "17, Land, Børnestoffsvej, 3600, 250";
        config[17] = "18, Event, Prøv lykken, 0, 0";
        config[18] = "19, Land, Hellerupvej, 3600, 250";
        config[19] = "20, Land, Strandvej, 4000, 250";
        config[20] = "21, Parkering, Den danske bank, 3600, 250";//----------------------error??
        config[21] = "22, Land, Trianglen, 4400, 250";
        config[22] = "23, Event, Prøv lykken, 0, 0";
        config[23] = "24, Land, Østerbrogade, 4400, 250";
        config[24] = "25, Land, Grenningen, 4800, 250";
        config[25] = "26, ShippingLine, Mols-Linien, 4000, 250";
        config[26] = "27, Land, Bredgade, 5200, 250";
        config[27] = "28, Land, Kgs.Nytorv, 5200, 250";
        config[28] = "29, Brewery, Carlsberg, 3000, 250";
        config[29] = "30, Land, Østergade, 5600, 250";
        config[30] = "31, Prison, Fængsel, 0, 0";//------------------------------------error
        config[31] = "32, Land, Amagertorv, 6000, 250";
        config[32] = "33, Land, Vimmelskattet, 6000, 250";
        config[33] = "34, Event, Prøv lykken, 0, 0";
        config[34] = "35, Land, Nybrogade, 6400, 100";
        config[35] = "36, ShippingLine, Skandinavisk Linietrafik, 4000, 100";
        config[36] = "37, Event, Prøv lykken, 0, 0";
        config[37] = "38, Land, Frederiksberggade , 7000, 100";
        config[38] = "39, Tax, Skat, 2000, 0";
        config[39] = "40, Land, Råhuspladsen, 8000, 100";

        return config;
    }

   /* public String getFields() {



    }*/
}
