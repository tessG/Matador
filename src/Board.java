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



    /**
     * Config data bør læses fra en fil, fx csv med flg. (eller lign.) format
     *
     * index, type, navn, udgift, indtægt
     * 1, Start, Start,0,30000
     * 2, Land, Rødovrevej, 1200, 100
     * 4, Land, Hvidovrevej, 1200, 100
     * 5, Tax, Skat, 4000, 0
     * 6, ShipplingLine, Limfjorden A/S  , 4000,1000
     * 3, Event, Prøv Lykken, 0, 0
     * */

    private static String[] loadConfig(){
        String[] config = new String[6];

        config[0] = "1, Start, Start, 0, 4000";
        config[1] = "2, Land, Rødovrevej, 1200, 100";
        config[2] = "3, Event, Prøv Lykken, 0, 0";
        config[3] = "4, Land, Hvidovrevej, 1200, 100";
        config[4] = "5, Tax, Skat, 4000, 0";
        config[5] = "6, ShippingLine, Limfjorden A/S, 4000, 1000";

        return config;
    }

   /* public String getFields() {



    }*/
}
